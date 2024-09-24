package com.codecool.dungeoncrawl.data.GameMaps;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;
import com.codecool.dungeoncrawl.data.mapElements.npcs.Npc;
import com.codecool.dungeoncrawl.logic.MapLoader;

import java.util.ArrayList;
import java.util.List;

public abstract class GameMap {
    private final int width;
    private final int height;
    protected Cell[][] cells;
    protected String nextMapFileName;

    protected boolean isLevelBeaten = false;

    protected Player player;

    protected List<Monster> monsters = new ArrayList<>();
    protected List<Monster> deadMonsters = new ArrayList<>();
    protected List<Npc> npcs = new ArrayList<>();

    public GameMap(int width, int height, CellType defaultCellType, String nextMapFileName) {
        this.width = width;
        this.height = height;
        this.nextMapFileName = nextMapFileName;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

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

    public boolean isLevelBeaten() {
        return isLevelBeaten;
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

    public Npc getNpc() {
        Cell playerCell = getPlayer().getCell();
        List<Cell> neighbouringCells = playerCell.getNeighbors();

        for (Cell neighbouringCell : neighbouringCells) {
            if (neighbouringCell.getNpc() != null) {
                return neighbouringCell.getNpc();
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

    public GameMap updateMap() {
        MapLoader.setFileName(nextMapFileName);
        return MapLoader.loadMap();
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

    public void addNpc(Npc npc) {
        this.npcs.add(npc);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
