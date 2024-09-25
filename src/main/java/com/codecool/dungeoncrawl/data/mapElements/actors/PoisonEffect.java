package com.codecool.dungeoncrawl.data.mapElements.actors;

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
