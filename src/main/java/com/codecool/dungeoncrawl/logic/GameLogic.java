package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;

import java.util.List;

public class GameLogic {
    private GameMap map;

    public GameLogic() {
        this.map = MapLoader.loadMap();
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public String getPlayerStrength() {
        return Integer.toString(map.getPlayer().getAttackStrength());
    }

    public String getMonsterHealth() {
        Actor monster = getMonster();

        if (monster != null) {
            return Integer.toString(monster.getHealth());
        }

        return "";
    }

    public String getMonsterStrength() {
        Actor monster = getMonster();

        if (monster != null) {
            return Integer.toString(monster.getAttackStrength());
        }

        return "";
    }

    public Actor getMonster() {
        Cell playerCell = map.getPlayer().getCell();
        List<Cell> neighbouringCells = playerCell.getNeighbors();

        Actor monster = null;
        for (Cell neighbouringCell : neighbouringCells) {
            if (neighbouringCell.getActor() != null) {
                monster = neighbouringCell.getActor();
                break;
            }
        }
        return monster;
    }

    public String getPlayerInventory() {
        return map.getPlayer().getInventory().toString();
    }

    public GameMap getMap() {
        return map;
    }
}
