package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;

public class RatBoss extends Monster {
  private static final int BASE_HEALTH = 30;
  private static final int BASE_POWER = 7;
  private static final int XP_VALUE = 5;
  private static final String ABILITY =
          "Rats are sneaky and can disappear from sight, also spreading disease weakening the player";
  private static final String TILE_NAME = "ratBoss";

  public RatBoss(Cell cell) {
    super(cell, BASE_HEALTH, BASE_POWER, ABILITY, TILE_NAME, XP_VALUE);
  }
}
