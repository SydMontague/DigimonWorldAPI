package de.phoenixstaffel.dmw.core;

public class PaddedStructureElement extends AbstractStructureElement {
    
    private final int padding;
    
    public PaddedStructureElement(String name, int padding, StructureElementType type, int stringLenght) {
        super(name, type, stringLenght);
        this.padding = padding;
    }
    
    public PaddedStructureElement(String name, int padding, StructureElementType type) {
        super(name, type);
        this.padding = padding;
    }
    
    @Override
    public boolean isFixedOffset() {
        return true;
    }
    
    @Override
    public int getBaseOffset() {
        return padding;
    }
}
