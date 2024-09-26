package com.codecool.dungeoncrawl.data.mapElements.actors;

public abstract class Effect {
    protected int duration;

    public Effect(int duration) {
        this.duration = duration;
    }

    public abstract void apply(Player player);

    public abstract void remove(Player player);

    public boolean isExpired() {
        return duration <= 0;
    }

    public void updateEffectState(Player player) {
        duration--;
        if (isExpired()) {
            remove(player);
        }
    }
}
