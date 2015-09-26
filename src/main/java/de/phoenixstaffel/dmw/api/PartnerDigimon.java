package de.phoenixstaffel.dmw.api;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.world.PartnerDigimonEntity;
import de.phoenixstaffel.dmw.core.CompoundStructure;

public class PartnerDigimon extends CompoundStructure {
    private static final long START_PARTNER = 0xBAD148;
    private static final long VALUES_START = 0xB8FE00;
    
    private PartnerDigimonEntity entity;
    private PartnerValues values;
    
    public PartnerDigimon(DigimonWorldAPI main) {
        entity = new PartnerDigimonEntity(main, START_PARTNER);
        values = new PartnerValues(main, VALUES_START);
    }
    
    public PartnerDigimonEntity getEntity() {
        return entity;
    }
    
    public PartnerValues getPartnerValues() {
        return values;
    }
}
