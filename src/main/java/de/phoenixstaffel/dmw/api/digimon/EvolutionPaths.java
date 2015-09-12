package de.phoenixstaffel.dmw.api.digimon;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.Digimon;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class EvolutionPaths extends BaseStructure {
    private static final int EVOLVE_FROM_SIZE = 5;
    private static final int EVOLVE_TO_SIZE = 6;
    
    {
        addStructureElement(new StructureElement("From", StructureElementType.BYTE_ARRAY, EVOLVE_FROM_SIZE));
        addStructureElement(new StructureElement("To", StructureElementType.BYTE_ARRAY, EVOLVE_TO_SIZE));
    }
    
    public EvolutionPaths(DigimonWorldAPI main, long baseAddress, int id) {
        super(main, baseAddress, id);
    }
    
    public Digimon[] getEvolveFrom() {
        Digimon[] list = new Digimon[EVOLVE_FROM_SIZE];
        byte[] array = (byte[]) readStructure("From");
        
        for (int i = 0; i < EVOLVE_FROM_SIZE; i++)
            list[i] = getMain().getDigimonManager().getDigimon(array[i]);
        
        return list;
    }
    
    public void setEvolveFrom(Digimon[] digimons) {
        byte[] array = new byte[digimons.length];
        
        for (int i = 0; i < digimons.length; i++)
            array[i] = (byte) digimons[i].getId();
        
        setEvolveFrom(array);
    }
    
    public void setEvolveFrom(byte[] array) {
        writeStructure("From", array);
    }
    
    public Digimon[] getEvolveTo() {
        Digimon[] list = new Digimon[EVOLVE_TO_SIZE];
        byte[] array = (byte[]) readStructure("To");
        
        for (int i = 0; i < EVOLVE_TO_SIZE; i++)
            list[i] = getMain().getDigimonManager().getDigimon(array[i]);
        
        return list;
    }
    
    public void setEvolveTo(Digimon[] digimons) {
        byte[] array = new byte[digimons.length];
        
        for (int i = 0; i < digimons.length; i++)
            array[i] = (byte) digimons[i].getId();
        
        setEvolveTo(array);
    }
    
    public void setEvolveTo(byte[] array) {
        writeStructure("To", array);
    }
}
