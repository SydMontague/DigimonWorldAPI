package de.phoenixstaffel.dmw.api.move;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StringPointer;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class MoveName extends BaseStructure {
    
    {
        addStructureElement(new StructureElement("Name", StructureElementType.STRING_POINTER, 100));
    }
    
    public MoveName(DigimonWorldAPI main, long baseAddress, int id) {
        super(main, baseAddress, id);
    }
    
    public StringPointer getName() {
        return (StringPointer) readStructure("Name");
    }
    
    public void setName(int address) {
        writeStructure("Name", address);
    }
}
