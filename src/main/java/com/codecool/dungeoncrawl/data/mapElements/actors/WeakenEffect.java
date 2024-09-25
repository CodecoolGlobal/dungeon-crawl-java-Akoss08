package com.codecool.dungeoncrawl.data.mapElements.actors;

public class WeakenEffect extends Effect {
  private final int weakenPower;

  public WeakenEffect(int duration, int weakenPower) {
    super(duration);
    this.weakenPower = weakenPower;
  }

  @Override
  public void apply(Player player) {
    player.setAttackStrength(player.getAttackStrength() - weakenPower);
  }

  @Override
  public void remove(Player player) {
    player.setAttackStrength(player.getAttackStrength() + weakenPower);
  }
}
