package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
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

    /*for (Cell neighbouringCell : neighbouringCells) {
      if (code.equals(event.getCode())) {
        if (neighbouringCell.getActor() != null) {
          map.getPlayer().attack(neighbouringCell.getActor());
          break;
        } else {
          System.out.println("There's no one near to attack. Don't fos!");
        }
      }
    }*/

    Actor monster = null;
    if (code.equals(event.getCode())) {
      for (Cell neighbouringCell : neighbouringCells) {
        if (neighbouringCell.getActor() != null) {
          monster = neighbouringCell.getActor();
        }
      }
      if (monster != null) {
        map.getPlayer().attack(monster);
        System.out.println("Monster HP: " + monster.getHealth());
        System.out.println("Player HP: " + map.getPlayer().getHealth());
      } else {
        System.out.println("There's no one near to attack. Don't fos!");
      }
    }

  }
}
