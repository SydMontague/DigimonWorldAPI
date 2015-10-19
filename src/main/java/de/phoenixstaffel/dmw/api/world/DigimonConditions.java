package de.phoenixstaffel.dmw.api.world;

public class DigimonConditions {
    private static final byte SLEEPY_MASK = 0b00000001;
    private static final byte TIRED_MASK = 0b00000010;
    private static final byte HUNGRY_MASK = 0b00000100;
    private static final byte POOP_MASK = 0b00001000;
    private static final byte UNHAPPY_MASK = 0b00010000;
    private static final byte INJURED_MASK = 0b00100000;
    private static final byte SICK_MASK = 0b01000000;
    
    private final byte value;
    
    public DigimonConditions(byte value) {
        this.value = value;
    }
    
    public DigimonConditions(boolean sleepy, boolean tired, boolean hungry, boolean poop, boolean unhappy, boolean injured, boolean sick) {
        byte val = 0;
        val += sleepy ? SLEEPY_MASK : 0;
        val += tired ? TIRED_MASK : 0;
        val += hungry ? HUNGRY_MASK : 0;
        val += poop ? POOP_MASK : 0;
        val += unhappy ? UNHAPPY_MASK : 0;
        val += injured ? INJURED_MASK : 0;
        val += sick ? SICK_MASK : 0;
        
        this.value = val;
    }
    
    public boolean isSleepy() {
        return (value & SLEEPY_MASK) != 0;
    }
    
    public boolean isTired() {
        return (value & TIRED_MASK) != 0;
    }
    
    public boolean isHungry() {
        return (value & HUNGRY_MASK) != 0;
    }
    
    public boolean isPoopy() {
        return (value & POOP_MASK) != 0;
    }
    
    public boolean isUnhappy() {
        return (value & UNHAPPY_MASK) != 0;
    }
    
    public boolean isInjured() {
        return (value & INJURED_MASK) != 0;
    }
    
    public boolean isSick() {
        return (value & SICK_MASK) != 0;
    }
    
    public byte getValue() {
        return value;
    }
}
