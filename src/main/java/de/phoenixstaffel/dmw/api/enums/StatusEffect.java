package de.phoenixstaffel.dmw.api.enums;

public enum StatusEffect {
    UNDEFINED((byte) 5),
    NONE((byte) 0),
    POISON((byte) 1),
    CONFUSE((byte) 2),
    STUN((byte) 3),
    FLAT((byte) 4);
    
    private byte id;
    
    private StatusEffect(byte id) {
        this.id = id;
    }
    
    public byte getId() {
        return id;
    }
    
    public static StatusEffect valueOf(byte id) {
        for (StatusEffect value : values())
            if (id == value.getId())
                return value;
        return UNDEFINED;
    }
    
}
