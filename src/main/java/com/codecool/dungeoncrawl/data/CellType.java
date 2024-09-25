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
    STAIR("stair", true),
    SIMPLE_TREE("simpleTree", false),
    DOUBLE_TREE("doubleTree", false),
    PINE_TREE("pineTree", false),
    DOUBLE_PINE("doublePine", false),
    WATER_VERTICAL("water", false),
    WATER_ROTATE_90("waterRotate90", false),
    WATER_CROSSING("waterCrossing", false),
    WATER_TURN("waterTurn", false),
    WATER_TURN_ROTATE_90("waterTurnRotate90", false),
    WATER_TURN_ROTATE_180("waterTurnRotate180", false),
    WATER_TURN_ROTATE_270("waterTurnRotate270", false),
    BRIDGE("bridge", true),
    GRASS("grass", true),
    FLOWER("flower", true),
    TREE_STUMP("treeStump", false);

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
