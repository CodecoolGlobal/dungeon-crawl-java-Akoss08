package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;

public class YellowMoopsy extends Moopsy {
  private static final int BASE_HEALTH = 30;
  private static final int BASE_POWER = 9;
  private static final int XP_VALUE = 10;
  private static final String ABILITY =
          "When Moopsy's HP is half of the starting rate it divides into two Moopsies. Oh, and they can also teleport.";
  private static final String TILE_NAME = "yellowMoopsy1";
  private static final String[] TILE_NAMES = {
          "yellowMoopsy1",
          "yellowMoopsy2",
          "yellowMoopsy3",
          "yellowMoopsy4",
          "yellowMoopsy5",
          "yellowMoopsy6"
  };

  public YellowMoopsy(Cell cell) {
    super(cell, BASE_HEALTH, BASE_POWER, ABILITY, TILE_NAMES[0], XP_VALUE);
  }

  /*@Override
  public String getTileName() {

  }*/


}
