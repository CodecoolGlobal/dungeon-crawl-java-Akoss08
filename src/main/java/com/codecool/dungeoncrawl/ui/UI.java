package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.GameLogic;
import com.codecool.dungeoncrawl.ui.elements.MainStage;
import com.codecool.dungeoncrawl.ui.keyeventhandler.KeyHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Set;

public class UI {
    private final Canvas canvas;
    private final GraphicsContext context;

    private final MainStage mainStage;
    private final GameLogic logic;
    private final Set<KeyHandler> keyHandlers;


    public UI(GameLogic logic, Set<KeyHandler> keyHandlers) {
        this.canvas = new Canvas(
                logic.getMapWidth() * Tiles.TILE_WIDTH,
                logic.getMapHeight() * Tiles.TILE_WIDTH);
        this.logic = logic;
        this.context = canvas.getGraphicsContext2D();
        this.mainStage = new MainStage(canvas);
        this.keyHandlers = keyHandlers;
    }

    public void setUpPain(Stage primaryStage) {
        Scene scene = mainStage.getScene();
        primaryStage.setScene(scene);
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        for (KeyHandler keyHandler : keyHandlers) {
            keyHandler.perform(keyEvent, logic.getMap());
        }
        logic.moveMonsters();
        if (logic.getMap().isLevelBeaten()) {
            logic.updateMap();
        }
        refresh();
    }

    public void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < logic.getMapWidth(); x++) {
            for (int y = 0; y < logic.getMapHeight(); y++) {
                Cell cell = logic.getCell(x, y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), x, y);
                } else if (cell.getType().getTileName().contains("90")) {
                    Tiles.drawTile(context, cell, x, y, 90);
                } else if (cell.getType().getTileName().contains("180")) {
                    Tiles.drawTile(context, cell, x, y, 180);
                } else if (cell.getType().getTileName().contains("270")) {
                    Tiles.drawTile(context, cell, x, y, 270);
                } else if (cell.getNpc() != null) {
                    Tiles.drawTile(context, cell.getNpc(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        mainStage.setLabelsText(logic.getPlayerHealth(), logic.getPlayerInventory(),
                logic.getPlayerStrength(), logic.getPlayerDefense(), logic.getPlayerLevel(),
                logic.getPlayerXp(), logic.getPlayerGold(), logic.getMonsterHealth(),
                logic.getMonsterStrength(), logic.getMonsterAbility(), logic.getNpcDialog());
    }
}
