package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty", false),
    FLOOR("floor", true),
    WALL("wall", false),
    CLOSED_DOOR("closedDoor", false),
    OPEN_DOOR("openDoor", true),
    CLOSED_CHEST("closedChest", false),
    OPEN_CHEST("openChest", false),
    INVISIBLE_STAIR("invisibleStair", true),
    STAIR("stair", true);


    private final String tileName;
    private final boolean isWalkable;

    CellType(String tileName, boolean isWalkable) {
        this.tileName = tileName;
        this.isWalkable = isWalkable;
    }

    public String getTileName() {
        return tileName;
    }

    public boolean isWalkable() {
        return isWalkable;
    }
}
