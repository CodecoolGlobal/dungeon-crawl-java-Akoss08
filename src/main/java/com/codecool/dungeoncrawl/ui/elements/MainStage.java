package com.codecool.dungeoncrawl.ui.elements;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;

public class MainStage {
    private final Canvas canvas;
    private final Scene scene;
    private final StatusPane statusPane;

    public MainStage(Canvas canvas) {
        this.canvas = canvas;
        statusPane = new StatusPane();
        scene = setUpScene();
    }

    private Scene setUpScene() {
        BorderPane borderPane = statusPane.build();
        borderPane.setCenter(canvas);
        return new Scene(borderPane);
    }

    public Scene getScene() {
        return scene;
    }

    public void setLabelsText(String healthText, String inventoryText, String playerStrengthText,
                              String playerDefense, String playerLevel, String playerXp,
                              String playerGold, String monsterHealthText, String monsterStrengthText,
                              String monsterAbility, String npcDialog) {
        this.statusPane.setValues(healthText, inventoryText, playerStrengthText, playerDefense,
                playerLevel, playerXp, playerGold, monsterHealthText, monsterStrengthText, monsterAbility,
                npcDialog);
    }
}
