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
package com.wouter.dndbattle.view.master.character.weapon;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.wouter.dndbattle.objects.IWeapon;
import com.wouter.dndbattle.objects.impl.AbstractCharacter;
import com.wouter.dndbattle.objects.impl.Weapon;
import com.wouter.dndbattle.utils.Characters;
import com.wouter.dndbattle.utils.GlobalUtils;
import com.wouter.dndbattle.view.IUpdateablePanel;
import com.wouter.dndbattle.view.master.character.CharacterPanel;

/**
 *
 * @author Wouter
 */
public class WeaponsPanel extends javax.swing.JPanel implements IUpdateablePanel {

    private final AbstractCharacter character;
    private final CharacterPanel characterPanel;

    public WeaponsPanel(AbstractCharacter character, CharacterPanel characterPanel) {
        this.character = character;
        this.characterPanel = characterPanel;
        initComponents();
        updateTable();
    }

    @Override
    public void update() {
        updateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lWarning1 = new javax.swing.JLabel();
        lWarning2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tWeapons = new javax.swing.JTable();
        bNew = new javax.swing.JButton();
        lSeperator = new javax.swing.JLabel();
        bEdit = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        lWarning1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lWarning1.setText("Please enter special stats for weapons as seperate weapons.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(lWarning1, gridBagConstraints);

        lWarning2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lWarning2.setText("This includes versitile, magically imbued or option for throwing.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(lWarning2, gridBagConstraints);

        tWeapons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Attack bonus", "Damage", "Notes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tWeapons.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tWeapons.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tWeapons);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 256;
        gridBagConstraints.ipady = 72;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(jScrollPane1, gridBagConstraints);

        bNew.setText("New");
        bNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(bNew, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        add(lSeperator, gridBagConstraints);

        bEdit.setText("Edit");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        add(bEdit, gridBagConstraints);

        bDelete.setText("Delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        add(bDelete, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        new WeaponFrame(new Weapon(), character, true, this).setVisible(true);
    }//GEN-LAST:event_bNewActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        Weapon weapon = getSelectedWeapon();
        if (weapon != null) {
            new WeaponFrame(weapon, character, false, this).setVisible(true);
        }
    }//GEN-LAST:event_bEditActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        Weapon weapon = getSelectedWeapon();
        if (weapon != null) {
            character.removeWeapon(weapon);
        }
        Characters.updateCharacter(character);
        updateTable();
    }//GEN-LAST:event_bDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bNew;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lSeperator;
    private javax.swing.JLabel lWarning1;
    private javax.swing.JLabel lWarning2;
    private javax.swing.JTable tWeapons;
    // End of variables declaration//GEN-END:variables

    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) tWeapons.getModel();
        model.setRowCount(0);
        character.getWeapons().forEach((weapon) -> {
            model.addRow(GlobalUtils.getWeaponRow(character, weapon));
        });
    }

    private Weapon getSelectedWeapon() {
        int index = tWeapons.getSelectedRow();
        List<IWeapon> weapons = character.getWeapons();
        if (index >= 0 && index < weapons.size()) {
            return (Weapon) weapons.get(index);
        }
        return null;
    }

    public void updateAll() {
        characterPanel.updateAll();
    }
}
