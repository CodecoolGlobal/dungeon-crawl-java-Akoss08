package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;

public class Crocodile extends Monster{
  private static final int BASE_HEALTH = 20;
  private static final int BASE_POWER = 7;
  private static final int BASE_DEFENSE = 2;
  private static final int XP_VALUE = 5;
  private static final String ABILITY = "Crocodiles have thick skin, it adds 2 defense";
  private static final String TILE_NAME = "crocodile";

  public Crocodile(Cell cell) {
    super(cell, BASE_HEALTH, BASE_POWER, BASE_DEFENSE, ABILITY, TILE_NAME, XP_VALUE);
  }
}
