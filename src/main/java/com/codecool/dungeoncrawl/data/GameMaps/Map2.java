package com.codecool.dungeoncrawl.data.GameMaps;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;
import com.codecool.dungeoncrawl.data.mapElements.items.BasicShield;

public class Map2 extends GameMap {
    private boolean shieldDropped = false;

    public Map2(int width, int height, CellType defaultCellType) {
        super(width, height, defaultCellType);
    }

    @Override
    public void moveMonsters() {
        Monster firstKilledMonster;
        super.moveMonsters();

        if (deadMonsters.size() == 1 && !shieldDropped) {
            firstKilledMonster = deadMonsters.get(0);
            firstKilledMonster.getCell().setItem(new BasicShield(firstKilledMonster.getCell()));
            shieldDropped = true;
        }

        monsters.removeAll(deadMonsters);
    }
}
