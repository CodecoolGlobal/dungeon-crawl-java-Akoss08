package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;

public abstract class Moopsy extends Monster {

  public Moopsy(Cell cell, int health, int strength, String ability, String tileName, int xpValue) {
    super(cell, health, strength, ability, tileName, xpValue);
  }

  public void teleport(Cell nextCell) {
    if (nextCell.isWalkable() && !isDead) {
      cell.setActor(null);
      nextCell.setActor(this);
      cell = nextCell;
    }
  }
}
