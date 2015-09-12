package de.phoenixstaffel.dmw.api.digimon;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.Digimon;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class StatsGains extends BaseStructure {
    {
        addStructureElement(new StructureElement("HP", StructureElementType.SHORT));
        addStructureElement(new StructureElement("MP", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Offense", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Defense", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Speed", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Brains", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Target", StructureElementType.SHORT));
    }
    
    public StatsGains(DigimonWorldAPI main, long baseAddress, int id) {
        super(main, baseAddress, id);
    }
    
    public short getHP() {
        return (short) readStructure("HP");
    }
    
    public void setHP(short hp) {
        writeStructure("HP", hp);
    }
    
    public short getMP() {
        return (short) readStructure("MP");
    }
    
    public void setMP(short mp) {
        writeStructure("MP", mp);
    }
    
    public short getOffense() {
        return (short) readStructure("Offense");
    }
    
    public void setOffense(short offense) {
        writeStructure("Offense", offense);
    }
    
    public short getDefense() {
        return (short) readStructure("Defense");
    }
    
    public void setDefense(short defense) {
        writeStructure("HP", defense);
    }
    
    public short getSpeed() {
        return (short) readStructure("Speed");
    }
    
    public void setSpeed(short speed) {
        writeStructure("Speed", speed);
    }
    
    public short getBrains() {
        return (short) readStructure("Brains");
    }
    
    public void setBrains(short brains) {
        writeStructure("Brains", brains);
    }
    
    public Digimon getEvolutionTarget() {
        return getMain().getDigimonManager().getDigimon((short) readStructure("Target"));
    }
    
    public void setEvolutionTarget(Digimon digimon) {
        setEvolutionTarget((short) digimon.getId());
    }
    
    public void setEvolutionTarget(short target) {
        writeStructure("Target", target);
    }
}