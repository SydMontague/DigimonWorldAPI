package de.phoenixstaffel.dmw.api.item;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.core.AbstractStructureElement;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class ItemValues extends BaseStructure {
    // TODO map color values, put into enum?
    
    {
        addStructureElement(new StructureElement("Name", StructureElementType.STRING, 20));
        addStructureElement(new StructureElement("Value", StructureElementType.INT));
        addStructureElement(new StructureElement("Merit", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Sorting", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Color", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Dropable", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Unknown", StructureElementType.UNDEFINED, 2));
    }
    
    public ItemValues(DigimonWorldAPI main, long baseAddress, int id) {
        super(main, baseAddress, id);
    }
    
    public String getName() {
        return (String) readStructure("Name");
    }
    
    public void setName(String name) {
        AbstractStructureElement element = getStructureElementByName("Name");
        writeStructure("Name", name.length() > element.getSize() ? name.substring(0, element.getSize() - 1) : name);
    }
    
    public int getValue() {
        return (int) readStructure("Value");
    }
    
    public void setValue(int value) {
        writeStructure("Value", value);
    }
    
    public short getMeritValue() {
        return (short) readStructure("Merit");
    }
    
    public void setMeritValue(short meritValue) {
        writeStructure("Merit", meritValue);
    }
    
    public short getSortingValue() {
        return (short) readStructure("Sorting");
    }
    
    public void setSortingValue(short sortingValue) {
        writeStructure("Sorting", sortingValue);
    }
    
    public byte getColor() {
        return (byte) readStructure("Color");
    }
    
    public void setColor(byte color) {
        writeStructure("Color", color);
    }
    
    public boolean isDropable() {
        return (byte) readStructure("Dropable") == 1;
    }
    
    public void setDropable(boolean dropable) {
        writeStructure("Dropable", dropable ? (byte) 1 : (byte) 0);
    }
}
