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
package com.wouter.dndbattle.view.slave.character;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import com.wouter.dndbattle.objects.ICharacter;
import com.wouter.dndbattle.objects.ICombatant;
import com.wouter.dndbattle.objects.IExtendedCharacter;
import com.wouter.dndbattle.objects.ISpell;
import com.wouter.dndbattle.objects.IWeapon;
import com.wouter.dndbattle.objects.enums.AbilityType;
import com.wouter.dndbattle.objects.enums.SpellLevel;
import com.wouter.dndbattle.objects.enums.WeaponType;
import com.wouter.dndbattle.utils.GlobalUtils;
import com.wouter.dndbattle.utils.Settings;
import com.wouter.dndbattle.utils.Weapons;
import com.wouter.dndbattle.view.IUpdateablePanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.wouter.dndbattle.utils.Settings.SLAVE_SPELLS_SEPERATOR;
import static com.wouter.dndbattle.view.master.character.spells.SpellOverviewPanel.ABILITY_FORMAT;

/**
 *
 * @author Wouter
 */
public class SlaveCharacterPanel extends javax.swing.JPanel implements IUpdateablePanel {

    private static final Logger log = LoggerFactory.getLogger(SlaveCharacterPanel.class);

    private static final Settings SETTINGS = Settings.getInstance();
    private static final String WEAPON_SELECTION_FORMAT = "gui.slave.%s.weapons.selection";

    private final ICombatant combatant;
    private final ICharacter character;
    private final String selectionString;
    private WeaponSelection selection;

    public SlaveCharacterPanel(ICombatant combatant) {
        this.combatant = combatant;
        this.character = combatant.getCharacter();
        selectionString = String.format(WEAPON_SELECTION_FORMAT, character.getClass().getSimpleName());
        selection = WeaponSelection.valueOf(SETTINGS.getProperty(selectionString, WeaponSelection.ALL.name()));

        setName(character.getName());
        initComponents();
        updateWeaponTable();
        updateSpellTable();
        updateSpellSlots();
    }

    public int getCurrentTab() {
        return tpCharacterPages.getSelectedIndex();
    }

    public void setCurrentTab(int currentTab) {
        tpCharacterPages.setSelectedIndex(currentTab);
    }

    @Override
    public void update() {
        for (Component component : tpCharacterPages.getComponents()) {
            if (component instanceof IUpdateablePanel) {
                ((IUpdateablePanel) component).update();
            }
        }
        updateSpellSlots();
        updateWeaponTable();
        updateSpellTable();
    }

