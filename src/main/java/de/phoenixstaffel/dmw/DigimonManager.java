package de.phoenixstaffel.dmw;

import java.util.ArrayList;
import java.util.List;

import de.phoenixstaffel.dmw.api.Digimon;
import de.phoenixstaffel.dmw.api.enums.DigimonLevel;

public class DigimonManager {
    private List<Digimon> digimonList = new ArrayList<>();
    
    public DigimonManager(DigimonWorldAPI randomizer) {
        for (short i = 0; i < 180; i++)
            digimonList.add(new Digimon(randomizer, i));
    }
    
    public Digimon getDigimon(short id) {
        return id == -1 || digimonList.size() <= id ? null : digimonList.get(id);
    }
    
    public Digimon getDigimonByName(String name) {
        for (Digimon digimon : digimonList)
            if (digimon.getGeneralValues().getName().equalsIgnoreCase(name))
                return digimon;
        
        return null;
    }
    
    public List<Digimon> getDigimonByLevel(DigimonLevel level) {
        List<Digimon> digimons = new ArrayList<>();
        
        for (Digimon digimon : digimonList)
            if (digimon.getGeneralValues().getDigimonLevel() == level)
                digimons.add(digimon);
        
        return digimons;
    }
    
    public List<Digimon> getDigimons() {
        return digimonList;
    }
}
