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
package org.dndbattle.view.master.weapons;

import org.dndbattle.objects.enums.WeaponRange;
import org.dndbattle.objects.enums.WeaponType;
import org.dndbattle.objects.impl.Weapon;
import org.dndbattle.utils.Weapons;

/**
 *
 * @author Wouter
 */
public class WeaponEditPanel extends javax.swing.JPanel {

    private final Weapon weapon;

    public WeaponEditPanel(Weapon weapon) {
        this.weapon = weapon;
        initComponents();
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

        lName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lDamage = new javax.swing.JLabel();
        sDiceAmount = new javax.swing.JSpinner();
        cbDice = new org.dndbattle.view.comboboxes.DiceComboBox();
        tfDamage = new javax.swing.JTextField();
        lRange = new javax.swing.JLabel();
        cbRange = new org.dndbattle.view.comboboxes.WeaponRangeComboBox();
        sRange = new javax.swing.JSpinner();
        lSlash = new javax.swing.JLabel();
        sMaxRange = new javax.swing.JSpinner();
        cbFinesse = new javax.swing.JCheckBox();
        cbTwoHanded = new javax.swing.JCheckBox();
        cbLoading = new javax.swing.JCheckBox();
        cbCanUseMagicStats = new javax.swing.JCheckBox();
        cbProficient = new javax.swing.JCheckBox();
        lWeight = new javax.swing.JLabel();
        sWeight = new javax.swing.JSpinner();
        cbWeight = new org.dndbattle.view.comboboxes.WeaponWeightComboBox();
        lAttackModifier = new javax.swing.JLabel();
        sAttackModifier = new javax.swing.JSpinner();
        lDamageModifier = new javax.swing.JLabel();
        sDamageModifier = new javax.swing.JSpinner();
        lNotes = new javax.swing.JLabel();
        tfNotes = new javax.swing.JTextField();
        lValue = new javax.swing.JLabel();
        tfValue = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        lName.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(lName, gridBagConstraints);

        tfName.setText(weapon.getName());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfName, gridBagConstraints);

        lDamage.setText("Damage");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(lDamage, gridBagConstraints);

        sDiceAmount.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        sDiceAmount.setValue(weapon.getAmountOfAttackDice());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(sDiceAmount, gridBagConstraints);

        cbDice.setSelectedItem(weapon.getAttackDice());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(cbDice, gridBagConstraints);

