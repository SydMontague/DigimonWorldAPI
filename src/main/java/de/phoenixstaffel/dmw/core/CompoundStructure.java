package de.phoenixstaffel.dmw.core;

import java.util.List;

public abstract class CompoundStructure implements Structure {
    @Override
    public String dumpValues() {
        StringBuilder builder = new StringBuilder(getStructureName());
        builder.append(":\n  ");
        for (Structure structure : getChildStructures()) {
            String str = structure.dumpValues();
            str = str.replace("\n", "\n  ");
            builder.append(str);
        }
        
        return builder.toString();
    }
    
    public abstract List<Structure> getChildStructures();
}
