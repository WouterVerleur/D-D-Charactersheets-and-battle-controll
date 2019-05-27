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

import java.awt.event.ItemEvent;

import com.wouter.dndbattle.objects.enums.SkillType;
import com.wouter.dndbattle.objects.impl.AbstractCharacter;
import com.wouter.dndbattle.utils.Characters;
import com.wouter.dndbattle.utils.GlobalUtils;
import com.wouter.dndbattle.view.DicePopup;
import com.wouter.dndbattle.view.IUpdateablePanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Wouter
 */
class SkillPanel extends javax.swing.JPanel implements IUpdateablePanel {

    private static final Logger log = LoggerFactory.getLogger(SkillPanel.class);

    private final SkillType skillType;
    private final AbstractCharacter character;
    private final AbilityAndSkillPanel abilityAndSkillPanel;

    SkillPanel(AbstractCharacter character, SkillType skillType, AbilityAndSkillPanel abilityAndSkillPanel) {
        this.character = character;
        this.skillType = skillType;
        this.abilityAndSkillPanel = abilityAndSkillPanel;
        initComponents();
        update();
    }

    @Override
    public final void update() {
        log.debug("Recieved an update for [{}]", skillType);
        lModifier.setText(GlobalUtils.modifierToString(character.getSkillModifier(skillType)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lModifier = new javax.swing.JLabel();
        cbProficiency = new com.wouter.dndbattle.view.comboboxes.ProficiencyComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), skillType.toString(), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        lModifier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lModifier.setText("0");
        lModifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lModifierMouseClicked(evt);
            }
        });

        cbProficiency.setSelectedItem(character.getSkillProficiency(skillType));
        cbProficiency.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProficiencyItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(cbProficiency, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lModifier)
                .addComponent(cbProficiency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbProficiencyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProficiencyItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            character.setSkillProficiency(skillType, cbProficiency.getSelectedItem());
            Characters.getInstance().update(character);
            abilityAndSkillPanel.updatePanels();
        }
    }//GEN-LAST:event_cbProficiencyItemStateChanged

    private void lModifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lModifierMouseClicked
        DicePopup dicePopup = new DicePopup(character.getSkillModifier(skillType), D20, skillType.toString());
        dicePopup.setLocationRelativeTo(lModifier);
        dicePopup.setVisible(true);
    }//GEN-LAST:event_lModifierMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.wouter.dndbattle.view.comboboxes.ProficiencyComboBox cbProficiency;
    private javax.swing.JLabel lModifier;
    // End of variables declaration//GEN-END:variables
}
