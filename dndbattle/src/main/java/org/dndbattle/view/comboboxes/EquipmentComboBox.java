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
package org.dndbattle.view.comboboxes;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import org.dndbattle.objects.IInventoryItem;
import org.dndbattle.objects.impl.Armor;
import org.dndbattle.objects.impl.Utility;
import org.dndbattle.objects.impl.Weapon;

/**
 *
 * @author wverl
 */
public class EquipmentComboBox extends CustomComboBox<Class<? extends IInventoryItem>> {

    private static final Class<? extends IInventoryItem>[] CLASSES = new Class[]{
        Armor.class,
        Utility.class,
        Weapon.class};
    private static final ClassCellRenderer RENDERER = new ClassCellRenderer();

    public EquipmentComboBox() {
        super(CLASSES);
        setRenderer(RENDERER);
    }

    public static Class<? extends IInventoryItem>[] getAllClasses() {
        return CLASSES;
    }

    private static class ClassCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Object item = value;
            if (item instanceof Class) {
                item = ((Class) value).getSimpleName();
            }
            return super.getListCellRendererComponent(list, item, index, isSelected, cellHasFocus);
        }

    }
}
