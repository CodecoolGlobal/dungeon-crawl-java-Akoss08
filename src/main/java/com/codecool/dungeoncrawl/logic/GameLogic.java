package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;

import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;

import java.util.*;

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

    public String getPlayerDefense() {
        return Integer.toString(map.getPlayer().getDefense());
    }

    public String getMonsterHealth() {
        Monster monster = map.getMonster();

        if (monster != null) {
            return Integer.toString(monster.getHealth());
        }

        return "";
    }

    public String getMonsterStrength() {
        Monster monster = map.getMonster();

        if (monster != null) {
            return Integer.toString(monster.getAttackStrength());
        }

        return "";
    }


    public String getMonsterAbility() {
        Monster monster = map.getMonster();

        if (monster != null) {
            return monster.getAbility();
        }

        return "";
    }

    public String getPlayerInventory() {
        return map.getPlayer().getInventory().toString();
    }

    public GameMap getMap() {
        return map;
    }

    public void moveMonsters() {
        map.moveMonsters();
    }
}
