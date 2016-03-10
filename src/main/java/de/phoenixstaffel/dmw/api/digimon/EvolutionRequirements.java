package de.phoenixstaffel.dmw.api.digimon;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.Digimon;
import de.phoenixstaffel.dmw.api.enums.Stats;
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
        return getMain().getDigimonManager().getDigimon((short) readStructure("BonusDigimon"));
    }
    
    public void setBonusDigimon(Digimon digimon) {
        setBonusDigimon(digimon != null ? digimon.getId() : -1);
    }
    
    public void setBonusDigimon(int id) {
        setBonusDigimon((short) id);
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
    
    public void setBonusDigimon(short value) {
        writeStructure("BonusDigimon", value);
    }
    
    public void setHP(short value) {
        writeStructure("HP", value);
    }
        
    public void setMP(short value) {
        writeStructure("MP", value);
    }
        
    public void setOffense(short value) {
        writeStructure("Offense", value);
    }
    
    public void setDefense(short value) {
        writeStructure("Defense", value);
    }
    
    public void setSpeed(short value) {
        writeStructure("Speed", value);
    }
    
    public void setBrains(short value) {
        writeStructure("Brains", value);
    }
    
    public void setCare(short value) {
        writeStructure("Care", value);
    }
    
    public void setWeight(short value) {
        writeStructure("Weight", value);
    }
    
    public void setDiscipline(short value) {
        writeStructure("Discipline", value);
    }

    public void setHappiness(short value) {
        writeStructure("Happiness", value);
    }
    
    public void setBattles(short value) {
        writeStructure("Battles", value);
    }
    
    public void setTechs(short value) {
        writeStructure("Techs", value);
    }
    
    public void setFlags(short value) {
        writeStructure("Flags", value);
    }

    public void setMaxCareMistakes(boolean value) {
        setFlags((short) (value ? getFlags() | 0x10 : getFlags() & 0xEF));
    }
    
    public void setMaxBattles(boolean value) {
        setFlags((short) (value ? getFlags() | 0x01 : getFlags() & 0xFE));
    }
    
    public void setStats(Stats stats, short value)
    {
        switch(stats)
        {
            case HP: setHP(value); break;
            case MP: setMP(value); break;
            case OFFENSE: setOffense(value); break;
            case DEFENSE: setDefense(value); break;
            case SPEED: setSpeed(value); break;
            case BRAINS: setBrains(value); break;
        }
    }
    
    public short getStats(Stats stats)
    {
        switch(stats)
        {
            case HP: return getHP();
            case MP: return getMP();
            case OFFENSE: return getOffense();
            case DEFENSE: return getDefense();
            case SPEED: return getSpeed();
            case BRAINS: return getBrains();
        }
        return 0;
    }
}
