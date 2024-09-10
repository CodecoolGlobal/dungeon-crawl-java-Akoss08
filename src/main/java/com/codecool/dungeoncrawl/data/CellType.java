package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    DOOR("closedDoor");


    private String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }

    public void setDoorToOpen() {
        DOOR.tileName = "openDoor";
    }
}
