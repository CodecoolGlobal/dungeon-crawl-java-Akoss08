package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMaps.GameMap;
import com.codecool.dungeoncrawl.data.GameMaps.Map3;

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

  public abstract boolean isHalfHP();

  public abstract Moopsy[] split(GameMap map);

  public void addMoopsyToMonsters(GameMap map) {
    map.addMonster(this);
  }
}
