package com.codecool.dungeoncrawl.data.mapElements.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.mapElements.items.Chest;
import com.codecool.dungeoncrawl.data.mapElements.actors.monsters.Monster;
import com.codecool.dungeoncrawl.data.mapElements.items.*;
import com.codecool.dungeoncrawl.data.mapElements.items.Weapon;
import com.codecool.dungeoncrawl.data.mapElements.npcs.Npc;
import com.codecool.dungeoncrawl.ui.DisplayAlert;
import javafx.application.Platform;

import java.util.List;

public class Player extends Actor {
    private static int baseHealth = 10;
    private static final int BASE_POWER = 5;

    private int currentPower = 5;

    private static final int BASE_DEFENSE = 0;

    private int level = 1;
    private static final int MULTIPLIER_TO_LEVEL_UP = 10;
    private static final int MULTIPLIER_FOR_HEALTH_ON_LEVEL_UP = 3;
    private static final int MULTIPLIER_FOR_STRENGTH_ON_LEVEL_UP = 2;
    private int xp = 0;
    private int gold = 0;
    private final Inventory inventory;
    private PowerPotion powerBoost;
    private Weapon currentWeapon;
    private Armor currentArmor;

    private boolean isPoisoned = false;

    private Effect activeEffect;

    public Player(Cell cell, String tileName) {
        super(cell, baseHealth, BASE_POWER, BASE_DEFENSE, tileName);
        this.inventory = new Inventory();
    }

    public void applyEffect(Effect effect) {
        activeEffect = effect;
        isPoisoned = true;
    }

    public int getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(int currentPower) {
        this.currentPower += currentPower;
    }

    public void setActiveEffect(Effect activeEffect) {
        this.activeEffect = activeEffect;
    }

    public void updateEffects() {
        activeEffect.updateEffectState(this);
    }

    public void setPoisoned(boolean poisoned) {
        isPoisoned = poisoned;
    }

    public int getLevel() {
        return level;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public boolean hasWeapon() {
        return currentWeapon != null;
    }

    public void dropWeapon() {
        attackStrength -= currentWeapon.getDamage();
        inventory.getItems().remove(currentWeapon);
        currentWeapon = null;
    }

    public void setCurrentArmor(Armor currentArmor) {
        this.currentArmor = currentArmor;
    }

    public boolean hasArmor() {
        return currentArmor != null;
    }

    public void dropArmor() {
        defense -= currentArmor.getDefense();
        inventory.getItems().remove(currentArmor);
        currentArmor = null;
    }

    public int getXp() {
        return xp;
    }

    public int getGold() {
        return gold;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getBaseHealth() {
        return baseHealth;
    }


    @Override
    public void move(int dx, int dy) {
        if (isPoisoned) {
            activeEffect.apply(this);
            updateEffects();
        }
        Cell nextCell = cell.getNeighbor(dx, dy);
        boolean isClosedDoor = nextCell.getType().equals(CellType.CLOSED_DOOR);

        if (nextCell.isWalkable()) {
            setNextMove(nextCell);
        } else if (isClosedDoor) {
            boolean doorOpened = tryOpenDoor(nextCell);

            if (doorOpened) {
                setNextMove(nextCell);
            }
        }

        if (health <= 0) {
            die();
        }
    }


    public void attack() {
        List<Cell> neighbors = cell.getNeighbors();

        for (Cell neighbor : neighbors) {
            Actor monster = neighbor.getActor();

            if (monster instanceof Monster) {
                attackMonster((Monster) monster);
            }
        }
    }

    @Override
    public void die() {
        super.die();
        DisplayAlert.displayGameOver();
        Platform.exit();
    }

    private void attackMonster(Monster monster) {
        if (powerBoost != null) {
            applyPowerUp();
        }

        int monsterHealth = monster.getHealth();
        int playerStrength = Math.max(attackStrength - monster.getDefense(), 0);
        int monsterNewHealth = monsterHealth - playerStrength;

        monster.setHealth(monsterNewHealth);

        monster.attack(this);

        if (health <= 0) {
            die();
        }
    }

    private void applyPowerUp() {
        if (powerBoost.getDuration() == 0) {
            powerBoost.resetPowerBoost(this);
            powerBoost = null;
        } else {
            powerBoost.decreaseDuration();
        }
    }

    private boolean tryOpenDoor(Cell nextCell) {
        if (inventory.getItems().removeIf(item -> item instanceof Key)) {
            nextCell.setType(CellType.OPEN_DOOR);
            return true;
        }

        return false;
    }

    private void setNextMove(Cell nextCell) {
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
        pickUpItemIfAny();
    }

    private void pickUpItemIfAny() {
        Item item = cell.getItem();

        if (item != null) {
            cell.setItem(null);
            item.addToPlayer(this);
        }
    }

    public void openChest() {
        List<Cell> neighborsCell = cell.getNeighbors();

        for (Cell neighbor : neighborsCell) {
            Chest chest = neighbor.getChest();

            if (chest != null && !chest.isOpen()) {
                neighbor.setType(CellType.OPEN_CHEST);
                Item chestItem = chest.openChest();
                chestItem.addToPlayer(this);
            }
        }
    }

    public void heal() {
        Item toRemove = null;

        for (Item item : inventory.getItems()) {
            if (item instanceof HealthPotion) {
                HealthPotion healthBoost = (HealthPotion) item;
                healthBoost.use(this);
                toRemove = healthBoost;
                break;
            }
        }

        inventory.getItems().remove(toRemove);
    }

    public void powerUp() {
        Item toRemove = null;

        for (Item item : inventory.getItems()) {
            if (item instanceof PowerPotion) {
                powerBoost = (PowerPotion) item;
                powerBoost.use(this);
                toRemove = item;
                break;
            }
        }

        inventory.getItems().remove(toRemove);
    }

    public void collectXp(int xp) {
        this.xp += xp;
        if (this.xp >= level * MULTIPLIER_TO_LEVEL_UP) {
            levelUp();
        }
    }

    public void collectGold(int gold) {
        this.gold += gold;
    }

    private void levelUp() {
        baseHealth += level * MULTIPLIER_FOR_HEALTH_ON_LEVEL_UP;
        health = baseHealth;
        attackStrength += level * MULTIPLIER_FOR_STRENGTH_ON_LEVEL_UP;
        currentPower = attackStrength;
        defense += level;
        level++;
        this.xp = 0;
    }

    public void interactWithNpc() {
        List<Cell> neighborsCell = cell.getNeighbors();

        for (Cell neighbor : neighborsCell) {
            Npc npc = neighbor.getNpc();

            if (npc != null) {
                npc.interact(this);
            }
        }
    }

    public boolean hasThreeTeeth(int requiredTeeth) {
        boolean hasTeeth = inventory.getItems().stream().
                filter(item -> item instanceof SnakeTooth).
                count() == requiredTeeth;
        if (hasTeeth) {
            inventory.getItems().removeIf(item -> item instanceof SnakeTooth);
            return true;
        }

        return false;
    }

    public boolean hasMoneyForItem(Item item) {
        return gold >= item.getPrice();
    }

    public void payForItem(int price) {
        gold -= price;
    }
}
