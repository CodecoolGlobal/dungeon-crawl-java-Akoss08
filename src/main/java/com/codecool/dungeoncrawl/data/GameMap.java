package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    private Player player;

    protected final List<Monster> monsters = new ArrayList<>();

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Monster getMonster() {
        Cell playerCell = getPlayer().getCell();
        List<Cell> neighbouringCells = playerCell.getNeighbors();

        for (Cell neighbouringCell : neighbouringCells) {
            if (neighbouringCell.getActor() instanceof Monster) {
                return (Monster) neighbouringCell.getActor();

            }
        }
        return null;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void moveMonsters() {
        List<Monster> deadMonsters = new ArrayList<>();

        for (Monster monster : monsters) {
            if (monster.isDead()) {
                deadMonsters.add(monster);
            } else {
                moveRandomly(monster);
            }
        }

        monsters.removeAll(deadMonsters);
    }

    protected void moveRandomly(Actor monster) {
        List<Cell> walkableCells = getWalkableCells(monster);
        Cell nextCell = walkableCells.get(randomNumber(walkableCells.size()));
        int currentX = monster.getX();
        int currentY = monster.getY();
        int nextX = nextCell.getX();
        int nextY = nextCell.getY();

        monster.move(nextX - currentX, nextY - currentY);
    }

    private int randomNumber(int max) {
        return (int) (Math.random() * max + 0);
    }

    private List<Cell> getWalkableCells(Actor monster) {
        List<Cell> monsterNeighbouringCells = monster.getCell().getNeighbors();
        List<Cell> walkableCells = new ArrayList<>();
        walkableCells.add(monster.getCell());

        for (Cell cell : monsterNeighbouringCells) {
            if (cell.isWalkable()) {
                walkableCells.add(cell);
            }
        }
        return walkableCells;
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
