package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {
  GameMap map = new GameMap(3, 3, CellType.FLOOR);
  GameLogicFake logic = new GameLogicFake(map);

  @Test
  void getPlayerStrength() {
    Player player = new Player(map.getCell(1,1));
    map.setPlayer(player);

    String expected = "5";
    String playerStrength = logic.getPlayerStrength();

    assertEquals(expected, playerStrength);
  }

  @Test
  void getPlayerDefense() {
  }

  @Test
  void getMonsterHealth() {
  }

  @Test
  void getMonsterStrength() {
  }

  @Test
  void getPlayerInventory() {
  }

  @Test
  void moveMonsters() {

  }
}