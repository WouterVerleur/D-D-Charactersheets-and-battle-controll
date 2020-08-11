/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dndbattle.view.master;

import java.util.List;
import java.util.Random;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import org.dndbattle.objects.IArmor;
import org.dndbattle.objects.impl.AbstractCharacter;
import org.dndbattle.objects.impl.Combatant;
import org.dndbattle.utils.Armors;
import org.dndbattle.utils.GlobalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Integer.MIN_VALUE;

/**
 *
 * @author Wouter
 */
public class AddCombatantPanel extends javax.swing.JPanel {

    private static final Logger log = LoggerFactory.getLogger(AddCombatantPanel.class);
    private final AbstractCharacter character;
    private boolean warned = false;

    public AddCombatantPanel(AbstractCharacter character) {
        this.character = character;
        initComponents();
    }

    private ComboBoxModel<IArmor> getArmorCbModel() {
        List<IArmor> armors = Armors.getInstance().getAll();
        IArmor[] armorArray = new IArmor[armors.size()];
        armors.toArray(armorArray);
        return new DefaultComboBoxModel<>(armorArray);
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
        lHealth = new javax.swing.JLabel();
        lInitiative = new javax.swing.JLabel();
        cbHealth = new javax.swing.JCheckBox();
        tfInitiative = new javax.swing.JTextField();
        bRoll = new javax.swing.JButton();
        sHealth = new javax.swing.JSpinner();
        cbFriendly = new javax.swing.JCheckBox();
        cbHidden = new javax.swing.JCheckBox();
        lArmor = new javax.swing.JLabel();
        cbArmor = new javax.swing.JComboBox<>();
        lArmorClass = new javax.swing.JLabel();
        lSpacer = new javax.swing.JLabel();
        cbAddAnother = new javax.swing.JCheckBox();

        setLayout(new java.awt.GridBagLayout());

        lName.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 67;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(lName, gridBagConstraints);

        tfName.setText(character.getName());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfName, gridBagConstraints);

        lHealth.setText("Health");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 64;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(lHealth, gridBagConstraints);

        lInitiative.setText("Initiative (roll " + GlobalUtils.modifierToString(character.getInitiative()) + ')');
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    add(lInitiative, gridBagConstraints);

    cbHealth.setText("Health is not full");
    cbHealth.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbHealthActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
    add(cbHealth, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    add(tfInitiative, gridBagConstraints);

    bRoll.setText("Roll");
    bRoll.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            bRollActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
    add(bRoll, gridBagConstraints);

    sHealth.setModel(new javax.swing.SpinnerNumberModel(character.getMaxHealth(), 1, character.getMaxHealth(), 1));
    sHealth.setEnabled(false);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 0.25;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    add(sHealth, gridBagConstraints);

    cbFriendly.setSelected(character.isFriendly());
    cbFriendly.setText("Friendly");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    add(cbFriendly, gridBagConstraints);

    cbHidden.setText("Hidden");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
    add(cbHidden, gridBagConstraints);

    lArmor.setText("Armor");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    add(lArmor, gridBagConstraints);

    cbArmor.setModel(getArmorCbModel());
    cbArmor.setSelectedItem(character.getArmor());
    cbArmor.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            cbArmorItemStateChanged(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
    add(cbArmor, gridBagConstraints);

    lArmorClass.setText(character.getArmorClassString());
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 0.5;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
    add(lArmorClass, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    add(lSpacer, gridBagConstraints);

    cbAddAnother.setText("Add another");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.gridwidth = 4;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
    add(cbAddAnother, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cbHealthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHealthActionPerformed
        sHealth.setEnabled(cbHealth.isSelected());
    }//GEN-LAST:event_cbHealthActionPerformed

    private void cbArmorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbArmorItemStateChanged
        if (!warned && (character.getArmor() == null || !character.getArmor().equals(cbArmor.getSelectedItem()))) {
            JOptionPane.showMessageDialog(this, "Warning!\nChanging the armor of a character here is also stored in all other places this character is used.\nHowever this is not saved to the permanent storage.", "Warning", JOptionPane.WARNING_MESSAGE);
            warned = true;
        }
        character.setArmor((IArmor) cbArmor.getSelectedItem());
        lArmorClass.setText(character.getArmorClassString());
    }//GEN-LAST:event_cbArmorItemStateChanged

    private void bRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRollActionPerformed
        int throwResult = new Random().nextInt(20) + 1;
        tfInitiative.setText(Integer.toString(throwResult + character.getInitiative()));
        bRoll.setText("Roll (" + throwResult + ')');
    }//GEN-LAST:event_bRollActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRoll;
    private javax.swing.JCheckBox cbAddAnother;
    private javax.swing.JComboBox<IArmor> cbArmor;
    private javax.swing.JCheckBox cbFriendly;
    private javax.swing.JCheckBox cbHealth;
    private javax.swing.JCheckBox cbHidden;
    private javax.swing.JLabel lArmor;
    private javax.swing.JLabel lArmorClass;
    private javax.swing.JLabel lHealth;
    private javax.swing.JLabel lInitiative;
    private javax.swing.JLabel lName;
    private javax.swing.JLabel lSpacer;
    private javax.swing.JSpinner sHealth;
    private javax.swing.JTextField tfInitiative;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables

    public Combatant getCombatant() {
        String name = tfName.getText();
        int initiative = MIN_VALUE;
        int health = MIN_VALUE;
        try {
            health = cbHealth.isSelected() ? (int) sHealth.getValue() : character.getMaxHealth();
        } catch (NumberFormatException e) {
            log.warn("Unable to parse input as number.", e);
        }
        try {
            initiative = Integer.parseInt(tfInitiative.getText());
        } catch (NumberFormatException e) {
            log.warn("Unable to parse input as number.", e);
        }
        if (name.isEmpty()) {
            tfName.requestFocus();
            return null;
        }
        if (health == MIN_VALUE) {
            if (cbHealth.isSelected()) {
                sHealth.requestFocus();
                return null;
            }
        }
        if (initiative == MIN_VALUE) {
            tfInitiative.requestFocus();
            return null;
        }
        Combatant combatant;
        if (health != MIN_VALUE) {
            combatant = new Combatant(character, name, initiative, health);
        } else {
            combatant = new Combatant(character, name, initiative);
        }
        combatant.setFriendly(cbFriendly.isSelected());
        combatant.setHidden(cbHidden.isSelected());
        return combatant;
    }

    public boolean isAddAnother() {
        return cbAddAnother.isSelected();
    }
}
