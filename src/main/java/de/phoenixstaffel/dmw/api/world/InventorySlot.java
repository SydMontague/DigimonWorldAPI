package de.phoenixstaffel.dmw.api.world;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.Item;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.PaddedStructureElement;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class InventorySlot extends BaseStructure {
    
    {
        addStructureElement(new StructureElement("Item", StructureElementType.BYTE));
        addStructureElement(new PaddedStructureElement("Amount", 30, StructureElementType.BYTE));
        addStructureElement(new PaddedStructureElement("Name", 60, StructureElementType.BYTE));
    }
    
    public InventorySlot(DigimonWorldAPI main, long baseAddress, byte id) {
        super(main, baseAddress, id);
    }
    
    public Item getItem() {
        return getMain().getItemManager().getItem((byte) readStructure("Item"));
    }
    
    public byte getAmount() {
        return (byte) readStructure("Amount");
    }
    
    public byte getName() {
        return (byte) readStructure("Name");
    }
    
    public void setItem(byte id) {
        writeStructure("Item", id);
    }
    
    public void setName(byte name) {
        writeStructure("Name", name);
    }
    
    public void setAmount(byte amount) {
        writeStructure("Amount", amount);
    }
}
