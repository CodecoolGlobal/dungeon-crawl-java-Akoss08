package com.codecool.dungeoncrawl.data.mapElements.npcs;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.mapElements.actors.Inventory;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import com.codecool.dungeoncrawl.data.mapElements.items.BasicSpear;
import com.codecool.dungeoncrawl.data.mapElements.items.HealthPotion;
import com.codecool.dungeoncrawl.data.mapElements.items.RareHelmet;
import com.codecool.dungeoncrawl.view.DisplayAlert;

import static javafx.application.Application.launch;


public class ShopKeeper extends Npc {
    private static final String BASE_DIALOG = "Welcome, traveler!\n" +
            "Looking to buy something?\n" +
            "I've got the finest goods around.";
    private static final String TILE_NAME = "shopKeeper";
    private final DisplayAlert display;
    private final Inventory inventory;

    public ShopKeeper(Cell cell) {
        super(BASE_DIALOG, cell, TILE_NAME);
        display = new DisplayAlert();
        inventory = new Inventory();
        inventory.addItem(new BasicSpear());
        inventory.addItem(new RareHelmet());
        inventory.addItem(new HealthPotion());
        System.out.println(new BasicSpear().getTileName());
    }

    @Override
    public void interact(Player player) {
        display.listShopItems(inventory);
    }
}
