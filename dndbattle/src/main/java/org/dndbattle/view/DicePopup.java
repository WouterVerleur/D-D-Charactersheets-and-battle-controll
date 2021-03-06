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
package org.dndbattle.view;

import org.dndbattle.objects.enums.Dice;
import org.dndbattle.utils.GlobalUtils;
import java.util.Random;

/**
 *
 * @author wverl
 */
public class DicePopup extends javax.swing.JFrame {

    private static final Random RANDOM = new Random();

    private final Dice dice;
    private final int modifier;

    public DicePopup(int modifier, Dice dice, String title) {
        super(title);
        this.modifier = modifier;
        this.dice = dice;
        initComponents();
        refreshLabels();
    }

    private void refreshLabels() {
        lModifier.setText(GlobalUtils.modifierToString(modifier));
        int roll = RANDOM.nextInt(dice.getSides()) + 1;
        lRoll.setText(Integer.toString(roll));
        lResult.setText(Integer.toString(roll + modifier));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lRoll = new javax.swing.JLabel();
        lModifier = new javax.swing.JLabel();
        lResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lRoll.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lRoll.setText("00");

        lModifier.setText("+00");

        lResult.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lResult.setText("00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lRoll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lModifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lRoll)
                    .addComponent(lModifier))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lResult))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        refreshLabels();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lModifier;
    private javax.swing.JLabel lResult;
    private javax.swing.JLabel lRoll;
    // End of variables declaration//GEN-END:variables
}
