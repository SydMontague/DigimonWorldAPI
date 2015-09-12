package de.phoenixstaffel.dmw.api.world;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.map.DigimonEncounter;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class PartnerDigimon extends DigimonEncounter {
    
    {
        addStructureElement(new StructureElement("Name", StructureElementType.STRING, 12));
        addStructureElement(new StructureElement("Unknown1", StructureElementType.UNDEFINED, 2));
        addStructureElement(new StructureElement("Unknown2", StructureElementType.UNDEFINED, 2));
        addStructureElement(new StructureElement("Unknown3", StructureElementType.UNDEFINED, 4));
        addStructureElement(new StructureElement("Lives", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Unknown4", StructureElementType.UNDEFINED, 2));
    }
    
    public PartnerDigimon(DigimonWorldAPI main, long baseAddress, short id) {
        super(main, baseAddress, id);
    }
    
    public String getName() { // TODO read and convert 2byte string format
        return (String) readStructure("Name");
    }
    
    public void setName(String name) {
        writeStructure("Name", name);
    }
    
    public short getLives() {
        return (short) readStructure("Lives");
    }
    
    public void setLives(short lives) {
        writeStructure("Lives", lives);
    }
}
