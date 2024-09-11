package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;
    private Label healthTextLabel;
    private Label healthValueLabel;
    private Label inventoryTextLabel;
    private Label inventoryValueLabel;
    private Label playerStrengthTextLabel;
    private Label playerStrengthValueLabel;
    private Label monsterHealthTextLabel;
    private Label monsterHealthValueLabel;
    private Label monsterStrengthTextLabel;
    private Label monsterStrengthValueLabel;
    private Label emptyRow;

    public StatusPane() {
        ui = new GridPane();
        healthTextLabel = new Label("Player health: ");
        healthValueLabel = new Label();

        inventoryTextLabel = new Label("Player inventory: ");
        inventoryValueLabel = new Label();

        playerStrengthTextLabel = new Label("Player strength: ");
        playerStrengthValueLabel = new Label();

        monsterHealthTextLabel = new Label("Monster Health: ");
        monsterHealthValueLabel = new Label();

        monsterStrengthTextLabel = new Label("Monster Strength: ");
        monsterStrengthValueLabel = new Label();

        emptyRow = new Label(" ");
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(healthTextLabel, 0, 0);
        ui.add(healthValueLabel, 1, 0);

        ui.add(inventoryTextLabel, 0, 1);
        ui.add(inventoryValueLabel, 1, 1);

        ui.add(playerStrengthTextLabel, 0, 2);
        ui.add(playerStrengthValueLabel, 1, 2);

        ui.add(emptyRow, 0, 3);

        ui.add(monsterHealthTextLabel, 0, 4);
        ui.add(monsterHealthValueLabel, 1, 4);

        ui.add(monsterStrengthTextLabel, 0, 5);
        ui.add(monsterStrengthValueLabel, 1, 5);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setValues(String health, String inventory, String playerStrength, String monsterHealth, String monsterStrength) {
        healthValueLabel.setText(health);
        inventoryValueLabel.setText(inventory);
        playerStrengthValueLabel.setText(playerStrength);

        monsterHealthValueLabel.setText(monsterHealth);
        monsterStrengthValueLabel.setText(monsterStrength);
    }
}
