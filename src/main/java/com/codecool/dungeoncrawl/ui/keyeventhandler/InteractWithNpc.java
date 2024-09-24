package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMaps.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InteractWithNpc implements KeyHandler {
    public static final KeyCode code = KeyCode.I;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (code.equals(event.getCode())) {
            map.getPlayer().interactWithNpc();
        }
    }

}


