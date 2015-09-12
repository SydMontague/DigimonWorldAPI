package de.phoenixstaffel.dmw.api;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.world.PartnerDigimonEntity;
import de.phoenixstaffel.dmw.core.CompoundStructure;

public class PartnerDigimon extends CompoundStructure {
    private static final long START_PARTNER = 0xBAD148;
    private PartnerDigimonEntity entity;
    
    public PartnerDigimon(DigimonWorldAPI main) {
        entity = new PartnerDigimonEntity(main, START_PARTNER);
    }
    
    public PartnerDigimonEntity getEntity() {
        return entity;
    }
}
