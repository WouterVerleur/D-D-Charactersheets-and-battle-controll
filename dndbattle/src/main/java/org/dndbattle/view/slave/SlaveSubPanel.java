/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dndbattle.view.slave;

import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.dndbattle.objects.ICharacter;
import org.dndbattle.objects.ICombatant;
import org.dndbattle.objects.enums.SpellLevel;
import org.dndbattle.utils.GlobalUtils;

import static org.dndbattle.objects.enums.SpellLevel.CANTRIP;
import static org.dndbattle.objects.enums.SpellLevel.FEATURE;

/**
 *
 * @author Wouter
 */
public class SlaveSubPanel extends javax.swing.JPanel {

    private static final String UNFRIENDLY_FORMAT = "<html>%s<br/>"
            + "This character does not appear to be friendly to you.<br/>"
            + "No further information is available.</html>";

    private final ICombatant combatant;
    private final ICharacter character;
    private final boolean friendly;
    private final SlaveFrame parent;

    public SlaveSubPanel(ICombatant combatant) {
        this(combatant, null);
    }

    public SlaveSubPanel(ICombatant combatant, SlaveFrame parent) {
        this(combatant, parent, false);
    }

    public SlaveSubPanel(ICombatant combatant, SlaveFrame parent, boolean active) {
        this.combatant = combatant;
        this.parent = parent;
        this.character = getCombatantCharacter(combatant);
        friendly = combatant.isFriendly();
        initComponents();
        if (character != null) {
            pbHealth.setVisible(friendly);
            pbHealthBuff.setVisible(friendly);
            if (combatant.isDead()) {
                setBackground(GlobalUtils.getBackgroundDead());
            } else if (combatant.getHealth() == 0) {
                setBackground(GlobalUtils.getBackgroundDown());
            }
        } else {
            setBackground(GlobalUtils.getBackgroundError());
        }
        if (friendly) {
            updateSpellSlots();
        }
        if (active) {
            ((TitledBorder) getBorder()).setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GRAY, Color.BLUE));
        }
    }

    private static ICharacter getCombatantCharacter(ICombatant combatant) {
        if (combatant.isTransformed()) {
            return getCombatantCharacter(combatant.getTransformation());
        }
        return combatant.getCharacter();
    }

    private void updateSpellSlots() {
        int panels = 0;
        for (SpellLevel level : SpellLevel.values()) {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            gridBagConstraints.gridx = panels++;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.weightx = 1;
            gridBagConstraints.weighty = 0;
            gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
            switch (level) {
                case CANTRIP:
                    panels--;
                    break;
                case FEATURE:
                    gridBagConstraints.weighty = 1;
                    pSpellSlots.add(new JLabel(), gridBagConstraints);
                    break;
                default:
                    int spellSlots = character.getSpellSlotsByLevel(level);
                    int usedSpellSlots = combatant.getUsedSpellSlots(level);

                    JPanel panel = new JPanel();
                    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
                    panel.setLayout(boxLayout);

                    panel.add(new JLabel(level.toString()));

                    for (int i = 0; i < spellSlots; i++) {
                        panel.add(new SpellSlotRadioButton(i < usedSpellSlots));
                    }

                    pSpellSlots.add(panel, gridBagConstraints);
                    break;
            }
        }
    }

    private String getDescription() {
        if (friendly) {
            return combatant.getDescription();
        }
        return String.format(UNFRIENDLY_FORMAT, combatant.getDescription());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lDescription = new javax.swing.JLabel();
        pbHealth = new javax.swing.JProgressBar();
        pbHealthBuff = new javax.swing.JProgressBar();
        pSpellSlots = new javax.swing.JPanel();
        bShow = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), combatant.getName(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        setLayout(new java.awt.GridBagLayout());

        lDescription.setText(getDescription());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(lDescription, gridBagConstraints);

        pbHealth.setMaximum(character.getMaxHealth());
        pbHealth.setValue(combatant.getHealth());
        pbHealth.setString(combatant.getHealthString());
        pbHealth.setStringPainted(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(pbHealth, gridBagConstraints);

        pbHealthBuff.setMaximum(1);
        pbHealthBuff.setValue(combatant.getHealthBuff());
        pbHealthBuff.setString(combatant.getHealthBuff()>0?"+"+combatant.getHealthBuff():"");
        pbHealthBuff.setStringPainted(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(pbHealthBuff, gridBagConstraints);

        pSpellSlots.setBackground(GlobalUtils.getBackgroundTransparent());
        pSpellSlots.setOpaque(false);
        pSpellSlots.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(pSpellSlots, gridBagConstraints);

        bShow.setText("Show");
        bShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bShowActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        add(bShow, gridBagConstraints);
        bShow.setVisible(parent != null);
    }// </editor-fold>//GEN-END:initComponents

    private void bShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowActionPerformed
        if (parent != null) {
            parent.createCharacterPanel(combatant);
        }
    }//GEN-LAST:event_bShowActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bShow;
    private javax.swing.JLabel lDescription;
    private javax.swing.JPanel pSpellSlots;
    private javax.swing.JProgressBar pbHealth;
    private javax.swing.JProgressBar pbHealthBuff;
    // End of variables declaration//GEN-END:variables

    private final static class SpellSlotRadioButton extends JRadioButton {

        public SpellSlotRadioButton(boolean selected) {
            setSelected(selected);
            setFocusable(false);
            addActionListener((evt) -> {
                setSelected(selected);
            });
        }
    }
}
