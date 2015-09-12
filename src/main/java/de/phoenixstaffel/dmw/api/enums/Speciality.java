package de.phoenixstaffel.dmw.api.enums;

public enum Speciality {
    UNDEFINED(7),
    FIRE(0),
    BATTLE(1),
    AIR(2),
    EARTH(3),
    ICE(4),
    MECH(5),
    FILTH(6);
    
    private int id;
    
    private Speciality(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public static Speciality valueOf(byte id) {
        for (Speciality value : values())
            if (id == value.getId())
                return value;
        return UNDEFINED;
    }
    
}
