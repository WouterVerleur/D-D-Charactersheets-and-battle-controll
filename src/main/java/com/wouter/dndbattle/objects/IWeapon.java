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
package com.wouter.dndbattle.objects;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.wouter.dndbattle.objects.enums.Dice;
import com.wouter.dndbattle.objects.enums.WeaponRange;
import com.wouter.dndbattle.objects.enums.WeaponType;
import com.wouter.dndbattle.objects.enums.WeaponWeight;

/**
 *
 * @author Wouter
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public interface IWeapon extends ISaveableClass {

    String getName();

    WeaponType getType();

    Dice getAttackDice();

    int getAmountOfAttackDice();

    String getDamageType();

    String getNotes();

    boolean isFinesse();

    boolean isLoading();

    boolean isTwoHanded();

    boolean isCanUseMagicStats();

    WeaponRange getWeaponRange();

    int getRange();

    int getMaxRange();

    WeaponWeight getWeight();

    int getAttackModifier();

    int getDamageModifier();

    boolean isProficient();
}
