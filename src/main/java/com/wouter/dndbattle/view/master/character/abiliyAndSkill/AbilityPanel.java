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
package com.wouter.dndbattle.view.master.character.abiliyAndSkill;

import static com.wouter.dndbattle.objects.enums.Dice.D20;

import com.wouter.dndbattle.objects.enums.AbilityType;
import com.wouter.dndbattle.objects.impl.AbstractCharacter;
import com.wouter.dndbattle.utils.Characters;
import com.wouter.dndbattle.view.DicePopup;
import com.wouter.dndbattle.view.IUpdateablePanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Wouter
 */
class AbilityPanel extends javax.swing.JPanel implements IUpdateablePanel {

    private static final Logger log = LoggerFactory.getLogger(AbilityPanel.class);

    private final AbilityType abilityType;
    private final AbstractCharacter character;
    private final AbilityAndSkillPanel abilityAndSkillPanel;

    AbilityPanel(AbstractCharacter character, AbilityType abilityType, AbilityAndSkillPanel abilityAndSkillPanel) {
        this.character = character;
        this.abilityType = abilityType;
        this.abilityAndSkillPanel = abilityAndSkillPanel;
        initComponents();
        updateLabel();
    }

    @Override
    public void update() {
        updateLabel();
        sScore.setValue(character.getAbilityScore(abilityType));
    }

    private void updateLabel() {
        int modifier = character.getAbilityModifier(abilityType);
        lModifier.setText(modifier > 0 ? "+" + modifier : Integer.toString(modifier));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lModifier = new javax.swing.JLabel();
        sScore = new javax.swing.JSpinner();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), abilityType.getFullName(), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        setName(""); // NOI18N

        lModifier.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lModifier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lModifier.setText("0");
        lModifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lModifierMouseClicked(evt);
            }
        });

        sScore.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));
        sScore.setValue(character.getAbilityScore(abilityType));
        sScore.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sScoreStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lModifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sScore, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lModifier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sScoreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sScoreStateChanged
        character.setAbilityScore(abilityType, (int) sScore.getValue());
        abilityAndSkillPanel.updatePanels();
        Characters.getInstance().update(character);
    }//GEN-LAST:event_sScoreStateChanged

    private void lModifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModifierMouseClicked
        DicePopup dicePopup = new DicePopup(character.getAbilityModifier(abilityType), D20, abilityType.getFullName());
        dicePopup.setLocationRelativeTo(lModifier);
        dicePopup.setVisible(true);
    }//GEN-LAST:event_lModifierMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lModifier;
    private javax.swing.JSpinner sScore;
    // End of variables declaration//GEN-END:variables
}
