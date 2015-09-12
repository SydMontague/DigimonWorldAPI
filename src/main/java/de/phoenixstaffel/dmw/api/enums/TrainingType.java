package de.phoenixstaffel.dmw.api.enums;

public enum TrainingType {
    NEUTRAL(0),
    OFFENSE_SPEED(1),
    MP_BRAINS(2),
    HP_DEFENSE(3),
    FILTH(-1);
    
    private int id;
    
    private TrainingType(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public static TrainingType valueOf(byte id) {
        for (TrainingType value : values()) {
            if (id == value.getId())
                return value;
        }
        return FILTH;
    }
}
