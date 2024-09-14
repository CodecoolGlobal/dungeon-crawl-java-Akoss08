package com.codecool.dungeoncrawl.data.mapElements.actors;

import com.codecool.dungeoncrawl.data.mapElements.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[\n");

        for (Item item : items) {
            str.append(item.getTileName());
            if (item != items.get(items.size() - 1)) {
                str.append(", \n");
            }
        }

        str.append("\n]");
        return str.toString();
    }
}
