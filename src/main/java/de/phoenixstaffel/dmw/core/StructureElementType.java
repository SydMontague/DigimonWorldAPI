package de.phoenixstaffel.dmw.core;

public enum StructureElementType {
    BYTE(Byte.BYTES),
    BYTE_ARRAY(0),
    SHORT(Short.BYTES),
    INT(Integer.BYTES),
    LONG(Long.BYTES),
    STRING(0),
    STRING_POINTER(Integer.BYTES),
    UNDEFINED(0);
    
    private int size;
    
    private StructureElementType(int size) {
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }
}
