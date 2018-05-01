/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wouter.dndbattle.view.master;

import com.wouter.dndbattle.core.impl.Master;
import com.wouter.dndbattle.objects.impl.AbstractCharacter;
import com.wouter.dndbattle.objects.impl.Combatant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Integer.MIN_VALUE;

/**
 *
 * @author Wouter
 */
public class AddCombatantFrame extends javax.swing.JFrame {

    private static final Logger log = LoggerFactory.getLogger(AddCombatantFrame.class);
    private final Master master;
    private final AbstractCharacter character;

    public AddCombatantFrame(Master master, AbstractCharacter character) {
        this.master = master;
        this.character = character;
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbHealth = new javax.swing.JCheckBox();
        bAdd = new javax.swing.JButton();
        bAddMore = new javax.swing.JButton();
        tfInitiative = new javax.swing.JTextField();
        bCancel = new javax.swing.JButton();
        sHealth = new javax.swing.JSpinner();
        cbFriendly = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add combatant");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lName.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 67;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(lName, gridBagConstraints);

        tfName.setText(character.getName());
        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 222;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(tfName, gridBagConstraints);

        jLabel4.setText("Health");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 64;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel5.setText("Initiative (r + init)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(jLabel5, gridBagConstraints);

        cbHealth.setText("Health is not full");
        cbHealth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHealthActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(cbHealth, gridBagConstraints);

        bAdd.setText("Add");
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 77;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        getContentPane().add(bAdd, gridBagConstraints);

        bAddMore.setText("Add more");
        bAddMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddMoreActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(bAddMore, gridBagConstraints);

        tfInitiative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfInitiativeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 222;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(tfInitiative, gridBagConstraints);

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        getContentPane().add(bCancel, gridBagConstraints);

        sHealth.setModel(new javax.swing.SpinnerNumberModel(character.getMaxHealth(), 1, character.getMaxHealth(), 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        getContentPane().add(sHealth, gridBagConstraints);

        cbFriendly.setSelected(character.isFriendly());
        cbFriendly.setText("Friendly");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(cbFriendly, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        createCombatant(false);
    }//GEN-LAST:event_bAddActionPerformed

    private void bAddMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddMoreActionPerformed
        createCombatant(true);
    }//GEN-LAST:event_bAddMoreActionPerformed

    private void cbHealthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHealthActionPerformed
        sHealth.setEnabled(cbHealth.isSelected());
    }//GEN-LAST:event_cbHealthActionPerformed

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        createCombatant(true);
    }//GEN-LAST:event_tfNameActionPerformed

    private void tfInitiativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfInitiativeActionPerformed
        createCombatant(true);
    }//GEN-LAST:event_tfInitiativeActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bAddMore;
    private javax.swing.JButton bCancel;
    private javax.swing.JCheckBox cbFriendly;
    private javax.swing.JCheckBox cbHealth;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lName;
    private javax.swing.JSpinner sHealth;
    private javax.swing.JTextField tfInitiative;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables

    private void createCombatant(boolean createMore) {
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
            return;
        }
        if (health == MIN_VALUE) {
            if (cbHealth.isSelected()) {
                sHealth.requestFocus();
                return;
            }
        }
        if (initiative == MIN_VALUE) {
            tfInitiative.requestFocus();
            return;
        }
        Combatant combatant;
        if (health != MIN_VALUE) {
            combatant = new Combatant(character, name, initiative, health);
        } else {
            combatant = new Combatant(character, name, initiative);
        }
        combatant.setFriendly(cbFriendly.isSelected());
        master.addCombatant(combatant);
        if (createMore) {
            CombatantSelectionFrame newFrame = new CombatantSelectionFrame(master);
            newFrame.setLocationRelativeTo(this);
            newFrame.setVisible(true);
        }
        this.dispose();
    }
}
