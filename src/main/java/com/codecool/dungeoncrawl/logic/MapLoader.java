package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.*;
import com.codecool.dungeoncrawl.data.GameMaps.GameMap;
import com.codecool.dungeoncrawl.data.GameMaps.Map1;
import com.codecool.dungeoncrawl.data.GameMaps.Map2;
import com.codecool.dungeoncrawl.data.GameMaps.Map3;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.*;
import com.codecool.dungeoncrawl.data.mapElements.items.Chest;
import com.codecool.dungeoncrawl.data.mapElements.actors.Player;
import com.codecool.dungeoncrawl.data.mapElements.items.*;
import com.codecool.dungeoncrawl.data.mapElements.items.BasicSword;
import com.codecool.dungeoncrawl.data.mapElements.npcs.BridgeGuard;
import com.codecool.dungeoncrawl.data.mapElements.npcs.ShopKeeper;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    private static String fileName = "/map1.txt";
    private static Player existingPlayer;

    public static void setFileName(String fileName) {
        MapLoader.fileName = fileName;
    }

    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream(fileName);
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine();

        GameMap map = null;

        switch (fileName) {
            case "/map1.txt":
                map = new Map1(width, height, CellType.EMPTY);
                break;
            case "/map2.txt":
                map = new Map2(width, height, CellType.EMPTY);
                break;
            case "/map3.txt":
                map = new Map3(width, height, CellType.EMPTY);
                break;
        }

        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    assert map != null;
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            map.addMonster(new Skeleton(cell));
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            if (existingPlayer != null) {
                                cell.setActor(existingPlayer);
                                existingPlayer.setCell(cell);
                                map.setPlayer(existingPlayer);
                            } else {
                                Player newPlayer = new Player(cell, "player");
                                existingPlayer = newPlayer;
                                map.setPlayer(newPlayer);
                            }
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell);
                            break;
                        case 'S':
                            cell.setType(CellType.FLOOR);
                            new BasicSword(cell);
                            break;
                        case 'd':
                            cell.setType(CellType.CLOSED_DOOR);
                            break;
                        case 'b':
                            cell.setType(CellType.FLOOR);
                            map.addMonster(new Scorpion(cell));
                            break;
                        case 'B':
                            cell.setType(CellType.FLOOR);
                            map.addMonster(new Spider(cell));
                            break;
                        case 'c':
                            cell.setType(CellType.CLOSED_CHEST);
                            new Chest(cell, new BasicShield(null));
                            break;
                        case 'h':
                            cell.setType(CellType.FLOOR);
                            new BasicHelmet(cell);
                            break;
                        case 'p':
                            cell.setType(CellType.FLOOR);
                            new HealthPotion(cell);
                            break;
                        case 'D':
                            cell.setType(CellType.FLOOR);
                            map.addMonster(new ChickenBoss(cell));
                            break;
                        case 'i':
                            cell.setType(CellType.INVISIBLE_STAIR);
                            break;
                        case 'f':
                            cell.setType(CellType.PINE_TREE);
                            break;
                        case 'F':
                            cell.setType(CellType.DOUBLE_PINE);
                            break;
                        case 't':
                            cell.setType(CellType.SIMPLE_TREE);
                            break;
                        case 'T':
                            cell.setType(CellType.DOUBLE_TREE);
                            break;
                        case 'w':
                            cell.setType(CellType.WATER_VERTICAL);
                            break;
                        case 'W':
                            cell.setType(CellType.WATER_ROTATE_90);
                            break;
                        case 'x':
                            cell.setType(CellType.WATER_CROSSING);
                            break;
                        case 'r':
                            cell.setType(CellType.WATER_TURN);
                            break;
                        case 'R':
                            cell.setType(CellType.WATER_TURN_ROTATE_90);
                            break;
                        case 'A':
                            cell.setType(CellType.BRIDGE);
                            break;
                        case 'u':
                            cell.setType(CellType.WATER_TURN_ROTATE_180);
                            break;
                        case 'U':
                            cell.setType(CellType.WATER_TURN_ROTATE_270);
                            break;
                        case ',':
                            cell.setType(CellType.GRASS);
                            break;
                        case ';':
                            cell.setType(CellType.FLOWER);
                            break;
                        case 'P':
                            cell.setType(CellType.TREE_STUMP);
                            break;
                        case 'g':
                            cell.setType(CellType.FLOOR);
                            new BridgeGuard(cell);
                            break;
                        case 'a':
                            cell.setType(CellType.FLOOR);
                            Snake snake = new Snake(cell, new SnakeTooth());
                            map.addMonster(snake);
                            break;
                        case 'm':
                            cell.setType(CellType.FLOOR);
                            new ShopKeeper(cell);
                            break;
                        case 'K':
                            cell.setType(CellType.FLOOR);
                            map.addMonster(new Crocodile(cell));
                            break;
                        case 'J':
                            cell.setType(CellType.GRASS);
                            map.addMonster(new RatBoss(cell));
                            break;
                        case 'Y':
                            cell.setType(CellType.FLOOR);
                            Moopsy yellowMoopsy = new YellowMoopsy(cell);
                            map.addMonster(yellowMoopsy);
                            assert map instanceof Map3;
                            ((Map3) map).addMoopsy(yellowMoopsy);
                            break;
                        case 'y':
                            cell.setType(CellType.FLOOR);
                            map.addMonster(new BlueMoopsy(cell));
                        case '2':
                            cell.setType(CellType.SPIKE);
                            break;
                        case '3':
                            cell.setType(CellType.FIRE);
                            break;
                        case '4':
                            cell.setType(CellType.TORCH);
                            break;
                        case '5':
                            cell.setType(CellType.ANIMAL_SKELETON);
                            break;
                        case '6':
                            cell.setType(CellType.CASTLE_MID_FLOOR);
                            break;
                        case '7':
                            cell.setType(CellType.CASTLE_TOP_FLOOR);
                            break;
                        case '8':
                            cell.setType(CellType.CASTLE_TOP_RIGHT_FLOOR);
                            break;
                        case '9':
                            cell.setType(CellType.CASTLE_RIGHT_FLOOR);
                            break;
                        case '=':
                            cell.setType(CellType.CASTLE_BOTTOM_RIGHT_FLOOR);
                            break;
                        case '+':
                            cell.setType(CellType.CASTLE_BOTTOM_FLOOR);
                            break;
                        case '-':
                            cell.setType(CellType.CASTLE_BOTTOM_LEFT_FLOOR);
                            break;
                        case '!':
                            cell.setType(CellType.CASTLE_LEFT_FLOOR);
                            break;
                        case '"':
                            cell.setType(CellType.CASTLE_TOP_LEFT_FLOOR);
                            break;
                        case '£':
                            cell.setType(CellType.GRAVE);
                            break;
                        case '$':
                            cell.setType(CellType.HUMAN_SKELETON);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
