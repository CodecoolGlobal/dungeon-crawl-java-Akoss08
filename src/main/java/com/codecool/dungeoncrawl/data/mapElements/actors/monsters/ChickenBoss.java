package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import com.codecool.dungeoncrawl.data.mapElements.items.Gold;

import java.util.List;

public class ChickenBoss extends Monster {
    private static final int BASE_HEALTH = 20;
    private static final int BASE_POWER = 7;
    private static final int XP_VALUE = 5;
    private static final String ABILITY = "Chicken can fly 2 cells and attacks immediately";
    private static final String TILE_NAME = "chickenBoss";

    public ChickenBoss(Cell cell) {
        super(cell, BASE_HEALTH, BASE_POWER, ABILITY, TILE_NAME, XP_VALUE);
    }

    @Override
    public void move(int dx, int dy) {
        int bossHorPos = dx * 2;
        int bossVerPos = dy * 2;

        if (dx != 0) {
            super.move(bossHorPos, dy);
        } else {
            super.move(dx, bossVerPos);
        }

        attackPlayer();
    }

    private void attackPlayer() {
        List<Cell> neighboringCells = cell.getNeighbors();

        for (Cell neighbor : neighboringCells) {
            Actor player = neighbor.getActor();

            if (player instanceof Player) {
                attack((Player) player);
                if (player.getHealth() <= 0) {
                    ((Player) player).die();
                }
                break;
            }
        }
    }

    @Override
    protected void die() {
        super.die();
        cell.setItem(new Gold(cell, 50));
    }

}
