package com.codecool.dungeoncrawl.data.mapElements.actors.monsters;

import com.codecool.dungeoncrawl.data.mapElements.actors.Effect;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;

public class PoisonEffect extends Effect {
  private final int poisonPower;

  public PoisonEffect(int duration, int poisonPower) {
    super(duration);
    this.poisonPower = poisonPower;
  }

  @Override
  public void apply(Player player) {
    player.setHealth(player.getHealth() - poisonPower);
  }

  @Override
  public void remove(Player player) {
    player.setHealth(player.getHealth() + poisonPower);
  }
}
