package com.codecool.dungeoncrawl.ui.elements;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;

public class MainStage {
    private Canvas canvas;
    private Scene scene;
    private StatusPane statusPane;

    public MainStage(Canvas canvas) {
        this.canvas = canvas;
        statusPane = new StatusPane();
        scene = setUpScene();
    }

    private Scene setUpScene() {
        BorderPane borderPane = statusPane.build();
        borderPane.setCenter(canvas);
        Scene scene = new Scene(borderPane);
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void setLabelsText(String healthText, String inventoryText, String playerStrengthText, String playerDefense, String monsterHealthText, String monsterStrengthText, String monsterAbility) {
        this.statusPane.setValues(healthText, inventoryText,  playerStrengthText, playerDefense, monsterHealthText, monsterStrengthText, monsterAbility);
    }
}
