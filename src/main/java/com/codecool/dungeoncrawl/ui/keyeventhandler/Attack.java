package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Attack implements KeyHandler{
  public static final KeyCode code = KeyCode.A;

  @Override
  public void perform(KeyEvent event, GameMap map) {
    Cell[] neighbouringCells = new Cell[4];
    Cell playerCell = map.getPlayer().getCell();
    neighbouringCells[0] = playerCell.getNeighbor(1, 0);
    neighbouringCells[1] = playerCell.getNeighbor(-1, 0);
    neighbouringCells[2] = playerCell.getNeighbor(0, 1);
    neighbouringCells[3] = playerCell.getNeighbor(0, -1);

    for (Cell neighbouringCell : neighbouringCells) {
      if (code.equals(event.getCode())) {
        if (neighbouringCell.getActor() != null) {
          map.getPlayer().attack(neighbouringCell.getActor());
        }

      }


    }

  }
}
