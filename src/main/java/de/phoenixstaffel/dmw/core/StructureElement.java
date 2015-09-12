package de.phoenixstaffel.dmw.core;

public class StructureElement {
    
    private final String name;
    private final StructureElementType type;
    private final int stringLenght;
    
    public StructureElement(String name, StructureElementType type, int stringLenght) {
        this.name = name;
        this.type = type;
        this.stringLenght = stringLenght;
    }
    
    public StructureElement(String name, StructureElementType type) {
        this(name, type, 100);
    }
    
    public String getName() {
        return name;
    }
    
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
}
