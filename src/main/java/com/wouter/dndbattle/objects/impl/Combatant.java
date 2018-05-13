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
package com.wouter.dndbattle.objects.impl;

import static com.wouter.dndbattle.objects.enums.AbilityType.DEX;
import static com.wouter.dndbattle.utils.Settings.ROLLFORDEATH;

import com.wouter.dndbattle.objects.ICharacter;
import com.wouter.dndbattle.objects.ICombatant;
import com.wouter.dndbattle.objects.IExtendedCharacter;
import com.wouter.dndbattle.utils.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author wverl
 */
public class Combatant implements ICombatant {

    private static final Logger log = LoggerFactory.getLogger(Combatant.class);

    private static final String TRANSFORM_NAME_FORMAT = "%s (%s)";
    private static final String HEALTH_FORMAT = "%d (%d%%)";
    private static final String HEALTH_ZERO_WITH_LIFE = "0 (Rolls Life: %d/3 Death: %d/3)";
    private static final String HEALTH_ZERO = "0 (Deathrolls: %d/3)";
    private static final String DEAD = "Dead";

    private final String name;

    private final ICharacter character;
    private Combatant transformation;
    private int health;
    private boolean dead;
    private int deathRolls = 0;
    private int lifeRolls = 0;
    private int healthBuff = 0;
    private int initiative;
    private Boolean rollForDeath;
    private int totalDamageRecieved = 0;
    private boolean friendly;

    public Combatant(ICharacter character, String name, int initiative) {
        this(character, name, initiative, character.getMaxHealth());
    }

    public Combatant(ICharacter character, String name, int initiative, int health) {
        this.name = name;
        this.character = character;
        this.health = health;
        this.dead = false;
        this.initiative = initiative;
        friendly = character.isFriendly();
    }

    private Combatant(ICharacter character, String name, int initiative, Boolean rollForDeath) {
        this(character, name, initiative, character.getMaxHealth());
        this.rollForDeath = rollForDeath;
    }

    @Override
    public ICharacter getCharacter() {
        if (isTransformed()) {
            transformation.getCharacter();
        }
        return character;
    }

    @Override
    public boolean isFriendly() {
        return friendly;
    }

    public void setFriendly(Boolean friendly) {
        this.friendly = friendly;
    }

    @Override
    public int getHealth() {
        if (isTransformed()) {
            return transformation.getHealth();
        }
        return health;
    }

    @Override
    public boolean isDead() {
        return dead || health < 0 || deathRolls >= 3;
    }

    @Override
    public int getDeathRolls() {
        return deathRolls;
    }

    public void addDeathRoll() {
        if (!isDead()) {
            deathRolls++;
            checkDead();
        }
    }

    @Override
    public int getLifeRolls() {
        return lifeRolls;
    }

    public void addLifeRoll() {
        if (!isDead()) {
            lifeRolls++;
        }
        if (lifeRolls >= 3) {
            giveHeal(1);
        }
    }

    @Override
    public int getHealthBuff() {
        if (isTransformed()) {
            return transformation.getHealthBuff();
        }
        return healthBuff;
    }

    public void setHealthBuff(int healthBuff) {
        if (isTransformed()) {
            transformation.setHealthBuff(healthBuff);
        } else {
            this.healthBuff = healthBuff;
        }
    }

    @Override
    public String getHealthString() {
        if (isTransformed()) {
            return transformation.getHealthString();
        }
        if (isDead()) {
            return DEAD;
        }
        if (health == 0) {
            if (Settings.getInstance().getProperty(ROLLFORDEATH, false)) {
                return String.format(HEALTH_ZERO_WITH_LIFE, getLifeRolls(), getDeathRolls());
            }
            return String.format(HEALTH_ZERO, getDeathRolls());
        }
        return String.format(HEALTH_FORMAT, health, (health * 100) / character.getMaxHealth());
    }

    @Override
    public int compareTo(ICombatant t) {
        int returnValue = t.getInitiative() - initiative;
        if (returnValue == 0) {
            returnValue = t.getCharacter().getAbilityModifier(DEX) - character.getAbilityModifier(DEX);
        }
        return returnValue;
    }

    @Override
    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void giveHeal(int heal) {
        if (isTransformed()) {
            transformation.giveHeal(heal);
        } else {
            if (isDead()) {
                // Yeah... We don't accept zombies here...
                return;
            }
            deathRolls = 0;
            lifeRolls = 0;
            health += heal;
            if (health > character.getMaxHealth()) {
                health = character.getMaxHealth();
            }
        }
    }

    public int giveDamage(int damage) {
        log.debug("Damaging [{}] for [{}] points", character, damage);
        int damageReturn = damage;
        if (isTransformed()) {
            log.debug("Damaging transformation for [{}] points", damage);
            int newDamage = transformation.giveDamage(damage);
            if (newDamage > 0 && (transformation.isDead() || transformation.getHealth() == 0)) {
                transformation = null;
                giveDamage(newDamage);
            }
        } else {
            if (isDead()) {
                // Stop kicking the dead body.
                return damage;
            }
            if (health == 0 && damage < character.getMaxHealth()) {
                deathRolls += 1;
            } else {
                if (healthBuff >= damage) {
                    healthBuff -= damage;
                    // buff had it, we are done.
                    return 0;
                }
                int damageAfterBuff = damage - healthBuff;
                totalDamageRecieved += damageAfterBuff;
                healthBuff = 0;
                health -= damageAfterBuff;
                if (health < 0) {
                    damageReturn = Math.abs(health);
                } else {
                    damageReturn = 0;
                }
                if (health < 0 && health > (character.getMaxHealth() * -1)) {
                    // Ok, you were not killed right away...
                    health = 0;
                }
                if (health < 1 && !rollingForDeath()) {
                    health = -1;
                }
            }
            checkDead();
        }
        return damageReturn;
    }

    @Override
    public int getTotalDamageRecieved() {
        return totalDamageRecieved;
    }

    private void checkDead() {
        if (deathRolls >= 3 || health < 0) {
            dead = true;
        }
    }

    @Override
    public String getName() {
        if (isTransformed()) {
            return String.format(TRANSFORM_NAME_FORMAT, transformation.getName(), name);
        }
        return name;
    }

    public void transform(ICharacter transform) {
        if (isTransformed()) {
            transformation.transform(transform);
        } else if (character.isCanTransform()) {
            log.debug("Transforming [{}] into [{}]", character.getName(), transform.getName());
            transformation = new Combatant(transform, transform.getName(), initiative, false);
            return;
        }
        log.debug("Transformation of [{}] into [{}] failed", character.getName(), transform.getName());
    }

    @Override
    public boolean isTransformed() {
        return character.isCanTransform() && transformation != null && !transformation.isDead();
    }

    public void leaveTransformation() {
        transformation = null;
    }

    @Override
    public Combatant getTransformation() {
        return transformation;
    }

    @Override
    public boolean rollingForDeath() {
        if (health > 0 || isDead()) {
            return false;
        }
        if (rollForDeath == null) {
            rollForDeath = character.rollForDeath();
        }
        return rollForDeath;
    }

    @Override
    public boolean ownedbyPlayer(String playerName) {
        if (character instanceof IExtendedCharacter && playerName != null) {
            return playerName.equalsIgnoreCase(((IExtendedCharacter) character).getPlayerName());
        }
        return false;
    }

    @Override
    public String toString() {
        return getName();
    }
}
