package com.codecool.dungeoncrawl.data.GameMaps;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.ui.DisplayAlert;
import javafx.application.Platform;

public class Map3 extends GameMap {
    public Map3(int width, int height, CellType defaultCellType) {
        super(width, height, defaultCellType);
    }

    @Override
    public void moveMonsters() {
        super.moveMonsters();

        if (monsters.isEmpty()) {
            DisplayAlert.displayWin();
            Platform.exit();
        }
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
}
