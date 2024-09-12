package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;

public class Boss extends Monster{
  public Boss(Cell cell) {
    super(cell);
    setAttackStrength(10);
    setHealth(20);
  }

  @Override
  public String getTileName() {
    return "boss";
  }
}
