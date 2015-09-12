package de.phoenixstaffel.dmw.api;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.core.CompoundStructure;

public class World extends CompoundStructure {
    private PartnerDigimon partner;
    private Player player;
    
    public World(DigimonWorldAPI main) {
        partner = new PartnerDigimon(main);
        player = new Player(main);
    }
    
    public PartnerDigimon getPartner() {
        return partner;
    }
    
    public Player getPlayer() {
        return player;
    }
}
