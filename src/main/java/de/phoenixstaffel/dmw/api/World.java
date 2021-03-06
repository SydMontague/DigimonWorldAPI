package de.phoenixstaffel.dmw.api;

import java.util.Arrays;
import java.util.List;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.world.Time;
import de.phoenixstaffel.dmw.core.CompoundStructure;
import de.phoenixstaffel.dmw.core.Structure;

public class World extends CompoundStructure {
    private PartnerDigimon partner;
    private Player player;
    private Time time;
    
    public World(DigimonWorldAPI main) {
        partner = new PartnerDigimon(main);
        player = new Player(main);
        time = new Time(main);
    }
    
    public PartnerDigimon getPartner() {
        return partner;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public Time getTime() {
        return time;
    }

    @Override
    public List<Structure> getChildStructures() {
        return Arrays.asList(partner, player, time);
    }
}
