package com.codecool.dungeoncrawl.data.GameMaps;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;
import com.codecool.dungeoncrawl.data.mapElements.items.BasicShield;

import java.util.ArrayList;
import java.util.List;

public class Map2 extends GameMap {
    public Map2(int width, int height, CellType defaultCellType) {
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

        System.out.println("Map2 movemonsters method called");
        System.out.println(monsters.size());
        if (deadMonsters.size() == 1) {
            lastKilledMonster.getCell().setItem(new BasicShield(lastKilledMonster.getCell()));
        }

        monsters.removeAll(deadMonsters);
    }
}
