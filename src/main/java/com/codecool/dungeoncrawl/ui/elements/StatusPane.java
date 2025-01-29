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
    private final Label playerLevelTextLabel;
    private final Label playerLevelValueLabel;
    private final Label playerXpTextLabel;
    private final Label playerXpValueLabel;
    private final Label playerGoldTextLabel;
    private final Label playerGoldValueLabel;

    private final Label monsterHealthTextLabel;
    private final Label monsterHealthValueLabel;
    private final Label monsterStrengthTextLabel;
    private final Label monsterStrengthValueLabel;
    private final Label monsterAbilityTextLabel;
    private final Label monsterAbilityValueLabel;

    private final Label npcDialogTextLabel;
    private final Label npcDialogValueLabel;

    private final Label emptyRow;
    private final Label emptyRow2;
    private final Label emptyRow3;

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

        playerLevelTextLabel = new Label("Player level: ");
        playerLevelValueLabel = new Label();

        playerXpTextLabel = new Label("Player xp: ");
        playerXpValueLabel = new Label();

        playerGoldTextLabel = new Label("Player gold: ");
        playerGoldValueLabel = new Label();

        monsterHealthTextLabel = new Label("Monster Health: ");
        monsterHealthValueLabel = new Label();

        monsterStrengthTextLabel = new Label("Monster Strength: ");
        monsterStrengthValueLabel = new Label();

        monsterAbilityTextLabel = new Label("Monster Ability: ");
        monsterAbilityValueLabel = new Label();

        npcDialogTextLabel = new Label("");
        npcDialogValueLabel = new Label();

        emptyRow = new Label(" ");
        emptyRow2 = new Label(" ");
        emptyRow3 = new Label(" ");
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

        ui.add(playerLevelTextLabel, 0, 6);
        ui.add(playerLevelValueLabel, 1, 6);

        ui.add(playerXpTextLabel, 0, 7);
        ui.add(playerXpValueLabel, 1, 7);

        ui.add(playerGoldTextLabel, 0, 8);
        ui.add(playerGoldValueLabel, 1, 8);

        ui.add(emptyRow, 0, 9);

        ui.add(monsterHealthTextLabel, 0, 10);
        ui.add(monsterHealthValueLabel, 1, 10);

        ui.add(monsterStrengthTextLabel, 0, 11);
        ui.add(monsterStrengthValueLabel, 1, 11);

        ui.add(monsterAbilityTextLabel, 0, 12);
        ui.add(monsterAbilityValueLabel, 1, 12);

        ui.add(emptyRow3, 0, 13);

        ui.add(npcDialogTextLabel, 0, 14);
        ui.add(npcDialogValueLabel, 1, 14);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setValues(String health, String inventory, String playerStrength,
                          String playerDefense, String playerLevel, String playerXp,
                          String playerGold, String monsterHealth, String monsterStrength,
                          String monsterAbility, String npcDialog) {
        instructionsValueLabel.setText("A: attack\nO: open\nH: heal\nP: power boost\nI: interact");
        healthValueLabel.setText(health);
        inventoryValueLabel.setText(inventory);
        playerStrengthValueLabel.setText(playerStrength);
        playerDefenseValueLabel.setText(playerDefense);
        playerLevelValueLabel.setText(playerLevel);
        playerXpValueLabel.setText(playerXp);
        playerGoldValueLabel.setText(playerGold);

        monsterHealthValueLabel.setText(monsterHealth);
        monsterStrengthValueLabel.setText(monsterStrength);
        monsterAbilityValueLabel.setText(monsterAbility);

        npcDialogValueLabel.setText(npcDialog);
    }
}
