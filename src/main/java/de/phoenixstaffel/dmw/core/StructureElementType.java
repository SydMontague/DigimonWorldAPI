package de.phoenixstaffel.dmw.core;

public enum StructureElementType {
    BYTE("byte", Byte.BYTES),
    BYTE_ARRAY("byte[]", 0),
    SHORT("short", Short.BYTES),
    INT("int", Integer.BYTES),
    LONG("long", Long.BYTES),
    STRING("String", 0),
    STRING_POINTER("StringPointer", Integer.BYTES),
    UNDEFINED("Memory", 0);
    
    private final int size;
    private final String name;
    
    private StructureElementType(String name, int size) {
        this.name = name;
        this.size = size;
    }
    
    protected String getJavaTypeName() {
        return name;
    }
    
    public int getSize() {
        return size;
    }
}
