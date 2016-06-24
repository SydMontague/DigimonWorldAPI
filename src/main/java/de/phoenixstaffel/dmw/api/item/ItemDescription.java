package de.phoenixstaffel.dmw.api.item;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StringPointer;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class ItemDescription extends BaseStructure {
    
    {
        addStructureElement(new StructureElement("Description", StructureElementType.STRING_POINTER));
    }
    
    public ItemDescription(DigimonWorldAPI main, long baseAddress, int id) {
        super(main, baseAddress, id);
    }
    
    public String getDescription() {
        return getDescriptionPointer().getContent();
    }
    
    public StringPointer getDescriptionPointer() {
        return (StringPointer) readStructure("Description");
    }
    
    public void setDescriptionPointer(int address) {
        writeStructure("Description", address);
    }
}
