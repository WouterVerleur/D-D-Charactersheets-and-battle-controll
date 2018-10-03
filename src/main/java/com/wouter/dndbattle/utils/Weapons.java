/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wouter.dndbattle.utils;

import java.io.File;
import java.util.Collections;
import java.util.List;

import com.wouter.dndbattle.objects.IWeapon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Wouter
 */
public class Weapons extends ObjectStorer<IWeapon> {

    private static final Logger log = LoggerFactory.getLogger(Weapons.class);

    private static final Weapons INSTANCE = new Weapons();

    private List<IWeapon> weapons = null;

    private Weapons() {
    }

    public static Weapons getInstance() {
        return INSTANCE;
    }

    public boolean addCharacter(IWeapon weapon) {
        if (!canCreate(weapon)) {
            return false;
        }
        weapons.add(weapon);
        Collections.sort(weapons);
        store(weapon, true);
        return true;
    }

    public void updateCharacter(IWeapon weapon) {
        if (getFile(weapon).exists()) {
            store(weapon, false);
        }
    }

    public List<IWeapon> getWeapons() {
        return weapons;
    }

    @Override
    public void remove(IWeapon weapon) {
        store(weapon, true);// to make sure any change does not undo this remove
        File file = getFile(weapon);
        if (file.exists()) {
            file.delete();
            weapons.remove(weapon);
            log.debug("Character [{}] has been deleted.", weapon);
        }
    }
}