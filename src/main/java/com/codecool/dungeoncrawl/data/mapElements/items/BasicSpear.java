package com.codecool.dungeoncrawl.data.mapElements.items;


public class BasicSpear extends Weapon {
    private static final int PRICE = 60;
    private static final int PLUS_ATTACK = 4;
    private static final String TILE_NAME_FOR_PLAYER = "playerWithSpear";

    public BasicSpear() {
        super(PRICE, PLUS_ATTACK, TILE_NAME_FOR_PLAYER);
    }

    @Override
    public String getTileName() {
        return "spear";
    }
}
