package de.phoenixstaffel.dmw;

import java.util.ArrayList;
import java.util.List;

import de.phoenixstaffel.dmw.api.Item;

public class ItemManager {
    
    private static final long BASE_ADDRESS = 0xB7E37C;
    private static final long DESC_ADDRESS = 0xB7F37C;
    //TODO add item effects
    private static final int ITEM_COUNT = 128;
    private List<Item> itemList = new ArrayList<>();
    
    public ItemManager(DigimonWorldAPI randomizer) {
        for (short i = 0; i < ITEM_COUNT; i++)
            itemList.add(new Item(randomizer, BASE_ADDRESS, DESC_ADDRESS, i));
    }
    
    public Item getItem(byte id) {
        return itemList.size() >= id && id > 0 ? itemList.get(id) : null;
    }
    
    public Item getItem(String name) {
        for (Item item : itemList)
            if (item.getValues().getName().equalsIgnoreCase(name))
                return item;
        
        return null;
    }
    
    public List<Item> getItems() {
        return itemList;
    }
}
