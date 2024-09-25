package com.codecool.dungeoncrawl.view;

import com.codecool.dungeoncrawl.data.mapElements.actors.Inventory;
import com.codecool.dungeoncrawl.data.mapElements.items.Item;
import javafx.scene.control.*;

public class DisplayAlert {

    public void listShopItems(Inventory shopItems) {
        System.out.println(shopItems);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Shopkeeper's Wares");
        alert.setHeaderText(null);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < shopItems.getItems().size(); i++) {
            Item currentItem = shopItems.getItems().get(i);
            builder.append(i + 1).append(". ").
                    append(currentItem.getTileName().toUpperCase()).append(", ").
                    append(currentItem.getPrice()).append(" GOLD").append("\n");
        }
        alert.setContentText(builder.toString());
        alert.showAndWait();
    }
}
