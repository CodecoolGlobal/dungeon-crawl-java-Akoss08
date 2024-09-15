package com.codecool.dungeoncrawl.data.GameMaps;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;
import com.codecool.dungeoncrawl.data.mapElements.items.Key;

public class Map1 extends GameMap {
    private static final String NEXT_MAP_FILE_NAME = "/map2.txt";
    private boolean keyDropped = false;

    public Map1(int width, int height, CellType defaultCellType) {
        super(width, height, defaultCellType, NEXT_MAP_FILE_NAME);
    }

    @Override
    public void moveMonsters() {
        Monster lastKilledMonster;
        super.moveMonsters();

        if (monsters.size() == 1 && !keyDropped) {
            lastKilledMonster = deadMonsters.get(deadMonsters.size() - 1);
            dropKey(lastKilledMonster);
            keyDropped = true;
        } else if (monsters.isEmpty()) {
            openStair();
            if (player.getCell().getType().equals(CellType.STAIR)) {
                isLevelBeaten = true;
            }
        }

        monsters.removeAll(deadMonsters);
    }

    private void openStair() {
        for (Cell[] row : cells) {
            for (Cell column : row) {
                if (column.getType().equals(CellType.INVISIBLE_STAIR)) {
                    column.setType(CellType.STAIR);
                    break;
                }
            }
        }
    }

    private void dropKey(Monster lastKilledMonster) {
        Cell lastMonsterCell = lastKilledMonster.getCell();
        lastMonsterCell.setItem(new Key(lastMonsterCell));
    }
}
