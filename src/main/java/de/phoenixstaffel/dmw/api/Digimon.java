package de.phoenixstaffel.dmw.api;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.digimon.DigimonMoveset;
import de.phoenixstaffel.dmw.api.digimon.EvolutionPaths;
import de.phoenixstaffel.dmw.api.digimon.EvolutionRequirements;
import de.phoenixstaffel.dmw.api.digimon.GeneralValues;
import de.phoenixstaffel.dmw.api.digimon.RaisingValues;
import de.phoenixstaffel.dmw.api.digimon.StatsGains;
import de.phoenixstaffel.dmw.core.CompoundStructure;

public class Digimon extends CompoundStructure {
    // TODO put these into the manager
    private static final long GENERAL_START = 0xB84854;
    private static final long MOVES_START = 0xB84877;
    private static final long RAISING_START = 0xB79F5C;
    private static final long STATSGAIN_START = 0xB82C70;
    private static final long EVOLVE_PATH_START = 0xB83001;
    private static final long REQUIREMENTS_START = 0xB8258C;
    
    private final int id;
    private final GeneralValues general;
    private final DigimonMoveset moveset;
    private final RaisingValues raising;
    private final StatsGains statsgain;
    private final EvolutionPaths evolutionPaths;
    private final EvolutionRequirements evolutionRequirements;
    
    public Digimon(DigimonWorldAPI randomizer, short id) {
        this.id = id;
        general = new GeneralValues(randomizer, GENERAL_START, id);
        moveset = new DigimonMoveset(randomizer, MOVES_START, id);
        raising = new RaisingValues(randomizer, RAISING_START, id);
        statsgain = new StatsGains(randomizer, STATSGAIN_START, id);
        evolutionPaths = new EvolutionPaths(randomizer, EVOLVE_PATH_START, id);
        evolutionRequirements = new EvolutionRequirements(randomizer, REQUIREMENTS_START, id);
    }
    
    public int getId() {
        return id;
    }
    
    public GeneralValues getGeneralValues() {
        return general;
    }
    
    public DigimonMoveset getMoveset() {
        return moveset;
    }
    
    public RaisingValues getRaisingValues() {
        return raising;
    }
    
    public StatsGains getStatsGains() {
        return statsgain;
    }
    
    public EvolutionPaths getEvolutionPaths() {
        return evolutionPaths;
    }
    
    public EvolutionRequirements getEvolutionRequirements() {
        return evolutionRequirements;
    }
}
