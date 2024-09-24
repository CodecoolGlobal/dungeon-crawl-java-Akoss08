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
        tileMap.put("pineTree", new Tile(0,1));
        tileMap.put("doublePine", new Tile(3,2));
        tileMap.put("simpleTree", new Tile(2,1));
        tileMap.put("doubleTree", new Tile(3,1));
        tileMap.put("waterVertical", new Tile(8,4));
        tileMap.put("waterHorizontal", new Tile(8,4));
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
