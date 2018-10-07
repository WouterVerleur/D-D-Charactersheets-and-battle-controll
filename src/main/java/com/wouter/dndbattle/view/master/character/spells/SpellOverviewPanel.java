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
package com.wouter.dndbattle.view.master.character.spells;

import static com.wouter.dndbattle.utils.Settings.SPELLS_GRID_COLUMNS;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import com.wouter.dndbattle.objects.enums.AbilityType;
import com.wouter.dndbattle.objects.impl.AbstractCharacter;
import com.wouter.dndbattle.objects.impl.Spell;
import com.wouter.dndbattle.utils.Characters;
import com.wouter.dndbattle.utils.GlobalUtils;
import com.wouter.dndbattle.utils.Settings;
import com.wouter.dndbattle.view.IUpdateablePanel;

/**
 *
 * @author Wouter
 */
public class SpellOverviewPanel extends javax.swing.JPanel implements IUpdateablePanel {

    private static final Settings SETTINGS = Settings.getInstance();
    public static final String ABILITY_FORMAT = "%d / %s";
    private static final int DEFAULT_COLUMNS = 4;

    private final AbstractCharacter character;

    public SpellOverviewPanel(AbstractCharacter character) {
        this.character = character;
        initComponents();
        updatePanels();
    }

    @Override
    public void update() {
        updatePanels();
        updateLabels();
    }

    private void updatePanels() {
        pSpells.removeAll();
        character.getSpells().stream().filter((spell) -> (spell instanceof Spell)).forEachOrdered((spell) -> {
            //pSpells.add(new J);
        });
    }

    private void updateLabels() {
        lSpellcastingAbility.setText(getAbilityString());
        lSpellSaveDC.setText(getSpellSaveDC());
        lSpellAttackBonus.setText(getSpellAttackBonus());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbSpellModifier = new com.wouter.dndbattle.view.comboboxes.AbilityTypeComboBox();
        lSpellcastingAbility = new javax.swing.JLabel();
        lSpellSaveDC = new javax.swing.JLabel();
        lSpellAttackBonus = new javax.swing.JLabel();
        sSpellColumns = new javax.swing.JSlider();
        bNew = new javax.swing.JButton();
        spSpells = new javax.swing.JScrollPane();
        pSpells = new javax.swing.JPanel();

        cbSpellModifier.setSelectedItem(character.getSpellCastingAbility());
        cbSpellModifier.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSpellModifierItemStateChanged(evt);
            }
        });

        lSpellcastingAbility.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lSpellcastingAbility.setText(getAbilityString());
        lSpellcastingAbility.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Spellcasting Ability", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        lSpellSaveDC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lSpellSaveDC.setText(getSpellSaveDC());
        lSpellSaveDC.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Spell Save DC", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        lSpellAttackBonus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lSpellAttackBonus.setText(getSpellAttackBonus());
        lSpellAttackBonus.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Spell Attack Bonus", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        sSpellColumns.setMaximum(5);
        sSpellColumns.setMinimum(1);
        sSpellColumns.setMinorTickSpacing(1);
        sSpellColumns.setPaintTicks(true);
        sSpellColumns.setSnapToTicks(true);
        sSpellColumns.setValue(SETTINGS.getProperty(SPELLS_GRID_COLUMNS, DEFAULT_COLUMNS)
        );
        sSpellColumns.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sSpellColumnsStateChanged(evt);
            }
        });

        bNew.setText("New");
        bNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewActionPerformed(evt);
            }
        });

        spSpells.setBorder(null);

        pSpells.setLayout(new java.awt.GridLayout(0, sSpellColumns.getValue(), 5, 5));
        spSpells.setViewportView(pSpells);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spSpells)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sSpellColumns, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbSpellModifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lSpellcastingAbility, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lSpellSaveDC, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lSpellAttackBonus, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSpellModifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lSpellcastingAbility)
                    .addComponent(lSpellSaveDC)
                    .addComponent(lSpellAttackBonus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spSpells, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sSpellColumns, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bNew, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        character.addSpell(new Spell());
        saveCharacter();
        update();
    }//GEN-LAST:event_bNewActionPerformed

    private void cbSpellModifierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSpellModifierItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            character.setSpellCastingAbility(cbSpellModifier.getSelectedItem());
            saveCharacter();
            update();
        }
    }//GEN-LAST:event_cbSpellModifierItemStateChanged

    private void sSpellColumnsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sSpellColumnsStateChanged
        ((GridLayout) pSpells.getLayout()).setColumns(sSpellColumns.getValue());
        pSpells.revalidate();
        SETTINGS.setProperty(SPELLS_GRID_COLUMNS, sSpellColumns.getValue());
    }//GEN-LAST:event_sSpellColumnsStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bNew;
    private com.wouter.dndbattle.view.comboboxes.AbilityTypeComboBox cbSpellModifier;
    private javax.swing.JLabel lSpellAttackBonus;
    private javax.swing.JLabel lSpellSaveDC;
    private javax.swing.JLabel lSpellcastingAbility;
    private javax.swing.JPanel pSpells;
    private javax.swing.JSlider sSpellColumns;
    private javax.swing.JScrollPane spSpells;
    // End of variables declaration//GEN-END:variables

    public void saveCharacter() {
        character.sortSpells();
        Characters.getInstance().updateCharacter(character);
    }

    private String getAbilityString() {
        AbilityType spellAbility = character.getSpellCastingAbility();
        if (spellAbility != null) {
            return String.format(ABILITY_FORMAT, character.getAbilityScore(spellAbility), GlobalUtils.modifierToString(character.getAbilityModifier(spellAbility)));
        }
        return " ";
    }

    private String getSpellAttackBonus() {
        AbilityType spellAbility = character.getSpellCastingAbility();
        int modifier = character.getProficiencyScore();
        if (spellAbility != null) {
            modifier += character.getAbilityModifier(spellAbility);
        }
        return GlobalUtils.modifierToString(modifier);
    }

    private String getSpellSaveDC() {
        AbilityType spellAbility = character.getSpellCastingAbility();
        int modifier = 8 + character.getProficiencyScore();
        if (spellAbility != null) {
            modifier += character.getAbilityModifier(spellAbility);
        }
        return Integer.toString(modifier);
    }

    public void removeSpell(Spell spell) {
        character.removeSpell(spell);
    }
}
