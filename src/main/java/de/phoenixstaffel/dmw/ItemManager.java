package de.phoenixstaffel.dmw;

import java.util.ArrayList;
import java.util.List;

import de.phoenixstaffel.dmw.api.Item;

public class ItemManager {

    private static final long BASE_ADDRESS = 0xB7E37C;
    private static final long DESC_ADDRESS = 0xB7F37C;
    private static final int ITEM_COUNT = 128;
    private List<Item> itemList = new ArrayList<>();
    
    public ItemManager(DigimonWorldAPI randomizer) {
        for (byte i = 0; i < ITEM_COUNT - 1; i++)
            itemList.add(new Item(randomizer, BASE_ADDRESS, DESC_ADDRESS, i));
    }
    
    public Item getItem(byte id) {
        return itemList.size() > id ? itemList.get(id) : null;
    }

    public List<Item> getItems() {
        return itemList;
    }
}
