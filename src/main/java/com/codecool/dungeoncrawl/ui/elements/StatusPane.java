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
    private Label monsterHealthTextLabel;
    private Label monsterHealthValueLabel;

    public StatusPane() {
        ui = new GridPane();
        healthTextLabel = new Label("Health: ");
        healthValueLabel = new Label();

        inventoryTextLabel = new Label("Inventory: ");
        inventoryValueLabel = new Label();

        monsterHealthTextLabel = new Label("Monster Health: ");
        monsterHealthValueLabel = new Label();
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(healthTextLabel, 0, 0);
        ui.add(healthValueLabel, 1, 0);

        ui.add(inventoryTextLabel, 0, 1);
        ui.add(inventoryValueLabel, 1, 1);

        ui.add(monsterHealthTextLabel, 0, 2);
        ui.add(monsterHealthValueLabel, 1, 2);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setValues(String health, String inventory, String monsterHealth) {
        healthValueLabel.setText(health);
        inventoryValueLabel.setText(inventory);
        monsterHealthValueLabel.setText(monsterHealth);
    }
}