    private void updateSpellSlots() {
        int panels = 0;
        for (SpellLevel level : SpellLevel.values()) {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            gridBagConstraints.gridy = panels++;
            gridBagConstraints.weightx = 1;
            gridBagConstraints.weighty = 0;
            gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
            switch (level) {
                case CANTRIP:
                    panels--;
                    break;
                case FEATURE:
                    gridBagConstraints.weighty = 1;
                    pSpellSlots.add(new JLabel(), gridBagConstraints);
                    break;
                default:
                    int spellSlots = character.getSpellSlotsByLevel(level);
                    int usedSpellSlots = combatant.getUsedSpellSlots(level);

                    JPanel panel = new JPanel();
                    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.X_AXIS);
                    panel.setLayout(boxLayout);

                    panel.add(new JLabel(level.toString()));

                    for (int i = 0; i < spellSlots; i++) {
                        panel.add(new SpellSlotRadioButton(i < usedSpellSlots));
                    }

                    pSpellSlots.add(panel, gridBagConstraints);
                    break;
            }
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

        bgSelection = new javax.swing.ButtonGroup();
        lName = new javax.swing.JLabel();
        tpCharacterPages = new javax.swing.JTabbedPane();
        pWeapons = new javax.swing.JPanel();
        spWeapon = new javax.swing.JScrollPane();
        tWeapons = new javax.swing.JTable();
        lWeaponsSelection = new javax.swing.JLabel();
        rbAllWeapons = new javax.swing.JRadioButton();
        rbProficientWeapons = new javax.swing.JRadioButton();
        rbPersonalWeapons = new javax.swing.JRadioButton();
        pSpells = new javax.swing.JPanel();
        lAbility = new javax.swing.JLabel();
        lSpellcastingAbility = new javax.swing.JLabel();
        lSpellSaveDC = new javax.swing.JLabel();
        lSpellAttackBonus = new javax.swing.JLabel();
        spSpells = new javax.swing.JSplitPane();
        spTableAndSlots = new javax.swing.JSplitPane();
        spSpellTable = new javax.swing.JScrollPane();
        tSpells = new javax.swing.JTable();
        spSpellSlots = new javax.swing.JScrollPane();
        pSpellSlots = new javax.swing.JPanel();
        spInformation = new javax.swing.JScrollPane();
        pInformation = new javax.swing.JPanel();
        spDescription = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        spNotes = new javax.swing.JScrollPane();
        taNotes = new javax.swing.JTextArea();

        lName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lName.setText(character.getName());
        lName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lNameMouseClicked(evt);
            }
        });

        tpCharacterPages.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tpCharacterPages.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tpCharacterPages.addTab("Abilities", new com.wouter.dndbattle.view.slave.character.SlaveAbilityAndSkillPanel(character));
        if (character instanceof IExtendedCharacter){
            tpCharacterPages.addTab("Character", new com.wouter.dndbattle.view.slave.character.SlaveExtendedCharacterPanel((IExtendedCharacter) character));
        }

        pWeapons.setLayout(new java.awt.GridBagLayout());

        tWeapons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Proficient", "Attack bonus", "Damage", "Notes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        spWeapon.setViewportView(tWeapons);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pWeapons.add(spWeapon, gridBagConstraints);

        lWeaponsSelection.setText("Weapons:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        pWeapons.add(lWeaponsSelection, gridBagConstraints);

        bgSelection.add(rbAllWeapons);
        rbAllWeapons.setSelected(selection == WeaponSelection.ALL);
        rbAllWeapons.setText("All");
        rbAllWeapons.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbAllWeaponsStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        pWeapons.add(rbAllWeapons, gridBagConstraints);

        bgSelection.add(rbProficientWeapons);
        rbProficientWeapons.setSelected(selection == WeaponSelection.PROFICIENT);
        rbProficientWeapons.setText("Proficient & Personal");
        rbProficientWeapons.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbProficientWeaponsStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        pWeapons.add(rbProficientWeapons, gridBagConstraints);

        bgSelection.add(rbPersonalWeapons);
        rbPersonalWeapons.setSelected(selection == WeaponSelection.PERSONAL);
        rbPersonalWeapons.setText("Personal");
        rbPersonalWeapons.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbPersonalWeaponsStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pWeapons.add(rbPersonalWeapons, gridBagConstraints);

        tpCharacterPages.addTab("Weapons", pWeapons);

        pSpells.setLayout(new java.awt.GridBagLayout());

        lAbility.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAbility.setText(character.getSpellCastingAbility()==null?"":character.getSpellCastingAbility().getFullName());
        lAbility.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ability", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.25;
        pSpells.add(lAbility, gridBagConstraints);

        lSpellcastingAbility.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lSpellcastingAbility.setText(getAbilityString());
        lSpellcastingAbility.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Spellcasting Ability", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.25;
        pSpells.add(lSpellcastingAbility, gridBagConstraints);

        lSpellSaveDC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lSpellSaveDC.setText(getSpellSaveDC());
        lSpellSaveDC.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Spell Save DC", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.25;
        pSpells.add(lSpellSaveDC, gridBagConstraints);

        lSpellAttackBonus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lSpellAttackBonus.setText(getSpellAttackBonus());
        lSpellAttackBonus.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Spell Attack Bonus", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.25;
        pSpells.add(lSpellAttackBonus, gridBagConstraints);

        spSpells.setDividerLocation(250);
        spSpells.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        spTableAndSlots.setResizeWeight(1.0);

        tSpells.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type", "Casting time", "Range", "Components", "Duration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tSpells.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        spSpellTable.setViewportView(tSpells);

        spTableAndSlots.setTopComponent(spSpellTable);

        pSpellSlots.setLayout(new java.awt.GridBagLayout());
        spSpellSlots.setViewportView(pSpellSlots);

        spTableAndSlots.setRightComponent(spSpellSlots);

        spSpells.setLeftComponent(spTableAndSlots);

        pInformation.setLayout(new java.awt.GridBagLayout());

        taDescription.setEditable(false);
        taDescription.setColumns(20);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        taDescription.setWrapStyleWord(true);
        spDescription.setViewportView(taDescription);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pInformation.add(spDescription, gridBagConstraints);

        taNotes.setEditable(false);
        taNotes.setColumns(20);
        taNotes.setRows(5);
        spNotes.setViewportView(taNotes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        pInformation.add(spNotes, gridBagConstraints);

        spInformation.setViewportView(pInformation);

        spSpells.setRightComponent(spInformation);

        if (!character.getSpells().isEmpty()){

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.gridwidth = 4;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.weighty = 1.0;
            pSpells.add(spSpells, gridBagConstraints);
        }

        tpCharacterPages.addTab("Spells", pSpells);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tpCharacterPages, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpCharacterPages, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lNameMouseClicked
        GlobalUtils.browseCharacter(character);
    }//GEN-LAST:event_lNameMouseClicked

    private void rbAllWeaponsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbAllWeaponsStateChanged
        changeWeaponSelection(rbAllWeapons, WeaponSelection.ALL);
    }//GEN-LAST:event_rbAllWeaponsStateChanged

    private void rbProficientWeaponsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbProficientWeaponsStateChanged
        changeWeaponSelection(rbProficientWeapons, WeaponSelection.PROFICIENT);
    }//GEN-LAST:event_rbProficientWeaponsStateChanged

    private void rbPersonalWeaponsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbPersonalWeaponsStateChanged
        changeWeaponSelection(rbPersonalWeapons, WeaponSelection.PERSONAL);
    }//GEN-LAST:event_rbPersonalWeaponsStateChanged

    private void changeWeaponSelection(JRadioButton radioButton, WeaponSelection selection) {
        if (radioButton.isSelected()) {
            this.selection = selection;
            SETTINGS.setProperty(selectionString, selection.name());
            updateWeaponTable();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSelection;
    private javax.swing.JLabel lAbility;
    private javax.swing.JLabel lName;
    private javax.swing.JLabel lSpellAttackBonus;
    private javax.swing.JLabel lSpellSaveDC;
    private javax.swing.JLabel lSpellcastingAbility;
    private javax.swing.JLabel lWeaponsSelection;
    private javax.swing.JPanel pInformation;
    private javax.swing.JPanel pSpellSlots;
    private javax.swing.JPanel pSpells;
    private javax.swing.JPanel pWeapons;
    private javax.swing.JRadioButton rbAllWeapons;
    private javax.swing.JRadioButton rbPersonalWeapons;
    private javax.swing.JRadioButton rbProficientWeapons;
    private javax.swing.JScrollPane spDescription;
    private javax.swing.JScrollPane spInformation;
    private javax.swing.JScrollPane spNotes;
    private javax.swing.JScrollPane spSpellSlots;
    private javax.swing.JScrollPane spSpellTable;
    private javax.swing.JSplitPane spSpells;
    private javax.swing.JSplitPane spTableAndSlots;
    private javax.swing.JScrollPane spWeapon;
    private javax.swing.JTable tSpells;
    private javax.swing.JTable tWeapons;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextArea taNotes;
    private javax.swing.JTabbedPane tpCharacterPages;
    // End of variables declaration//GEN-END:variables

    private void updateSpellTable() {
        List<ISpell> spells = character.getSpells();
        DefaultTableModel spellModel = (DefaultTableModel) tSpells.getModel();
        spellModel.setRowCount(0);
        if (spells.isEmpty()) {
            tpCharacterPages.remove(pSpells);
        } else {
            spells.forEach((spell) -> {
                String type;
                switch (spell.getLevel()) {
                    case CANTRIP:
                    case FEATURE:
                        type = spell.getType() + ' ' + spell.getLevel().toString();
                        break;
                    default:
                        type = "Level " + spell.getLevel() + " " + spell.getType();
                        break;
                }
                spellModel.addRow(new Object[]{spell.getName(), type, spell.getCastingTime(), spell.getRange(), spell.getComponents(), spell.getDuration()});
            });
            spSpells.setDividerLocation(SETTINGS.getProperty(SLAVE_SPELLS_SEPERATOR, spSpells.getDividerLocation()));
            tSpells.getSelectionModel().addListSelectionListener((ListSelectionEvent evt) -> {
                if (!evt.getValueIsAdjusting()) {
                    taNotes.setText(spells.get(tSpells.getSelectedRow()).getNotes());
                    taDescription.setText(spells.get(tSpells.getSelectedRow()).getDescription());
                }
            });
        }
    }

    private void updateWeaponTable() {
        DefaultTableModel weaponModel = (DefaultTableModel) tWeapons.getModel();
        weaponModel.setRowCount(0);
        List<IWeapon> weapons = new ArrayList<>(character.getPrivateWeapons());
        if (selection != WeaponSelection.PERSONAL) {
            weapons.addAll(Weapons.getInstance().getAll());
        }
        Collections.sort(weapons);
        for (IWeapon weapon : weapons) {
            if (weapon.getType() == WeaponType.PERSONAL || selection == WeaponSelection.ALL || character.isProficient(weapon)) {
                weaponModel.addRow(GlobalUtils.getWeaponRow(character, weapon));
            }
        }
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

    public ICharacter getCharacter() {
        return character;

    }

    private static class SpellSlotRadioButton extends JRadioButton {

        public SpellSlotRadioButton(boolean selected) {
            setSelected(selected);
            setFocusable(false);
            addActionListener((evt) -> {
                setSelected(selected);
            });
        }
    }

    private enum WeaponSelection {
        ALL,
        PROFICIENT,
        PERSONAL;
    }
}
