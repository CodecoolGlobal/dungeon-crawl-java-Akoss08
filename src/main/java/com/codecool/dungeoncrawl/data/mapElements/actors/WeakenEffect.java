package com.codecool.dungeoncrawl.data.mapElements.actors;

public class WeakenEffect extends Effect {
    private final int weakenPower;

    public WeakenEffect(int duration, int weakenPower) {
        super(duration);
        this.weakenPower = weakenPower;
    }

    @Override
    public void apply(Player player) {
        if (player.getAttackStrength() > 0) {
            player.setAttackStrength(Math.max(player.getAttackStrength() - weakenPower, 0));
        }
    }

    @Override
    public void remove(Player player) {
        player.setAttackStrength(player.getCurrentPower());
        player.setPoisoned(false);
        player.setActiveEffect(null);
    }
}
