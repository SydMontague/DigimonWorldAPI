package de.phoenixstaffel.dmw.api.move;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class MoveLearnChances extends BaseStructure {
    {
        addStructureElement(new StructureElement("FirstElement", StructureElementType.BYTE));
        addStructureElement(new StructureElement("SecondElement", StructureElementType.BYTE));
        addStructureElement(new StructureElement("ThirdElement", StructureElementType.BYTE));
    }
    
    public MoveLearnChances(DigimonWorldAPI main, long baseAddress, int id) {
        super(main, baseAddress, id);
    }
    
    public byte getFirstChance() {
        return (byte) readStructure("FirstElement");
    }
    
    public void setFirstChance(byte chance) {
        writeStructure("FirstElement", chance);
    }
    
    public byte getSecondChance() {
        return (byte) readStructure("SecondElement");
    }
    
    public void setSecondChance(byte chance) {
        writeStructure("SecondElement", chance);
    }
    
    public byte getThirdChance() {
        return (byte) readStructure("ThirdElement");
    }
    
    public void setThirdChance(byte chance) {
        writeStructure("ThirdElement", chance);
    }
}
