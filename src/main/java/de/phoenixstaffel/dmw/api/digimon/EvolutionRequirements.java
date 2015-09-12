package de.phoenixstaffel.dmw.api.digimon;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.Digimon;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class EvolutionRequirements extends BaseStructure {
    {
        addStructureElement(new StructureElement("BonusDigimon", StructureElementType.SHORT));
        addStructureElement(new StructureElement("HP", StructureElementType.SHORT));
        addStructureElement(new StructureElement("MP", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Offense", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Defense", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Speed", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Brains", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Care", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Weight", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Discipline", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Happiness", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Battles", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Techs", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Flags", StructureElementType.SHORT));
    }
    
    public EvolutionRequirements(DigimonWorldAPI main, long baseAddress, int id) {
        super(main, baseAddress, id);
    }
    
    public Digimon getBonusDigimon() {
        return getMain().getDigimonManager().getDigimon((byte) readStructure("BonusDigimon"));
    }
    
    public void setBonusDigimon(Digimon digimon) {
        setBonusDigimon(digimon.getId());
    }
    
    public void setBonusDigimon(int id) {
        writeStructure("BonusDigimon", id);
    }
    
    public short getHP() {
        return (short) readStructure("HP");
    }
    
    public short getMP() {
        return (short) readStructure("MP");
    }
    
    public short getOffense() {
        return (short) readStructure("Offense");
    }
    
    public short getDefense() {
        return (short) readStructure("Defense");
    }
    
    public short getSpeed() {
        return (short) readStructure("Speed");
    }
    
    public short getBrains() {
        return (short) readStructure("Brains");
    }
    
    public short getCareMistakes() {
        return (short) readStructure("Care");
    }
    
    public short getWeight() {
        return (short) readStructure("Weight");
    }
    
    public short getDiscipline() {
        return (short) readStructure("Discipline");
    }
    
    public short getHappiness() {
        return (short) readStructure("Happiness");
    }
    
    public short getBattles() {
        return (short) readStructure("Battles");
    }
    
    public short getTechs() {
        return (short) readStructure("Techs");
    }
    
    public short getFlags() {
        return (short) readStructure("Flags");
    }
    
    public boolean isMaxCareMistakes() {
        return (getFlags() & 16) == 16;
    }
    
    public boolean isMaxBattles() {
        return (getFlags() & 1) == 1;
    }
}
