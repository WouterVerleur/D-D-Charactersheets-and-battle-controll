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

import com.wouter.dndbattle.objects.ICharacter;
import com.wouter.dndbattle.objects.IExtendedCharacter;
import com.wouter.dndbattle.objects.enums.AbilityType;
import com.wouter.dndbattle.objects.enums.SkillType;
import com.wouter.dndbattle.utils.GlobalUtils;

/**
 *
 * @author Wouter
 */
public class SlaveAbilityAndSkillPanel extends javax.swing.JPanel {

    private static final String TRANSFORMATION_FORMAT = "%s up to %s";
    private static final String NONE = "None";

    private final ICharacter character;
    private final String transformationString;
    private final String hitDiceString;

    public SlaveAbilityAndSkillPanel(ICharacter character) {
        this.character = character;
        if (character.isCanTransform()) {
            transformationString = String.format(TRANSFORMATION_FORMAT, character.getTransformType().getSimpleName(), character.getTransformChallengeRating());
        } else {
            transformationString = NONE;
        }
        if (character instanceof IExtendedCharacter) {
            hitDiceString = ((IExtendedCharacter) character).getHitDice();
        } else {
            hitDiceString = NONE;
        }
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

        spAbility = new javax.swing.JScrollPane();
        pAbility = new javax.swing.JPanel();
        spSavingThrow = new javax.swing.JScrollPane();
        pSavingThrow = new javax.swing.JPanel();
        spSkill = new javax.swing.JScrollPane();
        pSkill = new javax.swing.JPanel();
        pHealth = new javax.swing.JPanel();
        lHealth = new javax.swing.JLabel();
        pPassiveWisdom = new javax.swing.JPanel();
        lPassiveWisdomModifier = new javax.swing.JLabel();
        pInitiative = new javax.swing.JPanel();
        lInitiative = new javax.swing.JLabel();
        pProficiency = new javax.swing.JPanel();
        lProficiency = new javax.swing.JLabel();
        pArmorClass = new javax.swing.JPanel();
        lArmorClass = new javax.swing.JLabel();
        pHitDice = new javax.swing.JPanel();
        lHitDice = new javax.swing.JLabel();
        pTransform = new javax.swing.JPanel();
        lTransformation = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        pAbility.setLayout(new java.awt.GridLayout(0, 1));

        for (AbilityType abilityType : AbilityType.values()){
            pAbility.add(new SlaveAbilityPanel(character, abilityType));
        }

        spAbility.setViewportView(pAbility);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 75;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        add(spAbility, gridBagConstraints);

        pSavingThrow.setLayout(new java.awt.GridLayout(0, 1));

        for (AbilityType abilityType : AbilityType.values()){
            pSavingThrow.add(new SlaveSavingThrowPanel(character, abilityType));
        }

        spSavingThrow.setViewportView(pSavingThrow);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 125;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        add(spSavingThrow, gridBagConstraints);

        pSkill.setLayout(new java.awt.GridLayout(0, 1));

        for (SkillType skillType : SkillType.values()){
            pSkill.add(new SlaveSkillPanel(character, skillType));
        }

        spSkill.setViewportView(pSkill);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 125;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        add(spSkill, gridBagConstraints);

        pHealth.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Health", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        pHealth.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lHealth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lHealth.setText(Integer.toString(character.getMaxHealth()));

        javax.swing.GroupLayout pHealthLayout = new javax.swing.GroupLayout(pHealth);
        pHealth.setLayout(pHealthLayout);
        pHealthLayout.setHorizontalGroup(
            pHealthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pHealthLayout.setVerticalGroup(
            pHealthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lHealth)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(pHealth, gridBagConstraints);

        pPassiveWisdom.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Passive Wisdom", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        pPassiveWisdom.setMinimumSize(new java.awt.Dimension(100, 40));
        pPassiveWisdom.setPreferredSize(new java.awt.Dimension(100, 40));

        lPassiveWisdomModifier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPassiveWisdomModifier.setText(Integer.toString(character.getPassiveWisdom()));

        javax.swing.GroupLayout pPassiveWisdomLayout = new javax.swing.GroupLayout(pPassiveWisdom);
        pPassiveWisdom.setLayout(pPassiveWisdomLayout);
        pPassiveWisdomLayout.setHorizontalGroup(
            pPassiveWisdomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lPassiveWisdomModifier, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );
        pPassiveWisdomLayout.setVerticalGroup(
            pPassiveWisdomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lPassiveWisdomModifier)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(pPassiveWisdom, gridBagConstraints);

        pInitiative.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Initiative", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        pInitiative.setMinimumSize(new java.awt.Dimension(100, 40));

        lInitiative.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lInitiative.setText(GlobalUtils.modifierToString(character.getInitiative()));

        javax.swing.GroupLayout pInitiativeLayout = new javax.swing.GroupLayout(pInitiative);
        pInitiative.setLayout(pInitiativeLayout);
        pInitiativeLayout.setHorizontalGroup(
            pInitiativeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lInitiative, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );
        pInitiativeLayout.setVerticalGroup(
            pInitiativeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lInitiative)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(pInitiative, gridBagConstraints);

        pProficiency.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Proficiency", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        lProficiency.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lProficiency.setText(GlobalUtils.modifierToString(character.getProficiencyScore()));

        javax.swing.GroupLayout pProficiencyLayout = new javax.swing.GroupLayout(pProficiency);
        pProficiency.setLayout(pProficiencyLayout);
        pProficiencyLayout.setHorizontalGroup(
            pProficiencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lProficiency, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pProficiencyLayout.setVerticalGroup(
            pProficiencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lProficiency)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(pProficiency, gridBagConstraints);

        pArmorClass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Armor Class", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        lArmorClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lArmorClass.setText(character.getArmorClassString());

        javax.swing.GroupLayout pArmorClassLayout = new javax.swing.GroupLayout(pArmorClass);
        pArmorClass.setLayout(pArmorClassLayout);
        pArmorClassLayout.setHorizontalGroup(
            pArmorClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lArmorClass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pArmorClassLayout.setVerticalGroup(
            pArmorClassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pArmorClassLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lArmorClass))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(pArmorClass, gridBagConstraints);

        pHitDice.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Hit dice", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        lHitDice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lHitDice.setText(hitDiceString);

        javax.swing.GroupLayout pHitDiceLayout = new javax.swing.GroupLayout(pHitDice);
        pHitDice.setLayout(pHitDiceLayout);
        pHitDiceLayout.setHorizontalGroup(
            pHitDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lHitDice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pHitDiceLayout.setVerticalGroup(
            pHitDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lHitDice)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(pHitDice, gridBagConstraints);

        pTransform.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Transformation", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        lTransformation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTransformation.setText(transformationString);

        javax.swing.GroupLayout pTransformLayout = new javax.swing.GroupLayout(pTransform);
        pTransform.setLayout(pTransformLayout);
        pTransformLayout.setHorizontalGroup(
            pTransformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lTransformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pTransformLayout.setVerticalGroup(
            pTransformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lTransformation)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(pTransform, gridBagConstraints);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setText(character.getNotes());
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lArmorClass;
    private javax.swing.JLabel lHealth;
    private javax.swing.JLabel lHitDice;
    private javax.swing.JLabel lInitiative;
    private javax.swing.JLabel lPassiveWisdomModifier;
    private javax.swing.JLabel lProficiency;
    private javax.swing.JLabel lTransformation;
    private javax.swing.JPanel pAbility;
    private javax.swing.JPanel pArmorClass;
    private javax.swing.JPanel pHealth;
    private javax.swing.JPanel pHitDice;
    private javax.swing.JPanel pInitiative;
    private javax.swing.JPanel pPassiveWisdom;
    private javax.swing.JPanel pProficiency;
    private javax.swing.JPanel pSavingThrow;
    private javax.swing.JPanel pSkill;
    private javax.swing.JPanel pTransform;
    private javax.swing.JScrollPane spAbility;
    private javax.swing.JScrollPane spSavingThrow;
    private javax.swing.JScrollPane spSkill;
    // End of variables declaration//GEN-END:variables

}
