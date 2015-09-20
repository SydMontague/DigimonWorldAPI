package de.phoenixstaffel.dmw;

import java.util.ArrayList;
import java.util.List;

import de.phoenixstaffel.dmw.api.Move;

public class MovesManager {
    private static final int MOVE_COUNT = 121;
    private List<Move> moveList = new ArrayList<>();
    
    public MovesManager(DigimonWorldAPI randomizer) {
        for (byte i = 0; i < MOVE_COUNT; i++)
            moveList.add(new Move(randomizer, i));
    }
    
    public Move getMove(byte id) {
        return moveList.size() > id && id >= 0 ? moveList.get(id) : null;
    }

    public List<Move> getMoves() {
        return moveList;
    }
}
