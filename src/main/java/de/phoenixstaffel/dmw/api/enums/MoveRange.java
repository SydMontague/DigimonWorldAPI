package de.phoenixstaffel.dmw.api.enums;

public enum MoveRange {
    UNDEFINED(0),
    SHORT(1),
    LARGE(2),
    WIDE(3),
    SELF(4);
    
    private int id;
    
    private MoveRange(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public static MoveRange valueOf(byte id) {
        for (MoveRange value : values())
            if (id == value.getId())
                return value;
        return UNDEFINED;
    }
    
}
