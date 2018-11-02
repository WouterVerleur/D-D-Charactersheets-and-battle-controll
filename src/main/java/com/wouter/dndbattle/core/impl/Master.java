/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wouter.dndbattle.core.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;

import com.wouter.dndbattle.core.IMaster;
import com.wouter.dndbattle.core.ISlave;
import com.wouter.dndbattle.objects.ICombatant;
import com.wouter.dndbattle.objects.impl.Combatant;
import com.wouter.dndbattle.utils.Settings;
import com.wouter.dndbattle.view.master.MasterFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.wouter.dndbattle.utils.Settings.ROLLFORDEATH;
import static com.wouter.dndbattle.utils.Settings.SLAVE_TITLE;

/**
 *
 * @author Wouter
 */
public class Master extends AbstractRemoteConnector implements IMaster {

    private static final Logger log = LoggerFactory.getLogger(Master.class);

    private static final Settings SETTINGS = Settings.getInstance();
    private boolean battleStarted;
    private List<ICombatant> combatants = new ArrayList<>();
    private MasterFrame frame;
    private final List<ISlave> slaves = new ArrayList<>();
    private int currentIndex = 0;

    private final ExecutorService executor = Executors.newWorkStealingPool();

    public Master() {
    }

    /**
     * @return the frame
     */
    public MasterFrame getFrame() {
        if (frame == null) {
            createFrame();
        }
        return frame;
    }

    private synchronized void createFrame() {
        if (frame == null) {
            frame = new MasterFrame(this);
        }
    }

    public void addCombatant(Combatant combatant) {
        ICombatant currectActive = null;
        if (combatants.size() > 0 && battleStarted) {
            currectActive = combatants.get(currentIndex);
        }
        combatants.add(combatant);
        Collections.sort(combatants);
        if (currectActive != null) {
            currentIndex = combatants.indexOf(currectActive);
        }
        updateAll(true);
    }

    public void removeCombatant(ICombatant combatant) {
        combatants.remove(combatant);
        updateAll(true);
    }

    @Override
    public void connect(ISlave slave) throws RemoteException {
        connect(slave, "");
    }

    @Override
    public void connect(ISlave slave, String playerName) throws RemoteException {
        connect(slave, playerName, slave.getIp());
    }

    @Override
    public void connect(ISlave slave, String playerName, String slaveIp) throws RemoteException {
        slaves.add(slave);
        boolean localhost = false;
        String localhostAddress = null;
        try {
            localhostAddress = InetAddress.getLocalHost().getHostAddress();
            localhost = slaveIp.equalsIgnoreCase(localhostAddress);
        } catch (UnknownHostException e) {
            log.error("Error while determining if connection if from localhost", e);
        }
        log.debug("Recieved new slave connection from [{}] for which localhost was [{}] fors remote host [{}] and localhost [{}]", playerName, localhost, slaveIp, localhostAddress);
        slave.setConnectionInfo(new MasterConnectionInfo(SETTINGS.getProperty(SLAVE_TITLE, "Slave"), localhost, playerName));
        slave.refreshView(true);
    }

    @Override
    public void disconnect(ISlave slave) throws RemoteException {
        slaves.remove(slave);
    }

    @Override
    public int getProperty(String key, int defaultValue) throws RemoteException {
        return SETTINGS.getProperty(key, defaultValue);
    }

    @Override
    public void setProperty(String key, int value) throws RemoteException {
        SETTINGS.setProperty(key, value);
    }

    public List<ISlave> getSlaves() {
        return slaves;
    }

    public void nextTurn() {
        battleStarted = true;
        boolean keepSearching = true;
        currentIndex++;
        while (keepSearching) {
            if (combatants.isEmpty()) {
                break;
            }
            if (currentIndex >= combatants.size()) {
                currentIndex = 0;
            }
            ICombatant next = combatants.get(currentIndex);
            if (next.isDead()) {
                removeCombatant(next);
                continue;
            }
            if (next.rollingForDeath() && !SETTINGS.getProperty(ROLLFORDEATH, true)) {
                log.debug("Adding deathroll to [{}]", next);
                JOptionPane.showMessageDialog(getFrame(), "An automatic deathroll was added to " + next, "Automatic deathroll.", JOptionPane.INFORMATION_MESSAGE);
                ((Combatant) next).addDeathRoll();
                if (next.isDead()) {
                    removeCombatant(next);
                } else {
                    currentIndex++;
                }
                continue;
            }
            keepSearching = false;
        }
        if (combatants.isEmpty()) {
            startNewBattle();
        }
        updateAll(false);
    }

    public void shutdown() {
        System.exit(0);
    }

    public void kick(ISlave slave) {
        try {
            slave.shutdown();
        } catch (RemoteException ex) {
            log.error("Attempt to kick [{}] resulted in an error.", slave, ex);
        }
        slaves.remove(slave);
    }

    public void startNewBattle() {
        combatants = new ArrayList<>();
        currentIndex = 0;
        battleStarted = false;
        updateAll(true);
    }

    public void updateAll(boolean refreshCombatants) {
        getFrame().refreshBattle(combatants, currentIndex);
        slaves.forEach((slave) -> {
            executor.submit(() -> {
                try {
                    slave.refreshView(refreshCombatants);
                } catch (RemoteException e) {
                    log.error("Unable to refresh slave [{}]", slave, e);
                }
            });
        });
    }

    @Override
    protected void shutdownHook() {
        slaves.forEach((slave) -> {
            try {
                slave.shutdown();
            } catch (RemoteException e) {
                System.out.println("Unable to shutdown slave " + e);
            }
        });
    }

    @Override
    public List<ICombatant> getCombatants() {
        return combatants;
    }

    public void setCombatants(List<ICombatant> combatants) {
        Collections.sort(combatants);
        currentIndex = 0;
        this.combatants = combatants;
    }

    @Override
    public int getCurrentIndex() {
        return currentIndex;
    }
}
