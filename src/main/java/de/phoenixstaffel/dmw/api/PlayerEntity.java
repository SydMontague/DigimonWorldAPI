package de.phoenixstaffel.dmw.api;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.map.Entity;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class PlayerEntity extends Entity {
    
    {
        addStructureElement(new StructureElement("TamerLevel", StructureElementType.BYTE));
        addStructureElement(new StructureElement("DigimonRaised", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Unknown", StructureElementType.UNDEFINED, 2));
    }
    
    public PlayerEntity(DigimonWorldAPI main, long baseAddress) {
        super(main, baseAddress, (short) 0);
    }
    
    public byte getTamerLevel() {
        return (byte) readStructure("TamerLevel");
    }
    
    public void setTamerLevel(byte level) {
        writeStructure("TamerLevel", level);
    }
    
    public byte getDigimonsRaised() {
        return (byte) readStructure("DigimonRaised");
    }
    
    public void setDigimonRaised(byte raised) {
        writeStructure("DigimonRaised", raised);
    }
}
