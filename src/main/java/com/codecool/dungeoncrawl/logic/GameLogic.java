package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMaps.GameMap;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;
import com.codecool.dungeoncrawl.data.mapElements.npcs.Npc;


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

    public String getPlayerLevel() {
        return Integer.toString(map.getPlayer().getLevel());
    }

    public String getPlayerXp() {
        return Integer.toString(map.getPlayer().getXp());
    }

    public String getPlayerGold() {
        return Integer.toString(map.getPlayer().getGold());
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

    public String getNpcDialog() {
        Npc npc = map.getNpc();

        if (npc != null) {
            return npc.getDialog();
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

    public void updateMap() {
        this.map = map.updateMap();
    }
}