        tfDamage.setText(weapon.getDamageType());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfDamage, gridBagConstraints);

        lRange.setText("Range");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(lRange, gridBagConstraints);

        cbRange.setSelectedItem(weapon.getWeaponRange());
        cbRange.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRangeItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(cbRange, gridBagConstraints);

        sRange.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 10));
        sRange.setEnabled(weapon.getWeaponRange().isRanged() || weapon.getWeaponRange() == WeaponRange.REACH);
        sRange.setValue(weapon.getRange());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(sRange, gridBagConstraints);

        lSlash.setText("/");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(lSlash, gridBagConstraints);

        sMaxRange.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 10));
        sMaxRange.setEnabled(weapon.getWeaponRange().isRanged());
        sMaxRange.setValue(weapon.getMaxRange());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(sMaxRange, gridBagConstraints);

        cbFinesse.setSelected(weapon.isFinesse());
        cbFinesse.setText("Finesse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(cbFinesse, gridBagConstraints);

        cbTwoHanded.setSelected(weapon.isTwoHanded());
        cbTwoHanded.setText("Two-handed");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(cbTwoHanded, gridBagConstraints);

        cbLoading.setSelected(weapon.isLoading());
        cbLoading.setText("Loading");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(cbLoading, gridBagConstraints);

        cbCanUseMagicStats.setSelected(weapon.isCanUseMagicStats());
        cbCanUseMagicStats.setText("Can use magical stats");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(cbCanUseMagicStats, gridBagConstraints);

        cbProficient.setSelected(weapon.isProficient());
        cbProficient.setText("Proficient");
        cbProficient.setVisible(weapon.getType() == WeaponType.PERSONAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(cbProficient, gridBagConstraints);

        lWeight.setText("Weight");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(lWeight, gridBagConstraints);

        sWeight.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));
        sWeight.setValue(weapon.getWeight());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(sWeight, gridBagConstraints);

        cbWeight.setSelectedItem(weapon.getWeightClass());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(cbWeight, gridBagConstraints);

        lAttackModifier.setText("Attack modifier");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(lAttackModifier, gridBagConstraints);

        sAttackModifier.setModel(new javax.swing.SpinnerNumberModel());
        sAttackModifier.setValue(weapon.getAttackModifier());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(sAttackModifier, gridBagConstraints);

        lDamageModifier.setText("Damage modifier");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(lDamageModifier, gridBagConstraints);

        sDamageModifier.setModel(new javax.swing.SpinnerNumberModel());
        sDamageModifier.setValue(weapon.getDamageModifier());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(sDamageModifier, gridBagConstraints);

        lNotes.setText("Notes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(lNotes, gridBagConstraints);

        tfNotes.setText(weapon.getActualNotes());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfNotes, gridBagConstraints);

        lValue.setText("Value");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(lValue, gridBagConstraints);

        tfValue.setText(weapon.getValue());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfValue, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cbRangeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRangeItemStateChanged
        WeaponRange selection = cbRange.getSelectedItem();
        sRange.setEnabled(selection.isRanged() || selection == WeaponRange.REACH);
        sMaxRange.setEnabled(selection.isRanged());
    }//GEN-LAST:event_cbRangeItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbCanUseMagicStats;
    private org.dndbattle.view.comboboxes.DiceComboBox cbDice;
    private javax.swing.JCheckBox cbFinesse;
    private javax.swing.JCheckBox cbLoading;
    private javax.swing.JCheckBox cbProficient;
    private org.dndbattle.view.comboboxes.WeaponRangeComboBox cbRange;
    private javax.swing.JCheckBox cbTwoHanded;
    private org.dndbattle.view.comboboxes.WeaponWeightComboBox cbWeight;
    private javax.swing.JLabel lAttackModifier;
    private javax.swing.JLabel lDamage;
    private javax.swing.JLabel lDamageModifier;
    private javax.swing.JLabel lName;
    private javax.swing.JLabel lNotes;
    private javax.swing.JLabel lRange;
    private javax.swing.JLabel lSlash;
    private javax.swing.JLabel lValue;
    private javax.swing.JLabel lWeight;
    private javax.swing.JSpinner sAttackModifier;
    private javax.swing.JSpinner sDamageModifier;
    private javax.swing.JSpinner sDiceAmount;
    private javax.swing.JSpinner sMaxRange;
    private javax.swing.JSpinner sRange;
    private javax.swing.JSpinner sWeight;
    private javax.swing.JTextField tfDamage;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfNotes;
    private javax.swing.JTextField tfValue;
    // End of variables declaration//GEN-END:variables

    public Weapon getWeapon() {
        Weapon returnWeapon;
        if (weapon.getType() == WeaponType.PERSONAL) {
            returnWeapon = weapon;
            returnWeapon.setName(tfName.getText());
        } else if (weapon.getName() == null) {
            returnWeapon = weapon;
            returnWeapon.setName(tfName.getText());
            Weapons.getInstance().add(returnWeapon);
        } else if (weapon.getName().equals(tfName.getText())) {
            returnWeapon = weapon;
        } else {
            Weapons.getInstance().remove(weapon);
            returnWeapon = new Weapon(weapon.getType());
            returnWeapon.setName(tfName.getText());
            Weapons.getInstance().add(returnWeapon);
        }
        returnWeapon.setAmountOfAttackDice((int) sDiceAmount.getValue());
        returnWeapon.setAttackDice(cbDice.getSelectedItem());
        returnWeapon.setAttackModifier((int) sAttackModifier.getValue());
        returnWeapon.setDamageModifier((int) sDamageModifier.getValue());
        returnWeapon.setDamageType(tfDamage.getText());
        returnWeapon.setMaxRange((int) sMaxRange.getValue());
        returnWeapon.setType(returnWeapon.getType());
        returnWeapon.setWeaponRange(cbRange.getSelectedItem());
        returnWeapon.setWeight((float) sWeight.getValue());
        returnWeapon.setWeightClass(cbWeight.getSelectedItem());
        returnWeapon.setCanUseMagicStats(cbCanUseMagicStats.isSelected());
        returnWeapon.setLoading(cbLoading.isSelected());
        returnWeapon.setActualNotes(tfNotes.getText());
        returnWeapon.setRange((int) sRange.getValue());
        returnWeapon.setFinesse(cbFinesse.isSelected());
        returnWeapon.setTwoHanded(cbTwoHanded.isSelected());
        returnWeapon.setProficient(cbProficient.isSelected());
        returnWeapon.setValue(tfValue.getText());
        return returnWeapon;
    }
}
