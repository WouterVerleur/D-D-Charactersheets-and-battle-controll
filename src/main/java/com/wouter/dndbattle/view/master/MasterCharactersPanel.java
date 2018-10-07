/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wouter.dndbattle.view.master;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import com.wouter.dndbattle.objects.ICharacter;
import com.wouter.dndbattle.objects.impl.AbstractCharacter;
import com.wouter.dndbattle.utils.Characters;
import com.wouter.dndbattle.utils.GlobalUtils;
import com.wouter.dndbattle.utils.Settings;
import com.wouter.dndbattle.view.master.character.CharacterPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Wouter
 */
public class MasterCharactersPanel extends javax.swing.JPanel {

    private static final Logger log = LoggerFactory.getLogger(MasterCharactersPanel.class);

    private static final Settings SETTINGS = Settings.getInstance();
    private static final String DIVIDER_LOCATION_PROPERTY_FORMAT = "gui.master.presetpanel.%s.deviderlocation";
    private boolean addingPresets;

    private final Class<? extends AbstractCharacter> characterClass;
    private final String next;
    private final String previous;
    DefaultListModel<AbstractCharacter> listModel = new DefaultListModel<>();
    private final String dividerLocationProperty;

    public MasterCharactersPanel(Class<? extends AbstractCharacter> characterClass) {
        this(characterClass, "Previous", "Next");
    }

    public MasterCharactersPanel(Class<? extends AbstractCharacter> characterClass, String previous, String next) {
        this.characterClass = characterClass;
        this.previous = previous;
        this.next = next;
        dividerLocationProperty = String.format(DIVIDER_LOCATION_PROPERTY_FORMAT, getClassname());
        initComponents();
    }

