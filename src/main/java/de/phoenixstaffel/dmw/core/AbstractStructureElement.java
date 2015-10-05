package de.phoenixstaffel.dmw.core;

public abstract class AbstractStructureElement {
    
    protected final String name;
    protected final StructureElementType type;
    protected final int stringLenght;

    public AbstractStructureElement(String name, StructureElementType type, int stringLenght) {
        this.name = name;
        this.type = type;
        this.stringLenght = stringLenght;
    }
    
    public AbstractStructureElement(String name, StructureElementType type) {
        this(name, type, 100);
    }

    public String getName() {
        return name;
    }
    
    public abstract boolean isFixedOffset();

    public StructureElementType getElementType() {
        return type;
    }

    public int getSize() {
        switch (type) {
            case STRING:
            case UNDEFINED:
            case BYTE_ARRAY:
                return stringLenght;
            default:
                return type.getSize();
        }
    }

    public abstract int getBaseOffset();
    
}
