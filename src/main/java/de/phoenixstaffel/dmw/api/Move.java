package de.phoenixstaffel.dmw.api;

import java.util.Arrays;
import java.util.List;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.move.MoveLearnChances;
import de.phoenixstaffel.dmw.api.move.MoveName;
import de.phoenixstaffel.dmw.api.move.MoveValues;
import de.phoenixstaffel.dmw.core.CompoundStructure;
import de.phoenixstaffel.dmw.core.Structure;

public class Move extends CompoundStructure {
    private static final long NAME = 0xB7D9F4;
    private static final long GENERAL_VALUES = 0xB7DBE0;
    private static final long LEARNING_CHANCE = 0xB7D944;
    
    private static final int FINISHER_THRESHOLD = 58;
    
    private int id;
    private MoveLearnChances learning;
    private MoveName name;
    private MoveValues values;
    
    public Move(DigimonWorldAPI main, byte id) {
        this.id = id;
        learning = new MoveLearnChances(main, LEARNING_CHANCE, id);
        name = new MoveName(main, NAME, id);
        values = new MoveValues(main, GENERAL_VALUES, id);
    }
    
    public int getId() {
        return id;
    }
    
    public MoveName getName() {
        return name;
    }
    
    public MoveLearnChances getLearningChance() {
        return learning;
    }
    
    public MoveValues getGeneralValues() {
        return values;
    }
    
    public boolean isFinisher() {
        return id >= FINISHER_THRESHOLD;
    }

    @Override
    public List<Structure> getChildStructures() {
        return Arrays.asList(learning, name, values);
    }
}
