/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dndbattle.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dndbattle.objects.ICharacter;
import org.dndbattle.view.comboboxes.ClassComboBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Wouter
 */
public class Characters extends AbstractObjectStorer<ICharacter> {

    private static final Logger log = LoggerFactory.getLogger(Characters.class);

    private final Map<Class<? extends ICharacter>, List<ICharacter>> CLASS_CHARACTER_MAP = new HashMap<>();
    private static final Characters INSTANCE = new Characters();

    private Characters() {
        super("Characters");
    }

    public static Characters getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean add(ICharacter character) {
        if (!canCreate(character)) {
            return false;
        }
        final List<ICharacter> characters = getCharacters(character.getClass());
        characters.add(character);
        Collections.sort(characters);
        store(character, true);
        return true;
    }

    @Override
    public void update(ICharacter character) {
        if (getFile(character).exists()) {
            store(character, false);
        }
    }

    @Override
    public List<ICharacter> getAll() {
        List<ICharacter> all = new ArrayList<>();
        for (Class<? extends ICharacter> clazz : ClassComboBox.getAllClasses()) {
            all.addAll(getCharacters(clazz));
        }
        return all;
    }

    public List<ICharacter> getCharacters(Class<? extends ICharacter> clazz) {
        if (!isInitialized()) {
            initialize();
        }
        log.debug("Returning list of characters of class [{}]", clazz.getSimpleName());
        return CLASS_CHARACTER_MAP.get(clazz);
    }

    @Override
    protected void initializeHook() {
        Class<? extends ICharacter>[] classes = ClassComboBox.getAllClasses();
        for (int i = 0; i < classes.length; i++) {
            Class<? extends ICharacter> clazz = classes[i];
            log.debug("Loading list of characters of class [{}]", clazz.getSimpleName());
            CLASS_CHARACTER_MAP.put(clazz, loadFromFiles(clazz, false));
            setProgress(Math.floorDiv((i + 1) * 100, classes.length));
        }
    }

    @Override
    public void remove(ICharacter preset) {
        store(preset, true);// to make sure any change does not undo this remove
        File file = getFile(preset);
        if (file.exists()) {
            file.delete();
            getCharacters(preset.getClass()).remove(preset);
            log.debug("Character [{}] has been deleted.", preset);
        }
    }
}
