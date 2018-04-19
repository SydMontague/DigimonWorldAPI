package de.phoenixstaffel.dmw.api.world;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class Triggers extends BaseStructure {
    private static final int BASE_ADDRESS = 0xC1596D;

    {
        addStructureElement(new StructureElement("triggers", StructureElementType.BYTE_ARRAY, 100));
    }
    
    public Triggers(DigimonWorldAPI main) {
        super(main, BASE_ADDRESS);
    }
    
    public boolean getTrigger(int id) {
        int byteId = id / 8;
        int bitId = id % 8;
        
        if(byteId >= 100)
            throw new IllegalArgumentException("This trigger is out of range!");
        
        byte value = ((byte[]) readStructure("triggers"))[byteId];
        
        return (value >>> bitId & 0x01) != 0;
    }
    
    public void setTrigger(int id) {
        int byteId = id / 8;
        int bitId = id % 8;
        
        byte[] triggers = ((byte[])readStructure("triggers"));
        
        triggers[byteId] |= (1 << bitId);
        
        writeStructure("triggers", triggers);
    }
}
