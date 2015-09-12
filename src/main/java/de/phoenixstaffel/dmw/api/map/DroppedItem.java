package de.phoenixstaffel.dmw.api.map;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.Item;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class DroppedItem extends BaseStructure {
    
    {
        addStructureElement(new StructureElement("Type", StructureElementType.INT));
        addStructureElement(new StructureElement("Location X", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Location Y", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Undefined1", StructureElementType.UNDEFINED, 4));
        addStructureElement(new StructureElement("Undefined2", StructureElementType.UNDEFINED, 4));
    }
    
    public DroppedItem(DigimonWorldAPI main, long baseAddress, short id) {
        super(main, baseAddress, id);
    }
    
    public Item getItem() {
        return getMain().getItemManager().getItem((byte) readStructure("Type"));
    }
    
    public void setItem(Item item) {
        setItem(item.getId());
    }
    
    public void setItem(int item) {
        writeStructure("Type", item);
    }
    
    public short getLocationX() {
        return (short) readStructure("Location X");
    }
    
    public void setLocationX(short locX) {
        writeStructure("Location X", locX);
    }
    
    public short getLocationY() {
        return (short) readStructure("Location Y");
    }
    
    public void setLocationY(short locY) {
        writeStructure("Location Y", locY);
    }
}
