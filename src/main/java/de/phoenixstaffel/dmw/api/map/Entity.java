package de.phoenixstaffel.dmw.api.map;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.Digimon;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class Entity extends BaseStructure {
    {
        addStructureElement(new StructureElement("DigimonType", StructureElementType.INT));
        addStructureElement(new StructureElement("Undefined1", StructureElementType.UNDEFINED, 14));
        addStructureElement(new StructureElement("Location X", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Undefined2", StructureElementType.UNDEFINED, 6));
        addStructureElement(new StructureElement("Location Y", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Undefined3", StructureElementType.UNDEFINED, 28));
    }
    
    public Entity(DigimonWorldAPI main, long baseAddress, short id) {
        super(main, baseAddress, id);
    }
    
    public Digimon getDigimon() {
        return getMain().getDigimonManager().getDigimon((short) readStructure("DigimonType"));
    }
    
    public void setDigimon(Digimon digimon) {
        setDigimon(digimon.getId());
    }
    
    public void setDigimon(int id) {
        writeStructure("DigimonType", id);
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
