package com.codecool.dungeoncrawl.data.GameMaps;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Map2 extends GameMap {
    private static final String NEXT_MAP_FILE_NAME = "/map3.txt";

    public Map2(int width, int height, CellType defaultCellType) {
        super(width, height, defaultCellType, NEXT_MAP_FILE_NAME);
    }

    @Override
    public void moveMonsters() {
        super.moveMonsters();

        if (monsters.isEmpty()) {
            openStair();
            if (player.getCell().getType().equals(CellType.STAIR)) {
                isLevelBeaten = true;
            }
        }

        monsters.removeAll(deadMonsters);
    }

}
