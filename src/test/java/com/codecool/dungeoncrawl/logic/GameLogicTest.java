package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.*;
import com.codecool.dungeoncrawl.data.mapElements.items.Item;
import com.codecool.dungeoncrawl.data.mapElements.items.Key;
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
    Player player = new Player(map.getCell(1,1));
    map.setPlayer(player);

    String expected = "0";
    String playerDefense = logic.getPlayerDefense();

    assertEquals(expected, playerDefense);
  }

  @Test
  void getMonsterHealth() {
    Monster spider = new Spider(map.getCell(0, 0));
    map.addMonster(spider);

    String spiderExpectedHealth = "20";
    String spiderHealth = logic.getMonsterHealth();

    assertEquals(spiderExpectedHealth, spiderHealth);
  }

  @Test
  void getMonsterStrength() {
    Monster scorpion = new Scorpion(map.getCell(0, 0));
    map.addMonster(scorpion);

    String expected = "7";
    String monsterStrength = logic.getMonsterStrength();

    assertEquals(expected, monsterStrength);
  }

  /*@Test
  void getPlayerInventory() {
    Player player = new Player(map.getCell(1,1));
    map.setPlayer(player);
    Item key = new Key(map.getCell(1,1));

  }

  @Test
  void moveMonsters() {

  }*/
}