package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Effect;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import com.codecool.dungeoncrawl.data.mapElements.actors.WeakenEffect;

import java.util.Random;

public class RatBoss extends Monster {
  private static final int BASE_HEALTH = 30;
  private static final int BASE_POWER = 7;
  private static final int XP_VALUE = 5;
  private static final String ABILITY =
          "Rats are sneaky and can disappear from sight, \nalso spreading disease weakening the player by 2";
  private static final String TILE_NAME = "ratBoss";
  private static final Effect WEAKEN = new WeakenEffect(2,2);

  public RatBoss(Cell cell) {
    super(cell, BASE_HEALTH, BASE_POWER, ABILITY, TILE_NAME, XP_VALUE);
  }

  @Override
  public String getTileName() {
    boolean isDisappearing = Math.random() >= 0.7;
    if (isDisappearing) {
      return cell.getTileName();
    } else {
      return TILE_NAME;
    }
  }

  @Override
  public void attack(Player player) {
    if (health <= 0) {
      die();
      player.collectXp(XP_VALUE);
    } else {
      weaken(player);

      int playerHealth = player.getHealth();
      int monsterStrength = Math.max(attackStrength - player.getDefense(), 0);
      int playerNewHealth = playerHealth - monsterStrength;

      player.setHealth(playerNewHealth);
    }
  }

  private void weaken(Player player) {
    player.applyEffect(WEAKEN);
  }

}
