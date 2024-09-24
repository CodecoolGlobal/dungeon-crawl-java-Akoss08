package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.GameMaps.GameMap;
import com.codecool.dungeoncrawl.data.mapElements.items.Chest;
import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;
import com.codecool.dungeoncrawl.data.mapElements.items.Item;
import com.codecool.dungeoncrawl.data.mapElements.npcs.Npc;

import java.util.ArrayList;
import java.util.List;

public class Cell implements Drawable {
    private CellType type;
    private Actor actor;

    private Npc npc;

    private Item item;
    private Chest chest;
    private final GameMap gameMap;
    private final int x;
    private final int y;
    public Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public Npc getNpc() {
        return npc;
    }

    public CellType getType() {
        return type;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setNpc(Npc npc) {
        this.npc = npc;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Actor getActor() {
        return actor;
    }

    public Chest getChest() {
        return chest;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
    }

    public List<Cell> getNeighbors() {
        List<Cell> neighbors = new ArrayList<>();

        neighbors.add(getNeighbor(1, 0));
        neighbors.add(getNeighbor(-1, 0));
        neighbors.add(getNeighbor(0, 1));
        neighbors.add(getNeighbor(0, -1));

        return neighbors;
    }

    public boolean isWalkable() {
        return type.isWalkable() && actor == null && npc == null;
    }

    @Override
    public String getTileName() {
        return type.getTileName();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
