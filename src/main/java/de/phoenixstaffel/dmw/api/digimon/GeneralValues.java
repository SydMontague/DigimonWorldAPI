package de.phoenixstaffel.dmw.api.digimon;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.Item;
import de.phoenixstaffel.dmw.api.enums.DigimonLevel;
import de.phoenixstaffel.dmw.api.enums.DigimonType;
import de.phoenixstaffel.dmw.api.enums.Speciality;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class GeneralValues extends BaseStructure {
    
    private static final int NAME_LENGTH = 20;
    
    {
        addStructureElement(new StructureElement("Name", StructureElementType.STRING, NAME_LENGTH));
        addStructureElement(new StructureElement("ModelId", StructureElementType.INT));
        addStructureElement(new StructureElement("Radius", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Unknown1", StructureElementType.UNDEFINED, 2));
        addStructureElement(new StructureElement("Type", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Level", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Element1", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Element2", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Element3", StructureElementType.BYTE));
        addStructureElement(new StructureElement("DropItem", StructureElementType.BYTE));
        addStructureElement(new StructureElement("DropChance", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Level", StructureElementType.BYTE));
        addStructureElement(new StructureElement("MoveSet", StructureElementType.UNDEFINED, 16));
    }
    
    public GeneralValues(DigimonWorldAPI main, long baseAddress, int id) {
        super(main, baseAddress, id);
    }
    
    public String getName() {
        return (String) readStructure("Name");
    }
    
    public void setName(String name) {
        writeStructure("Name", name);
    }
    
    public int getModelID() {
        return (int) readStructure("ModelId");
    }
    
    public void setModelId(int id) {
        writeStructure("ModelId", id);
    }
    
    public short getRadius() {
        return (short) readStructure("Radius");
    }
    
    public void setRadius(short radius) {
        writeStructure("Radius", radius);
    }
    
    public DigimonType getDigimonType() {
        return DigimonType.valueOf((byte) readStructure("Type"));
    }
    
    public void setDigimonType(DigimonType type) {
        writeStructure("Type", type.getId());
    }
    
    public DigimonLevel getDigimonLevel() {
        return DigimonLevel.valueOf((byte) readStructure("Level"));
    }
    
    public void setDigimonLevel(DigimonLevel level) {
        writeStructure("Level", level.getId());
    }
    
    public Speciality getFirstSpeciality() {
        return Speciality.valueOf((byte) readStructure("Element1"));
    }
    
    public void setFirstSpeciality(Speciality element) {
        writeStructure("Element1", element.getId());
    }
    
    public Speciality getSecondSpeciality() {
        return Speciality.valueOf((byte) readStructure("Element2"));
    }
    
    public void setSecondSpeciality(Speciality element) {
        writeStructure("Element2", element.getId());
    }
    
    public Speciality getThirdSpeciality() {
        return Speciality.valueOf((byte) readStructure("Element3"));
    }
    
    public void setThirdSpeciality(Speciality element) {
        writeStructure("Element3", element.getId());
    }
    
    public Item getItemDrop() {
        return getMain().getItemManager().getItem((byte) readStructure("DropItem"));
    }
    
    public void setItemDrop(Item item) {
        setItemDrop(item.getId());
    }
    
    public void setItemDrop(int id) {
        writeStructure("DropItem", id);
    }
    
    public byte getItemDropChance() {
        return (byte) readStructure("DropChance");
    }
    
    public void setItemDropChance(byte chance) {
        writeStructure("DropChance", chance);
    }
}
