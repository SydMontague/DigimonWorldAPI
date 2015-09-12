package de.phoenixstaffel.dmw.api.digimon;

import java.util.Arrays;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.Move;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class DigimonMoveset extends BaseStructure {
    private static final byte MOVES_LENGHT = 16;
    
    {
        addStructureElement(new StructureElement("Moves", StructureElementType.BYTE_ARRAY, MOVES_LENGHT));
    }
    
    public DigimonMoveset(DigimonWorldAPI main, long baseAddress, int id) {
        super(main, baseAddress, id);
    }
    
    public Move[] getMoves() {
        Move[] moves = new Move[MOVES_LENGHT];
        
        for (int i = 0; i < MOVES_LENGHT; i++)
            moves[i] = getMove((byte) i);
        
        return moves;
    }
    
    public void setMoves(Move[] moves) {
        byte[] array = new byte[MOVES_LENGHT];
        
        for (int i = 0; i < MOVES_LENGHT; i++)
            if (moves.length > i)
                array[i] = (byte) moves[i].getId();
            else
                array[i] = -1;
        
        setMoves(array);
    }
    
    public void setMoves(byte[] array) {
        if (array.length > MOVES_LENGHT)
            array = Arrays.copyOf(array, MOVES_LENGHT);
        
        writeStructure("Moves", array);
    }
    
    public boolean hasMove(byte move) {
        return getMove(move) != null;
    }
    
    public Move getMove(byte move) {
        if (move < 0 || move > MOVES_LENGHT)
            return null;
        
        return getMain().getMovesManager().getMove(((byte[]) readStructure("Moves"))[move]);
    }
    
    public void setMove(byte id, Move move) {
        byte[] array = (byte[]) readStructure("Moves");
        array[id] = (byte) move.getId();
        writeStructure("Moves", array);
    }
    
    public boolean hasFinisher() {
        return getFinisher() != null;
    }
    
    public Move getFinisher() {
        for (byte i = MOVES_LENGHT; i > 0; i--) {
            Move move = getMove(i);
            
            if (move.isFinisher())
                return move;
        }
        
        return null;
    }
}
