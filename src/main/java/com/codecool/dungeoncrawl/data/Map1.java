package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;
import com.codecool.dungeoncrawl.data.mapElements.items.Key;

import java.util.ArrayList;
import java.util.List;

public class Map1 extends GameMap {
    public Map1(int width, int height, CellType defaultCellType) {
        super(width, height, defaultCellType);
    }

    @Override
    public void moveMonsters() {
        List<Monster> deadMonsters = new ArrayList<>();
        Monster lastKilledMonster = null;

        for (Monster monster : monsters) {
            if (monster.isDead()) {
                deadMonsters.add(monster);
                lastKilledMonster = monster;
            } else {
                moveRandomly(monster);
            }
        }

        if (!deadMonsters.isEmpty() && monsters.size() - deadMonsters.size() == 1) {
            Cell lastMonsterCell = lastKilledMonster.getCell();
            lastMonsterCell.setItem(new Key(lastMonsterCell));
        }

        monsters.removeAll(deadMonsters);
    }
}
