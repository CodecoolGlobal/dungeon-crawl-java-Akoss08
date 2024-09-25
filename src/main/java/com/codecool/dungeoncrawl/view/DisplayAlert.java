package com.codecool.dungeoncrawl.view;

import com.codecool.dungeoncrawl.data.mapElements.actors.Inventory;
import com.codecool.dungeoncrawl.data.mapElements.items.Item;
import javafx.scene.control.*;

import java.util.*;

public class DisplayAlert {
    public Item getChoice(Inventory shopItems) {
        List<String> items = getItemValues(shopItems);

        ChoiceDialog<String> dialog = setDialog(items);

        String result = dialog.showAndWait().orElse(null);

        if (result != null && !result.equals("--SELECT AN ITEM--")) {
            String selectedItem = result.split(":")[0];

            return shopItems.getItems().stream()
                    .filter(item -> item.getTileName().equalsIgnoreCase(selectedItem)).
                    findFirst().
                    orElse(null);
        }

        return null;
    }

    private List<String> getItemValues(Inventory shopItems) {
        List<String> items = new ArrayList<>();

        for (Item item : shopItems.getItems()) {
            items.add(item.getTileName().toUpperCase() + ": " + item.getPrice() + " GOLD");
        }
        return items;
    }

    private ChoiceDialog<String> setDialog(List<String> items) {
        ChoiceDialog<String> dialog = new ChoiceDialog<>("--SELECT AN ITEM--", items);
        dialog.setTitle("Shopkeeper's Wares");
        dialog.setHeaderText("Choose an item to buy");
        dialog.setContentText("Select an item:");
        return dialog;
    }
}
