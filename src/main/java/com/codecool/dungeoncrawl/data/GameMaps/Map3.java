package com.codecool.dungeoncrawl.data.GameMaps;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.mapElements.actors.Actor;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Moopsy;
import com.codecool.dungeoncrawl.ui.DisplayAlert;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;

public class Map3 extends GameMap {
    private final List<Moopsy> moopsies;

    public Map3(int width, int height, CellType defaultCellType) {
        super(width, height, defaultCellType);
        moopsies = new ArrayList<>();
    }

    @Override
    public void moveMonsters() {
        List<Moopsy> newMoopsies = new ArrayList<>();

        for (Moopsy moopsy : moopsies) {
            if (moopsy.isHalfHP()) {
                Moopsy[] splitMoopsies = moopsy.split();

                newMoopsies.add(splitMoopsies[0]);
                newMoopsies.add(splitMoopsies[1]);
            }
        }

        moopsies.removeIf(Actor::isDead);
        monsters.addAll(newMoopsies);

        if (monsters.isEmpty()) {
            DisplayAlert.displayWin();
            Platform.exit();
        }

        super.moveMonsters();
    }

    public void addMoopsy(Moopsy moopsy) {
        moopsies.add(moopsy);
    }
}
