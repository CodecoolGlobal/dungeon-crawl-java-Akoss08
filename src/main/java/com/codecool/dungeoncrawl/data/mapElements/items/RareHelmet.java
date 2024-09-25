package com.codecool.dungeoncrawl.data.mapElements.items;

public class RareHelmet extends Armor {
    private static final int PRICE = 20;
    private static final int PLUS_DEFENSE = 4;
    private static final String TILE_NAME_FOR_PLAYER = "playerWithSwordAndShieldAndRareHelmet";

    public RareHelmet() {
        super(PRICE, PLUS_DEFENSE, TILE_NAME_FOR_PLAYER);
    }

    @Override
    public String getTileName() {
        return "rareHelmet";
    }
}


