package de.phoenixstaffel.dmw.core;

public class StructureElement extends AbstractStructureElement {
    
    public StructureElement(String name, StructureElementType type, int stringLenght) {
        super(name, type, stringLenght);
    }
    
    public StructureElement(String name, StructureElementType type) {
        this(name, type, 100);
    }
    
    @Override
    public boolean isFixedOffset() {
        return false;
    }

    @Override
    public int getBaseOffset() {
        return 0;
    }
}
