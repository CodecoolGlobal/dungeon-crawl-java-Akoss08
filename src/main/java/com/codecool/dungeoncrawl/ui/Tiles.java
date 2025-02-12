package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;

    private static final Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static final Map<String, Tile> tileMap = new HashMap<>();

    public static class Tile {
        public final int x, y, w, h;

        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(0, 0));
        tileMap.put("wall", new Tile(10, 17));
        tileMap.put("floor", new Tile(2, 0));
        tileMap.put("player", new Tile(25, 0));
        tileMap.put("skeleton", new Tile(29, 6));
        tileMap.put("key", new Tile(16, 23));
        tileMap.put("basicSword", new Tile(0, 30));
        tileMap.put("playerWithSword", new Tile(26, 0));
        tileMap.put("closedDoor", new Tile(10, 9));
        tileMap.put("openDoor", new Tile(9, 9));
        tileMap.put("scorpion", new Tile(24, 5));
        tileMap.put("spider", new Tile(28, 5));
        tileMap.put("closedChest", new Tile(8, 6));
        tileMap.put("openChest", new Tile(9, 6));
        tileMap.put("basicShield", new Tile(8, 24));
        tileMap.put("playerWithSwordAndShield", new Tile(27, 0));
        tileMap.put("basicHelmet", new Tile(1, 22));
        tileMap.put("playerWithSwordAndShieldAndHelmet", new Tile(28, 0));
        tileMap.put("healthPotion", new Tile(16, 25));
        tileMap.put("chickenBoss", new Tile(26, 7));
        tileMap.put("powerPotion", new Tile(17, 25));
        tileMap.put("invisibleStair", new Tile(2, 0));
        tileMap.put("stair", new Tile(3, 6));
        tileMap.put("pineTree", new Tile(0, 1));
        tileMap.put("doublePine", new Tile(3, 2));
        tileMap.put("simpleTree", new Tile(2, 1));
        tileMap.put("doubleTree", new Tile(3, 1));
        tileMap.put("water", new Tile(8, 4));
        tileMap.put("waterRotate90", new Tile(8, 4));
        tileMap.put("waterCrossing", new Tile(11, 4));
        tileMap.put("waterTurn", new Tile(9, 4));
        tileMap.put("waterTurnRotate90", new Tile(9, 4));
        tileMap.put("waterTurnRotate180", new Tile(9, 4));
        tileMap.put("waterTurnRotate270", new Tile(9, 4));
        tileMap.put("bridge", new Tile(6, 5));
        tileMap.put("grass", new Tile(5, 0));
        tileMap.put("flower", new Tile(16, 6));
        tileMap.put("treeStump", new Tile(18, 6));
        tileMap.put("guard", new Tile(30, 0));
        tileMap.put("snake", new Tile(28, 8));
        tileMap.put("crocodile", new Tile(29, 8));
        tileMap.put("gold", new Tile(9, 26));
        tileMap.put("shopKeeper", new Tile(24, 1));
        tileMap.put("playerWithSpear", new Tile(29, 0));
        tileMap.put("playerWithSwordAndShieldAndRareHelmet", new Tile(31, 0));
        tileMap.put("ratBoss", new Tile(31,8));
        tileMap.put("spike", new Tile(22,0));
        tileMap.put("fire", new Tile(15,10));
        tileMap.put("torch", new Tile(4,15));
        tileMap.put("animalSkeleton", new Tile(1,15));
        tileMap.put("castleMidFloor", new Tile(19,1));
        tileMap.put("castleTopFloor", new Tile(19,0));
        tileMap.put("castleTopRightFloor", new Tile(20,0));
        tileMap.put("castleRightFloor", new Tile(20,1));
        tileMap.put("castleBottomRightFloor", new Tile(20,2));
        tileMap.put("castleBottomFloor", new Tile(19,2));
        tileMap.put("castleBottomLeftFloor", new Tile(18,2));
        tileMap.put("castleLeftFloor", new Tile(18,1));
        tileMap.put("castleTopLeftFloor", new Tile(18,0));
        tileMap.put("grave", new Tile(1,14));
        tileMap.put("humanSkeleton", new Tile(0,15));

        tileMap.put("yellowMoopsy1", new Tile(18,8));
        tileMap.put("yellowMoopsy2", new Tile(19,8));
        tileMap.put("yellowMoopsy3", new Tile(20,8));
        tileMap.put("yellowMoopsy4", new Tile(21,8));
        tileMap.put("yellowMoopsy5", new Tile(22,8));
        tileMap.put("yellowMoopsy6", new Tile(23,8));

        tileMap.put("blueMoopsy1", new Tile(18,7));
        tileMap.put("blueMoopsy2", new Tile(19,7));
        tileMap.put("blueMoopsy3", new Tile(20,7));
        tileMap.put("blueMoopsy4", new Tile(21,7));
        tileMap.put("blueMoopsy5", new Tile(22,7));
        tileMap.put("blueMoopsy6", new Tile(23,7));

        tileMap.put("greenMoopsy1", new Tile(18,9));
        tileMap.put("greenMoopsy2", new Tile(19,9));
        tileMap.put("greenMoopsy3", new Tile(20,9));
        tileMap.put("greenMoopsy4", new Tile(21,9));
        tileMap.put("greenMoopsy5", new Tile(22,9));
        tileMap.put("greenMoopsy6", new Tile(23,9));
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y, double angle) {
        Tile tile = tileMap.get(d.getTileName());

        context.save();

        context.translate(x * TILE_WIDTH + (double) TILE_WIDTH / 2, y * TILE_WIDTH + (double) TILE_WIDTH / 2);

        context.rotate(angle);

        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                (double) -TILE_WIDTH / 2, (double) -TILE_WIDTH / 2, TILE_WIDTH, TILE_WIDTH);

        context.restore();
    }

}
