package de.phoenixstaffel.dmw.core;

public interface Structure {
    public String dumpValues();
    
    public default String getStructureName() {
        return getClass().getSimpleName();
    }
}
