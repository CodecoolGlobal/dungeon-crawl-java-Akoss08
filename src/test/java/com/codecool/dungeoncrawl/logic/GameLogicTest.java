package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Spider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLogicTest {
  GameMap map = new GameMap(3, 3, CellType.FLOOR);

  @Test
  void getNeighbouringMonster() {
    Player player = new Player(map.getCell(1, 1));
    map.setPlayer(player);
    //Cell playerCell = map.getPlayer().getCell();
    Monster monster = new Spider(map.getCell(1, 0));

    Actor result = map.getMonster();
    assertEquals(1, result.getX());
    assertEquals(0, result.getY());
  }
}
