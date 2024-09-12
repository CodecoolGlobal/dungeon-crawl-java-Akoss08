package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.GameMap;

import java.lang.reflect.Field;

public class GameLogicFake extends GameLogic{

  public GameLogicFake(GameMap testMap) {
    super();

    try {
      Field map = GameLogic.class.getDeclaredField("map");
      map.setAccessible(true);
      map.set(this, testMap);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
