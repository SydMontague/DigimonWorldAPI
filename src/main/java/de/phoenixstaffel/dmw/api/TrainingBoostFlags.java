package de.phoenixstaffel.dmw.api;

public class TrainingBoostFlags {
    private static final byte HP_FLAG = 0b00000001;
    private static final byte MP_FLAG = 0b00000010;
    private static final byte OFFENSE_FLAG = 0b00000100;
    private static final byte DEFENSE_FLAG = 0b00001000;
    private static final byte SPEED_FLAG = 0b00010000;
    private static final byte BRAINS_FLAG = 0b00100000;
    
    private final byte value;
    
    public TrainingBoostFlags(byte value) {
        this.value = value;
    }
    
    public TrainingBoostFlags(boolean hp, boolean mp, boolean offense, boolean defense, boolean speed, boolean brains) {
        byte val = 0;
        val += hp ? HP_FLAG : 0;
        val += mp ? MP_FLAG : 0;
        val += offense ? OFFENSE_FLAG : 0;
        val += defense ? DEFENSE_FLAG : 0;
        val += speed ? SPEED_FLAG : 0;
        val += brains ? BRAINS_FLAG : 0;
        this.value = val;
    }
    
    public byte getValue() {
        return value;
    }
    
    public boolean isHPBoosted() {
        return (value & HP_FLAG) != 0;
    }
    
    public boolean isMPBoosted() {
        return (value & MP_FLAG) != 0;
    }
    
    public boolean isOffenseBoosted() {
        return (value & OFFENSE_FLAG) != 0;
    }
    
    public boolean isDefenseBoosted() {
        return (value & DEFENSE_FLAG) != 0;
    }
    
    public boolean isSpeedBoosted() {
        return (value & SPEED_FLAG) != 0;
    }
    
    public boolean isBrainsBoosted() {
        return (value & BRAINS_FLAG) != 0;
    }
}
