package de.phoenixstaffel.dmw.api.map;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.Item;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class DroppedItem extends BaseStructure {
    
    {
        addStructureElement(new StructureElement("Render X", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Undefined1", StructureElementType.UNDEFINED, 2));
        addStructureElement(new StructureElement("Render Y", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Undefined2", StructureElementType.UNDEFINED, 2));
        addStructureElement(new StructureElement("Type", StructureElementType.INT));
        addStructureElement(new StructureElement("Location X", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Location Y", StructureElementType.SHORT));
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
    
    public short getRenderLocationX() {
        return (short) readStructure("Render X");
    }
    
    public void setRenderLocationX(short value) {
        writeStructure("Render X", value);
    }
    
    public short getRenderLocationY() {
        return (short) readStructure("Render Y");
    }
    
    public void setRenderLocationY(short value) {
        writeStructure("Render Y", value);
    }
}
