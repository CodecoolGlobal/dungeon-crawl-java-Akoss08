package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;

import java.util.Random;

public class RatBoss extends Monster {
  private static final int BASE_HEALTH = 30;
  private static final int BASE_POWER = 7;
  private static final int XP_VALUE = 5;
  private static final String ABILITY =
          "Rats are sneaky and can disappear from sight, also spreading disease weakening the player by 2";
  private static final String TILE_NAME = "ratBoss";

  public RatBoss(Cell cell) {
    super(cell, BASE_HEALTH, BASE_POWER, ABILITY, TILE_NAME, XP_VALUE);
  }

  @Override
  public String getTileName() {
    Random random = new Random();
    boolean isDisappearing = random.nextBoolean();
    if (isDisappearing) {
      return cell.getTileName();
    } else {
      return TILE_NAME;
    }
  }

}
