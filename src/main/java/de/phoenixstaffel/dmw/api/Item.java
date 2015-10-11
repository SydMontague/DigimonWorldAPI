package de.phoenixstaffel.dmw.api;

import java.util.Arrays;
import java.util.List;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.item.ItemDescription;
import de.phoenixstaffel.dmw.api.item.ItemValues;
import de.phoenixstaffel.dmw.core.CompoundStructure;
import de.phoenixstaffel.dmw.core.Structure;

public class Item extends CompoundStructure {
    private int id;
    private ItemValues values;
    private ItemDescription desc;
    
    public Item(DigimonWorldAPI main, long valueBaseAddress, long descriptionBaseAddress, int id) {
        this.id = id;
        values = new ItemValues(main, valueBaseAddress, id);
        desc = new ItemDescription(main, descriptionBaseAddress, id);
    }
    
    public ItemValues getValues() {
        return values;
    }
    
    public ItemDescription getDescription() {
        return desc;
    }

    public int getId() {
        return id;
    }

    @Override
    public List<Structure> getChildStructures() {
        return Arrays.asList(values, desc);
    }
}
