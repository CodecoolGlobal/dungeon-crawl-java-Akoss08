package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMaps.GameMap;

import java.util.List;
import java.util.Random;

public class YellowMoopsy extends Moopsy {
  private static final int BASE_HEALTH = 30;
  private static final int BASE_POWER = 5;
  private static final int XP_VALUE = 10;
  private static final String ABILITY =
          "When Moopsy's HP is half of the starting rate \nit divides into two Moopsies. \nOh, and they can also teleport.";
  private static final String[] TILE_NAMES = {
          "yellowMoopsy1",
          "yellowMoopsy2",
          "yellowMoopsy3",
          "yellowMoopsy4",
          "yellowMoopsy5",
  };

  private int tileIndex = 0;

  public YellowMoopsy(Cell cell) {
    super(cell, BASE_HEALTH, BASE_POWER, ABILITY, TILE_NAMES[0], XP_VALUE);
  }

  @Override
  public String getTileName() {
    String currentTileName = TILE_NAMES[tileIndex];

    tileIndex = (tileIndex + 1) % TILE_NAMES.length;
    return currentTileName;
  }

  public BlueMoopsy[] split() {
    //current moopsy die, 2 blueMoopsies born -> spawn on random neighbouring cell
    List<Cell> walkableNeighbors = cell.getWalkableNeighbors();
    this.die();
    int randomIndex;

    BlueMoopsy[] newMoopsies = new BlueMoopsy[2];

    for (int i = 0; i < 2; i++) {
      randomIndex = new Random().nextInt(walkableNeighbors.size());
      Cell randomNeighbor = walkableNeighbors.get(randomIndex);
      walkableNeighbors.remove(randomIndex);
      BlueMoopsy moopsy = new BlueMoopsy(randomNeighbor);
      randomNeighbor.setActor(moopsy);
      newMoopsies[i] = moopsy;
    }

    return newMoopsies;
  }

  @Override
  public boolean isHalfHP() {
    return health <= BASE_HEALTH/2;
  }
}
