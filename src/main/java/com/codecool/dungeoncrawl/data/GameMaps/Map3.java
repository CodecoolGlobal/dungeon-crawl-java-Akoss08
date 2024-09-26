package com.codecool.dungeoncrawl.data.GameMaps;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Moopsy;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.YellowMoopsy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map3 extends GameMap {
    private List<Moopsy> moopsies;

    public Map3(int width, int height, CellType defaultCellType) {
        super(width, height, defaultCellType);
        moopsies = new ArrayList<>();
    }

    @Override
    public void moveMonsters() {
        System.out.println("moopsies size: " + moopsies.size());
        for (Moopsy moopsy : moopsies) {
            System.out.println("moopsyHP: " + moopsy.getHealth());
            System.out.println("moopsy instanceOf: " + moopsy.getClass());
            if (moopsy.isHalfHP()) {
                Moopsy[] newMoopsies = moopsy.split(this);
                moopsies.removeIf(Actor::isDead);
                addMonster(newMoopsies[0]);
                addMonster(newMoopsies[1]);
                moopsies.add(newMoopsies[0]);
                moopsies.add(newMoopsies[1]);
                //newMoopsies[1].addMoopsyToMonsters(this);
            }
        }

        super.moveMonsters();
    }


//    private void moveMoopsyRandomly(Moopsy moopsy) {
//        List<Cell> walkableCells = getWalkableCells(moopsy);
//        Cell nextCell = walkableCells.get(randomNumber(walkableCells.size()));
//        int currentX = moopsy.getX();
//        int currentY = moopsy.getY();
//        int nextX = nextCell.getX();
//        int nextY = nextCell.getY();
//
//        moveMoopsy(moopsy, nextX - currentX, nextY - currentY);
//    }

//    private void moveMoopsy(Moopsy moopsy, int dx, int dy) {
//        boolean isTeleporting = Math.random() <= 0.1;
//        if (isTeleporting) {
//            moopsy.teleport(getRandomWalkableCell());
//        } else if (moopsy.isHalfHP()) {
//            Moopsy[] newMoopsies = moopsy.split(this);
//            newMoopsies[0].addMoopsyToMonsters(this);
//            newMoopsies[1].addMoopsyToMonsters(this);
//        } else {
//            moopsy.move(dx, dy);
//        }
//    }

//    private Cell getRandomWalkableCell() {
//        Random random = new Random();
//        List<Cell> walkableCells = getWalkableCells();
//        return walkableCells.get(random.nextInt(walkableCells.size()));
//    }

    public void addMoopsy(Moopsy moopsy) {
        moopsies.add(moopsy);
    }
}
