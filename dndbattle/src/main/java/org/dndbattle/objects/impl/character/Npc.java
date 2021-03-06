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
package org.dndbattle.objects.impl.character;

import org.dndbattle.objects.ICharacter;
import org.dndbattle.objects.IExtendedCharacter;
import org.dndbattle.objects.impl.AbstractCharacter;
import org.dndbattle.objects.impl.AbstractExtendedCharacter;

/**
 *
 * @author wverl
 */
public class Npc extends AbstractExtendedCharacter implements IExtendedCharacter {

    public Npc() {
    }

    public Npc(ICharacter character) {
        super(character);
    }

    @Override
    public AbstractCharacter clone() {
        return new Npc(this);
    }

    @Override
    public boolean isFriendly() {
        return true;
    }
}
