/*
 * Copyright (C) 2018 Wouter
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.wouter.dndbattle.view.master.weapons;

import javax.swing.table.DefaultTableModel;

import com.wouter.dndbattle.objects.IWeapon;
import com.wouter.dndbattle.objects.impl.Weapon;
import com.wouter.dndbattle.utils.Settings;
import com.wouter.dndbattle.utils.Weapons;
import com.wouter.dndbattle.view.IUpdateablePanel;

/**
 *
 * @author Wouter
 */
public class WeaponsPanel extends javax.swing.JPanel implements IUpdateablePanel {

    public static final String ABILITY_FORMAT = "%d / %s";
    private static final int DEFAULT_COLUMNS = 4;

    private static final Settings SETTINGS = Settings.getInstance();
    private static final Weapons weapons = Weapons.getInstance();

    public WeaponsPanel() {
        initComponents();
        update();
    }

    @Override
    public final void update() {
        DefaultTableModel tSimpleModel = (DefaultTableModel) tSimple.getModel();
        DefaultTableModel tMartialModel = (DefaultTableModel) tMartial.getModel();
        tSimpleModel.setRowCount(0);
        tMartialModel.setRowCount(0);
        for (IWeapon weapon : weapons.getWeapons()) {

        }
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

        lSimple = new javax.swing.JLabel();
        bNewSimple = new javax.swing.JButton();
        spSimple = new javax.swing.JScrollPane();
        tSimple = new javax.swing.JTable();
        lMartial = new javax.swing.JLabel();
        bNewMartial = new javax.swing.JButton();
        spMartial = new javax.swing.JScrollPane();
        tMartial = new javax.swing.JTable();

        setLayout(new java.awt.GridBagLayout());

        lSimple.setText("Simple Weapons");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(lSimple, gridBagConstraints);

        bNewSimple.setText("New");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(bNewSimple, gridBagConstraints);

        tSimple.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        spSimple.setViewportView(tSimple);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(spSimple, gridBagConstraints);

        lMartial.setText("Martial Weapons");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(lMartial, gridBagConstraints);

        bNewMartial.setText("New");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(bNewMartial, gridBagConstraints);

        tMartial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        spMartial.setViewportView(tMartial);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(spMartial, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bNewMartial;
    private javax.swing.JButton bNewSimple;
    private javax.swing.JLabel lMartial;
    private javax.swing.JLabel lSimple;
    private javax.swing.JScrollPane spMartial;
    private javax.swing.JScrollPane spSimple;
    private javax.swing.JTable tMartial;
    private javax.swing.JTable tSimple;
    // End of variables declaration//GEN-END:variables

    public void removeSpell(Weapon weapon) {
        weapons.remove(weapon);
    }

    void saveWeapon(Weapon weapon) {
        weapons.updateWeapon(weapon);
    }
}