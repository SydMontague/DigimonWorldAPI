package de.phoenixstaffel.dmw.api;

import java.util.Arrays;
import java.util.List;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.world.Inventory;
import de.phoenixstaffel.dmw.core.CompoundStructure;
import de.phoenixstaffel.dmw.core.Structure;

public class Player extends CompoundStructure {
    private static final long START_PLAYER = 0xBAD10C;
    private static final long START_INVENTORY = 0xB94E14;
    
    private PlayerEntity entity;
    private Inventory inventory;
    
    public Player(DigimonWorldAPI main) {
        entity = new PlayerEntity(main, START_PLAYER);
        inventory = new Inventory(main, START_INVENTORY);
    }
    
    public PlayerEntity getEntity() {
        return entity;
    }
    
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public List<Structure> getChildStructures() {
        return Arrays.asList(entity, inventory);
    }
}
