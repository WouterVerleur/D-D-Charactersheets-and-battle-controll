/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wouter.dndbattle.view.master;

import java.awt.event.ItemEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import com.wouter.dndbattle.core.impl.Master;
import com.wouter.dndbattle.objects.ICharacter;
import com.wouter.dndbattle.objects.impl.AbstractCharacter;
import com.wouter.dndbattle.objects.impl.Combatant;
import com.wouter.dndbattle.utils.Characters;

/**
 *
 * @author Wouter
 */
public class CombatantSelectionFrame extends JFrame {

    private final Master master;
    private final Combatant combatant;

    public CombatantSelectionFrame(Master master) {
        this(master, null);
    }

    public CombatantSelectionFrame(Master master, Combatant combatant) {
        this.master = master;
        this.combatant = combatant;
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

        lType = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCharacters = new javax.swing.JList();
        bCancel = new javax.swing.JButton();
        bNext = new javax.swing.JButton();
        lPresets = new javax.swing.JLabel();
        cbClass = new com.wouter.dndbattle.view.comboboxes.ClassComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select combatant preset");

        lType.setText("Type");

        listCharacters.setModel(new DefaultListModel<ICharacter>
            ());
        jScrollPane1.setViewportView(listCharacters);

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        bNext.setText("Next");
        bNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNextActionPerformed(evt);
            }
        });

        lPresets.setText("Preset");

        cbClass.setSelectedIndex(-1);
        cbClass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbClassItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lPresets, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(lType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(cbClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lType)
                    .addComponent(cbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(lPresets))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancel)
                    .addComponent(bNext))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    private void bNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNextActionPerformed
        if (combatant == null) {
            AbstractCharacter selectedCharacter = (AbstractCharacter) listCharacters.getSelectedValue();
            AddCombatantFrame addCombatantFrame = new AddCombatantFrame(master, selectedCharacter);
            addCombatantFrame.setLocationRelativeTo(this);
            addCombatantFrame.setVisible(true);
        } else {
            ICharacter transformation = (ICharacter) listCharacters.getSelectedValue();
            combatant.transform(transformation);
            master.updateAll(true);
        }
        dispose();
    }//GEN-LAST:event_bNextActionPerformed

    private void cbClassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbClassItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            listCharacters.setListData(Characters.getInstance().getCharacters(cbClass.getSelectedItem()).toArray());
        }
    }//GEN-LAST:event_cbClassItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bNext;
    private com.wouter.dndbattle.view.comboboxes.ClassComboBox cbClass;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lPresets;
    private javax.swing.JLabel lType;
    private javax.swing.JList listCharacters;
    // End of variables declaration//GEN-END:variables
}
