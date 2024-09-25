package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;

public class BlueMoopsy extends Moopsy {
  private static int baseHealth = 0;
  private static final int BASE_POWER = 4;
  private static final int XP_VALUE = 5;
  private static final String ABILITY =
          "When Moopsy's HP is half of the starting rate it divides into two Moopsies... " +
                  "\nuntil it dies. \nOh, and they can still teleport.";
  private static final String[] TILE_NAMES = {
          "blueMoopsy1",
          "blueMoopsy2",
          "blueMoopsy3",
          "blueMoopsy4",
          "blueMoopsy5",
          "blueMoopsy6"
  };

  public BlueMoopsy(Cell cell, int moopsyHPBeforeSplit) {
    super(cell, baseHealth, BASE_POWER, ABILITY, TILE_NAMES[0], XP_VALUE);
    baseHealth = moopsyHPBeforeSplit;
  }

}
