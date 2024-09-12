package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

import java.util.ArrayList;
import java.util.List;

public class Boss extends Monster{
  public Boss(Cell cell) {
    super(cell);
    setAttackStrength(10);
    setHealth(20);
  }

  @Override
  public String getTileName() {
    return "duckBoss";
  }

//  public void followPlayer() {
//    List<Cell> bossNeighbours = this.getCell().getBossNeighbours();
//    Cell playerCell = null;
//    List<Cell> playerNeighbours;
//    List<Cell> commonNeighbours = new ArrayList<>();
//    List<Cell> walkableCommonNeighbours = new ArrayList<>();
//    for (Cell cell : bossNeighbours) {
//      if (cell.getActor() instanceof Player) {
//        playerCell = cell;
//      }
//    }
//    if (playerCell != null) {
//      playerNeighbours = playerCell.getNeighbors();
//
//      for (Cell playerNeighbour : playerNeighbours) {
//        for (Cell bossNeighbour : bossNeighbours) {
//          if (playerNeighbour.getX() == bossNeighbour.getX()
//                  && playerNeighbour.getY() == bossNeighbour.getY()) {
//            commonNeighbours.add(bossNeighbour);
//          }
//        }
//      }
//
//      for (Cell commonNeighbour : commonNeighbours) {
//        if (commonNeighbour.isWalkable()) {
//          walkableCommonNeighbours.add(commonNeighbour);
//        }
//      }
//    }
//  }

}
