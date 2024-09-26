package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMaps.GameMap;

public class BlueMoopsy extends Moopsy {
  private static int baseHealth = 15;
  private static final int BASE_POWER = 10;
  private static final int XP_VALUE = 5;
  private static final String ABILITY =
          "When Moopsy's HP is half of the starting rate \nit divides into two Moopsies... " +
                  "\nuntil it dies. \nOh, and they can still teleport.";
  private static final String[] TILE_NAMES = {
          "blueMoopsy1",
          "blueMoopsy2",
          "blueMoopsy3",
          "blueMoopsy4",
          "blueMoopsy5",
  };

  public BlueMoopsy(Cell cell) {
    super(cell, baseHealth, BASE_POWER, ABILITY, TILE_NAMES[0], XP_VALUE);
  }

  @Override
  public boolean isHalfHP() {
    return false;
  }

  @Override
  public Moopsy[] split() {
    return new Moopsy[2];
  }
}
