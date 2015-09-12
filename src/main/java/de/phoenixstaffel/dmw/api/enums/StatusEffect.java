package de.phoenixstaffel.dmw.api.enums;

public enum StatusEffect {
    UNDEFINED(5),
    NONE(0),
    POISON(1),
    CONFUSE(2),
    STUN(3),
    FLAT(4);

    private int id;
    
    private StatusEffect(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public static StatusEffect valueOf(byte id) {
        for (StatusEffect value : values())
            if (id == value.getId())
                return value;
        return UNDEFINED;
    }
    
}
