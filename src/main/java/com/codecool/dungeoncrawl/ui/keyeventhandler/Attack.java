package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Attack implements KeyHandler {
    public static final KeyCode code = KeyCode.A;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (code.equals(event.getCode())) {
            map.getPlayer().attack();
        }
    }

}
