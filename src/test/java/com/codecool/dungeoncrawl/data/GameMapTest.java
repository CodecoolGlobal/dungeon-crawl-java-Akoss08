package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Spider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameMapTest {
  GameMap map = new GameMap(3, 3, CellType.FLOOR);

  @Test
  void getBoss() {
  }

  @Test
  void getNeighbouringMonster() {
    Player player = new Player(map.getCell(1, 1));
    map.setPlayer(player);
    Monster monster = new Spider(map.getCell(1, 0));

    Actor result = map.getMonster();
    assertEquals(1, result.getX());
    assertEquals(0, result.getY());
  }

  @Test
  void getMonsterReturnsNullWhenNoNeighbouringMonster() {
    Player player = new Player(map.getCell(1, 1));
    map.setPlayer(player);

    Actor result = map.getMonster();
    assertNull(result);
  }

}