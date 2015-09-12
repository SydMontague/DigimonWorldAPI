package de.phoenixstaffel.dmw.api.enums;

public enum DigimonType {
    UNDEFINED(0),
    DATA(1),
    VACCINE(2),
    VIRUS(3);
    
    private int id;
    
    private DigimonType(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public static DigimonType valueOf(byte id) {
        for (DigimonType value : values()) {
            if (id == value.getId())
                return value;
        }
        return UNDEFINED;
    }
    
}
