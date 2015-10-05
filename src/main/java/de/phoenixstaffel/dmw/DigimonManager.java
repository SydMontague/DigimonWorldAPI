package de.phoenixstaffel.dmw;

import java.util.ArrayList;
import java.util.List;

import de.phoenixstaffel.dmw.api.Digimon;

public class DigimonManager {
    private List<Digimon> digimonList = new ArrayList<>();
    
    public DigimonManager(DigimonWorldAPI randomizer) {
        for (short i = 0; i < 180; i++)
            digimonList.add(new Digimon(randomizer, i));
    }
    
    public Digimon getDigimon(short id) {
        return digimonList.get(id);
    }
    
    public Digimon getDigimon(String name) {
        for(Digimon digimon : digimonList)
            if(digimon.getGeneralValues().getName().equalsIgnoreCase(name))
                return digimon;
        
        return null;
    }

    public List<Digimon> getDigimons() {
        return digimonList;
    }
}
