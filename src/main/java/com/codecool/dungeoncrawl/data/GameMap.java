package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Boss;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;

    private final List<Monster> monsters;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        monsters = new ArrayList<>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }   
    }

    public Boss getBoss() {
        Boss boss = null;
        for (Monster monster : monsters) {
            if (monster instanceof Boss) {
                boss = (Boss) monster;
            }
        }
        return boss;
    }

    public Monster getMonster() {
        Cell playerCell = getPlayer().getCell();
        List<Cell> neighbouringCells = playerCell.getNeighbors();

        Monster monster = null;
        for (Cell neighbouringCell : neighbouringCells) {
            if (neighbouringCell.getActor() instanceof Monster) {
                monster = (Monster) neighbouringCell.getActor();
                break;
            }
        }
        return monster;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void addMonster(Monster monster) {
        this.monsters.add(monster);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
