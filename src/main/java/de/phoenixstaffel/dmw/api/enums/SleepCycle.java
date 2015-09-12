package de.phoenixstaffel.dmw.api.enums;

public enum SleepCycle {
    SUNUP(0),
    DAY(1),
    GROGGY(2),
    SLEEPY(3),
    SUNSET(4),
    NIGHT(5),
    BABY_1(6),
    BABY_2(7),
    UNDEFINED(-1);
    
    private int id;
    
    private SleepCycle(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public static SleepCycle valueOf(byte id) {
        for (SleepCycle value : values())
            if (id == value.getId())
                return value;
        return UNDEFINED;
    }
}
