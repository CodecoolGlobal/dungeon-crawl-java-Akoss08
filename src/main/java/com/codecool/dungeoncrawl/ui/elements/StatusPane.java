package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 400;
    public static final int RIGHT_PANEL_PADDING = 10;
    private final GridPane ui;
    private final Label instructionsTextLabel;
    private final Label instructionsValueLabel;

    private final Label healthTextLabel;
    private final Label healthValueLabel;
    private final Label inventoryTextLabel;
    private final Label inventoryValueLabel;
    private final Label playerStrengthTextLabel;
    private final Label playerStrengthValueLabel;
    private final Label playerDefenseTextLabel;
    private final Label playerDefenseValueLabel;

    private final Label monsterHealthTextLabel;
    private final Label monsterHealthValueLabel;
    private final Label monsterStrengthTextLabel;
    private final Label monsterStrengthValueLabel;
    private final Label monsterAbilityTextLabel;
    private final Label monsterAbilityValueLabel;

    private final Label emptyRow;
    private final Label emptyRow2;

    public StatusPane() {
        ui = new GridPane();
        instructionsTextLabel = new Label("Instruction: ");
        instructionsValueLabel = new Label();

        healthTextLabel = new Label("Player health: ");
        healthValueLabel = new Label();

        inventoryTextLabel = new Label("Player inventory: ");
        inventoryValueLabel = new Label();

        playerStrengthTextLabel = new Label("Player strength: ");
        playerStrengthValueLabel = new Label();

        playerDefenseTextLabel = new Label("Player defense: ");
        playerDefenseValueLabel = new Label();

        monsterHealthTextLabel = new Label("Monster Health: ");
        monsterHealthValueLabel = new Label();

        monsterStrengthTextLabel = new Label("Monster Strength: ");
        monsterStrengthValueLabel = new Label();

        monsterAbilityTextLabel = new Label("Monster Ability: ");
        monsterAbilityValueLabel = new Label();

        emptyRow = new Label(" ");
        emptyRow2 = new Label(" ");
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(instructionsTextLabel, 0, 0);
        ui.add(instructionsValueLabel, 1, 0);

        ui.add(emptyRow2, 0, 1);

        ui.add(healthTextLabel, 0, 2);
        ui.add(healthValueLabel, 1, 2);

        ui.add(inventoryTextLabel, 0, 3);
        ui.add(inventoryValueLabel, 1, 3);

        ui.add(playerStrengthTextLabel, 0, 4);
        ui.add(playerStrengthValueLabel, 1, 4);

        ui.add(playerDefenseTextLabel, 0, 5);
        ui.add(playerDefenseValueLabel, 1, 5);

        ui.add(emptyRow, 0, 6);

        ui.add(monsterHealthTextLabel, 0, 7);
        ui.add(monsterHealthValueLabel, 1, 7);

        ui.add(monsterStrengthTextLabel, 0, 8);
        ui.add(monsterStrengthValueLabel, 1, 8);

        ui.add(monsterAbilityTextLabel, 0, 9);
        ui.add(monsterAbilityValueLabel, 1, 9);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setValues(String health, String inventory, String playerStrength, String playerDefense, String monsterHealth, String monsterStrength, String monsterAbility) {
        instructionsValueLabel.setText("[A: attack, O: open, H: heal]");
        healthValueLabel.setText(health);
        inventoryValueLabel.setText(inventory);
        playerStrengthValueLabel.setText(playerStrength);
        playerDefenseValueLabel.setText(playerDefense);

        monsterHealthValueLabel.setText(monsterHealth);
        monsterStrengthValueLabel.setText(monsterStrength);
        monsterAbilityValueLabel.setText(monsterAbility);
    }
}
