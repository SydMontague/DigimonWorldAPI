package de.phoenixstaffel.dmw.api.enums;

import de.phoenixstaffel.dmw.MemoryAccess;
import de.phoenixstaffel.dmw.api.Digimon;
import de.phoenixstaffel.dmw.api.Move;

public class EquippedMoveset {
    
    private final long move1Address;
    private final long move2Address;
    private final long move3Address;
    private final long finisherAddress;
    
    private final Digimon digimon;
    private final MemoryAccess memory;
    
    public EquippedMoveset(Digimon digimon, long move1, long move2, long move3, long finisher) {
        this.move1Address = move1;
        this.move2Address = move2;
        this.move3Address = move3;
        this.finisherAddress = finisher;
        this.digimon = digimon;
        this.memory = digimon.getEvolutionPaths().getMain().getMemoryAccess();
    }
    
    public Move getFirstMove() {
        return digimon.getMoveset().getMove((byte) (memory.readByte(move1Address) - 46));
    }
    
    public Move getSecondMove() {
        return digimon.getMoveset().getMove((byte) (memory.readByte(move2Address) - 46));
    }
    
    public Move getThirdMove() {
        return digimon.getMoveset().getMove((byte) (memory.readByte(move3Address) - 46));
    }
    
    public Move getFinisher() {
        return digimon.getMoveset().getMove((byte) (memory.readByte(finisherAddress) - 46));
    }
}
