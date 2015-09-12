package de.phoenixstaffel.dmw.api;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.core.CompoundStructure;

public class Player extends CompoundStructure {
    private static final long START_PLAYER = 0xBAD10C;
    
    private PlayerEntity entity;
    
    public Player(DigimonWorldAPI main) {
        entity = new PlayerEntity(main, START_PLAYER);
    }
    
    public PlayerEntity getEntity() {
        return entity;
    }
}
