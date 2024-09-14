package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

import java.util.List;

public class ChickenBoss extends Monster {

    public ChickenBoss(Cell cell, int health, int strength, int defense, String ability) {
        super(cell, health, strength, defense, ability);
    }

    @Override
    public String getTileName() {
        return "duckBoss";
    }

    @Override
    public void move(int dx, int dy) {
        Cell nextCell = getCell().getNeighbor(dx, dy);
        boolean isWalkable = getCell().isWalkable(nextCell);
        int bossHorPos = dx * 2;
        int bossVerPos = dy * 2;

        if (dx != 0 && isWalkable) {
            super.move(bossHorPos, dy);
        } else if (isWalkable) {
            super.move(dx, bossVerPos);
        }

        attackPlayer();
    }

    private void attackPlayer() {
        List<Cell> neighboringCells = getCell().getNeighbors();

        for (Cell neighbor : neighboringCells) {
            Actor player = neighbor.getActor();

            if (player instanceof Player) {
                attack((Player) player);
                break;
            }
        }
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
