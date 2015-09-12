package de.phoenixstaffel.dmw.api.enums;

public enum DigimonLevel {
    UNDEFINED(0),
    FRESH(1),
    IN_TRAINING(2),
    ROOKIE(3),
    CHAMPION(4),
    ULTIMATE(5);
    
    private int id;
    
    private DigimonLevel(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public static DigimonLevel valueOf(byte id) {
        for (DigimonLevel value : values())
            if (id == value.getId())
                return value;
        return UNDEFINED;
    }
    
}
