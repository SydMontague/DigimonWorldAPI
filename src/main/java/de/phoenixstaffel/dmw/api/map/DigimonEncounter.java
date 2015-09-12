package de.phoenixstaffel.dmw.api.map;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.Digimon;
import de.phoenixstaffel.dmw.api.Move;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class DigimonEncounter extends BaseStructure {
    
    
    {
        addStructureElement(new StructureElement("DigimonType", StructureElementType.INT));
        addStructureElement(new StructureElement("Undefined1", StructureElementType.UNDEFINED, 14));
        addStructureElement(new StructureElement("Location X", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Undefined2", StructureElementType.UNDEFINED, 6));
        addStructureElement(new StructureElement("Location Y", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Undefined3", StructureElementType.UNDEFINED, 28));
        addStructureElement(new StructureElement("Offense", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Defense", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Speed", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Brains", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Undefined4", StructureElementType.UNDEFINED, 4));
        addStructureElement(new StructureElement("Move 1", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Move 2", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Move 3", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Move 4", StructureElementType.BYTE));
        addStructureElement(new StructureElement("MaxHP", StructureElementType.SHORT));
        addStructureElement(new StructureElement("MaxMP", StructureElementType.SHORT));
        addStructureElement(new StructureElement("CurrentHP", StructureElementType.SHORT));
        addStructureElement(new StructureElement("CurrentMP", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Undefined5", StructureElementType.UNDEFINED, 16));
        addStructureElement(new StructureElement("Bits", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Undefined6", StructureElementType.UNDEFINED, 6));
    }
    
    public DigimonEncounter(DigimonWorldAPI main, long baseAddress, short id) {
        super(main, baseAddress, id);
    }
    
    public Digimon getDigimon() {
        return getMain().getDigimonManager().getDigimon((short) readStructure("DigimonType"));
    }
    
    public void setDigimon(Digimon digimon) {
        setDigimon(digimon.getId());
    }
    
    public void setDigimon(int id) {
        writeStructure("DigimonType", id);
    }
    
    public short getLocationX() {
        return (short) readStructure("Location X");
    }
    
    public void setLocationX(short locX) {
        writeStructure("Location X", locX);
    }
    
    public short getLocationY() {
        return (short) readStructure("Location Y");
    }
    
    public void setLocationY(short locY) {
        writeStructure("Location Y", locY);
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
        writeStructure("Defense", defense);
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
    
    public short getMaxHP() {
        return (short) readStructure("MaxHP");
    }
    
    public void setMaxHP(short hp) {
        writeStructure("MaxHP", hp);
    }
    
    public short getMaxMP() {
        return (short) readStructure("MaxMP");
    }
    
    public void setMaxMP(short mp) {
        writeStructure("MaxMP", mp);
    }
    
    public short getCurrentHP() {
        return (short) readStructure("CurrentHP");
    }
    
    public void setCurrentHP(short hp) {
        writeStructure("CurrentHP", hp);
    }
    
    public short getCurrentMP() {
        return (short) readStructure("CurrenMP");
    }
    
    public void setCurrentMP(short mp) {
        writeStructure("CurrentMP", mp);
    }
    
    public Move getFirstMove() {
        return getMain().getMovesManager().getMove((byte) readStructure("Move1"));
    }
    
    public void setFirstMove(Move move) {
        setFirstMove((byte) move.getId());
    }
    
    public void setFirstMove(byte move) {
        writeStructure("Move1", move);
    }
    
    public Move getSecondMove() {
        return getMain().getMovesManager().getMove((byte) readStructure("Move2"));
    }
    
    public void setSecondMove(Move move) {
        setFirstMove((byte) move.getId());
    }
    
    public void setSecondMove(byte move) {
        writeStructure("Move2", move);
    }
    
    public Move getThirdMove() {
        return getMain().getMovesManager().getMove((byte) readStructure("Move3"));
    }
    
    public void setThirdMove(Move move) {
        setFirstMove((byte) move.getId());
    }
    
    public void setThirdMove(byte move) {
        writeStructure("Move3", move);
    }
    
    public Move getFourthMove() {
        return getMain().getMovesManager().getMove((byte) readStructure("Move4"));
    }
    
    public void setFourthMove(Move move) {
        setFirstMove((byte) move.getId());
    }
    
    public void setFourthMove(byte move) {
        writeStructure("Move4", move);
    }
    
    public short getBits() {
        return (short) readStructure("Bits");
    }
    
    public void setBits(short bits) {
        writeStructure("Bits", bits);
    }
}
