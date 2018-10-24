/*
 * Copyright (C) 2018 wverl
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
package com.wouter.dndbattle.view.master.spells;

import java.awt.event.ItemEvent;

import javax.swing.JOptionPane;

import com.wouter.dndbattle.objects.ISpell;
import com.wouter.dndbattle.objects.impl.Spell;
import com.wouter.dndbattle.utils.Characters;
import com.wouter.dndbattle.utils.GlobalUtils;
import com.wouter.dndbattle.utils.Spells;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wverl
 */
class SpellPanel extends javax.swing.JPanel {

    private static final Logger log = LoggerFactory.getLogger(SpellPanel.class);

    private final Spell spell;
    private final SpellsPanel overviewPanel;

    SpellPanel(Spell spell, SpellsPanel overviewPanel) {
        this.spell = spell;
        this.overviewPanel = overviewPanel;
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
        psmallFields = new javax.swing.JPanel();
        tfCastingTime = new javax.swing.JTextField();
        tfRange = new javax.swing.JTextField();
        tfComponents = new javax.swing.JTextField();
        tfDuration = new javax.swing.JTextField();
        spNotes = new javax.swing.JScrollPane();
        taNotes = new javax.swing.JTextArea();
        spDescription = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        tfType = new javax.swing.JTextField();
        cbSpellLevel = new com.wouter.dndbattle.view.comboboxes.SpellLevelComboBox();
        bDelete = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        lName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lName.setText(getSpellName());
        lName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lNameMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(lName, gridBagConstraints);

        psmallFields.setLayout(new java.awt.GridLayout(2, 2));

        tfCastingTime.setBackground(GlobalUtils.getBackgroundTransparent());
        tfCastingTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCastingTime.setText(spell.getCastingTime());
        tfCastingTime.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Casting Time", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        tfCastingTime.setOpaque(false);
        tfCastingTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCastingTimeFocusLost(evt);
            }
        });
        psmallFields.add(tfCastingTime);

        tfRange.setBackground(GlobalUtils.getBackgroundTransparent());
        tfRange.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfRange.setText(spell.getRange());
        tfRange.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Range", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        tfRange.setOpaque(false);
        tfRange.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfRangeFocusLost(evt);
            }
        });
        psmallFields.add(tfRange);

        tfComponents.setBackground(GlobalUtils.getBackgroundTransparent());
        tfComponents.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfComponents.setText(spell.getComponents());
        tfComponents.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Components", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        tfComponents.setOpaque(false);
        tfComponents.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfComponentsFocusLost(evt);
            }
        });
        psmallFields.add(tfComponents);

        tfDuration.setBackground(GlobalUtils.getBackgroundTransparent());
        tfDuration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDuration.setText(spell.getDuration());
        tfDuration.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Duration", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        tfDuration.setOpaque(false);
        tfDuration.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDurationFocusLost(evt);
            }
        });
        psmallFields.add(tfDuration);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(psmallFields, gridBagConstraints);

        spNotes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Notes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        spNotes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                spNotesFocusLost(evt);
            }
        });

        taNotes.setBackground(GlobalUtils.getBackgroundTransparent());
        taNotes.setColumns(20);
        taNotes.setLineWrap(true);
        taNotes.setRows(5);
        taNotes.setText(spell.getNotes());
        taNotes.setToolTipText("Description");
        taNotes.setWrapStyleWord(true);
        taNotes.setOpaque(false);
        taNotes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                taNotesKeyReleased(evt);
            }
        });
        spNotes.setViewportView(taNotes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(spNotes, gridBagConstraints);

        taDescription.setBackground(GlobalUtils.getBackgroundTransparent());
        taDescription.setColumns(20);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        taDescription.setText(spell.getDescription());
        taDescription.setToolTipText("Description");
        taDescription.setWrapStyleWord(true);
        taDescription.setCaretPosition(0);
        taDescription.setOpaque(false);
        taDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                taDescriptionFocusLost(evt);
            }
        });
        spDescription.setViewportView(taDescription);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(spDescription, gridBagConstraints);

        tfType.setBackground(GlobalUtils.getBackgroundTransparent());
        tfType.setText(spell.getType());
        tfType.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        tfType.setOpaque(false);
        tfType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfTypeFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(tfType, gridBagConstraints);

        cbSpellLevel.setSelectedItem(spell.getLevel());
        cbSpellLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSpellLevelItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        add(cbSpellLevel, gridBagConstraints);

        bDelete.setText("Delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(bDelete, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cbSpellLevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSpellLevelItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            spell.setLevel(cbSpellLevel.getSelectedItem());
            overviewPanel.saveSpell(spell);
        }
    }//GEN-LAST:event_cbSpellLevelItemStateChanged

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        switch (JOptionPane.showConfirmDialog(this, "Are you sure you wish to delete the spell " + spell + "?\n\nThis cannot be undone!", "Please confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)) {
            case JOptionPane.YES_OPTION:
                overviewPanel.removeSpell(spell);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void lNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lNameMouseClicked
        Object input = JOptionPane.showInputDialog(this, "Please enter the new name", "Rename", JOptionPane.QUESTION_MESSAGE, null, null, spell.getName());
        if (input instanceof String) {
            String newName = (String) input;
            ISpell oldSpell = spell.clone();
            if (spell instanceof Spell) {
                ((Spell) spell).setName(newName);
                if (Spells.getInstance().add(spell)) {
                    Spells.getInstance().remove(oldSpell);
                    Characters.getInstance().updateAll(spell.getUsers());
                }
            }
            overviewPanel.update();
        }
    }//GEN-LAST:event_lNameMouseClicked

    private void taNotesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taNotesKeyReleased
        spell.setNotes(taNotes.getText().trim());
        overviewPanel.saveSpell(spell);
    }//GEN-LAST:event_taNotesKeyReleased

    private void tfCastingTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCastingTimeFocusLost
        spell.setCastingTime(tfCastingTime.getText().trim());
        overviewPanel.saveSpell(spell);
    }//GEN-LAST:event_tfCastingTimeFocusLost

    private void tfRangeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfRangeFocusLost
        spell.setRange(tfRange.getText().trim());
        overviewPanel.saveSpell(spell);
    }//GEN-LAST:event_tfRangeFocusLost

    private void tfComponentsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfComponentsFocusLost
        spell.setComponents(tfComponents.getText().trim());
        overviewPanel.saveSpell(spell);
    }//GEN-LAST:event_tfComponentsFocusLost

    private void tfDurationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDurationFocusLost
        spell.setDuration(tfDuration.getText().trim());
        overviewPanel.saveSpell(spell);
    }//GEN-LAST:event_tfDurationFocusLost

    private void spNotesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spNotesFocusLost
        spell.setNotes(taNotes.getText().trim());
        overviewPanel.saveSpell(spell);
    }//GEN-LAST:event_spNotesFocusLost

    private void taDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_taDescriptionFocusLost
        spell.setDescription(taDescription.getText().trim());
        overviewPanel.saveSpell(spell);
    }//GEN-LAST:event_taDescriptionFocusLost

    private void tfTypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTypeFocusLost
        spell.setType(tfType.getText().trim());
        overviewPanel.saveSpell(spell);
    }//GEN-LAST:event_tfTypeFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDelete;
    private com.wouter.dndbattle.view.comboboxes.SpellLevelComboBox cbSpellLevel;
    private javax.swing.JLabel lName;
    private javax.swing.JPanel psmallFields;
    private javax.swing.JScrollPane spDescription;
    private javax.swing.JScrollPane spNotes;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextArea taNotes;
    private javax.swing.JTextField tfCastingTime;
    private javax.swing.JTextField tfComponents;
    private javax.swing.JTextField tfDuration;
    private javax.swing.JTextField tfRange;
    private javax.swing.JTextField tfType;
    // End of variables declaration//GEN-END:variables

    private String getSpellName() {
        String spellName = spell.getName();
        if (spellName == null || spellName.isEmpty()) {
            return EMPTY_SPELL_NAME;
        }
        return spellName;
    }
    private static final String EMPTY_SPELL_NAME = " ";
}
