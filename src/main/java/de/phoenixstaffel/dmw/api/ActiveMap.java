package de.phoenixstaffel.dmw.api;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.map.DigimonEncounter;
import de.phoenixstaffel.dmw.api.map.DroppedItem;

public class ActiveMap {
    
    private static final long START_DIGIMON = 0xBAD1C8;
    private static final int DIGIMON_COUNT = 8;
    private static final long START_DROPPED_ITEM = 0xB94E80;
    private static final int DROPPED_ITEM_COUNT = 11;
    
    private DigimonEncounter[] digimons = new DigimonEncounter[DIGIMON_COUNT];
    private DroppedItem[] items = new DroppedItem[DROPPED_ITEM_COUNT];
    
    public ActiveMap(DigimonWorldAPI main) {
        for (short id = 0; id < DIGIMON_COUNT; id++)
            digimons[id] = new DigimonEncounter(main, START_DIGIMON, id);
        
        for (short id = 0; id < DROPPED_ITEM_COUNT; id++)
            items[id] = new DroppedItem(main, START_DROPPED_ITEM, id);
    }
    
    public DigimonEncounter getEncounter(byte id) {
        if (id < 0 || id > DIGIMON_COUNT)
            return null;
        
        return digimons[id];
    }
    
    public DroppedItem getDroppedItem(byte id) {
        if (id < 0 || id > DROPPED_ITEM_COUNT)
            return null;
        
        return items[id];
    }
}
