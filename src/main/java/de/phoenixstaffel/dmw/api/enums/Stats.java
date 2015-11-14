package de.phoenixstaffel.dmw.api.enums;

public enum Stats {
    HP(10),
    MP(10),
    OFFENSE(1),
    DEFENSE(1),
    SPEED(1),
    BRAINS(1);
    
    private int factor;
    
    private Stats(int factor) {
        this.factor = factor;
    }
    
    public int getFactor() {
        return factor;
    }
}