    private AbstractCharacter getSelectedCharacter() {
        int selection = lCharacters.getSelectedIndex();
        if (selection >= 0) {
            return listModel.getElementAt(selection);
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        spPreset = new javax.swing.JSplitPane();
        pCharacters = new javax.swing.JPanel();
        bNew = new javax.swing.JButton();
        spCharacters = new javax.swing.JScrollPane();
        lCharacters = new javax.swing.JList();
        pTemp = new javax.swing.JPanel();
        bPrevious = new javax.swing.JButton();
        lName = new javax.swing.JLabel();
        bNext = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        spPreset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        spPreset.setDividerLocation(getDividerLocation());
        spPreset.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                spPresetPropertyChange(evt);
            }
        });

        bNew.setText("New");
        bNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewActionPerformed(evt);
            }
        });

        spCharacters.setBackground(GlobalUtils.getBackgroundTransparent());
        spCharacters.setBorder(null);
        spCharacters.setOpaque(false);

        lCharacters.setBackground(GlobalUtils.getBackgroundTransparent());
        lCharacters.setModel(listModel);
        lCharacters.setOpaque(false);
        lCharacters.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lCharactersValueChanged(evt);
            }
        });
        spCharacters.setViewportView(lCharacters);

        javax.swing.GroupLayout pCharactersLayout = new javax.swing.GroupLayout(pCharacters);
        pCharacters.setLayout(pCharactersLayout);
        pCharactersLayout.setHorizontalGroup(
            pCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(spCharacters, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pCharactersLayout.setVerticalGroup(
            pCharactersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCharactersLayout.createSequentialGroup()
                .addComponent(spCharacters)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bNew))
        );

        spPreset.setLeftComponent(pCharacters);

        javax.swing.GroupLayout pTempLayout = new javax.swing.GroupLayout(pTemp);
        pTemp.setLayout(pTempLayout);
        pTempLayout.setHorizontalGroup(
            pTempLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pTempLayout.setVerticalGroup(
            pTempLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );

        spPreset.setRightComponent(pTemp);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(spPreset, gridBagConstraints);

        bPrevious.setText("< "+previous);
        bPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPreviousActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(bPrevious, gridBagConstraints);

        lName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lName.setText(characterClass.getSimpleName());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(lName, gridBagConstraints);

        bNext.setText(next+" >");
        bNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(bNext, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        String inputValue = JOptionPane.showInputDialog(this, "", "Name", JOptionPane.QUESTION_MESSAGE);
        if (inputValue == null) {
            return;
        }
        inputValue = inputValue.trim();
        if (inputValue.isEmpty()) {
            return;
        }
        try {
            AbstractCharacter newCharacter = characterClass.newInstance();
            newCharacter.setName(inputValue);
            if (!Characters.getInstance().addCharacter(newCharacter)) {
                JOptionPane.showMessageDialog(this, "Unable to create character with name " + inputValue + " because it already exists!", "Character exists.", JOptionPane.WARNING_MESSAGE);
            }
        } catch (InstantiationException | IllegalAccessException ex) {
            log.error("Error while creating new character", ex);
        }
        updateList();
    }//GEN-LAST:event_bNewActionPerformed

    private void spPresetPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_spPresetPropertyChange
        if (evt.getPropertyName().equalsIgnoreCase(JSplitPane.DIVIDER_LOCATION_PROPERTY)) {
            SETTINGS.setProperty(dividerLocationProperty, spPreset.getDividerLocation());
        }
    }//GEN-LAST:event_spPresetPropertyChange

    private void lCharactersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lCharactersValueChanged
        if (!addingPresets) {
            Component oldPanel = spPreset.getRightComponent();
            CharacterPanel panel = new CharacterPanel(getSelectedCharacter(), this);
            if (oldPanel instanceof CharacterPanel) {
                int currentTab = ((CharacterPanel) oldPanel).getCurrentTab();
                panel.setCurrentTab(currentTab);
            }
            spPreset.setRightComponent(panel);
            spPreset.setDividerLocation(getDividerLocation());
        }
    }//GEN-LAST:event_lCharactersValueChanged

    private void bPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPreviousActionPerformed
        LayoutManager parentLayout = getParent().getLayout();
        if (parentLayout instanceof CardLayout) {
            ((CardLayout) parentLayout).previous(getParent());
        }
    }//GEN-LAST:event_bPreviousActionPerformed

    private void bNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNextActionPerformed
        LayoutManager parentLayout = getParent().getLayout();
        if (parentLayout instanceof CardLayout) {
            ((CardLayout) parentLayout).next(getParent());
        }
    }//GEN-LAST:event_bNextActionPerformed

    private List<ICharacter> getAllCharacters() {
        return Characters.getInstance().getCharacters(characterClass);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bNew;
    private javax.swing.JButton bNext;
    private javax.swing.JButton bPrevious;
    private javax.swing.JList lCharacters;
    private javax.swing.JLabel lName;
    private javax.swing.JPanel pCharacters;
    private javax.swing.JPanel pTemp;
    private javax.swing.JScrollPane spCharacters;
    private javax.swing.JSplitPane spPreset;
    // End of variables declaration//GEN-END:variables

    private String getClassname() {
        return characterClass.getSimpleName().toLowerCase();
    }

    public void updateList() {
        addingPresets = true;
        AbstractCharacter currectSelection = getSelectedCharacter();
        listModel.removeAllElements();
        getAllCharacters().forEach((character) -> {
            listModel.addElement((AbstractCharacter) character);
        });
        final int selectionIndex = listModel.indexOf(currectSelection);
        lCharacters.setSelectedIndex(selectionIndex);
        addingPresets = false;
        if (selectionIndex >= 0) {
            lCharactersValueChanged(null);
        }
        boolean buttonsEnabled = getParent().getLayout() instanceof CardLayout;
        bPrevious.setEnabled(buttonsEnabled);
        bNext.setEnabled(buttonsEnabled);
    }

    private int getDividerLocation() {
        return SETTINGS.getProperty(dividerLocationProperty, 175);
    }
}
