package de.phoenixstaffel.dmw.api.map;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.Move;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class DigimonEncounter extends Entity {
    
    {
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
        addStructureElement(new StructureElement("Undefined6", StructureElementType.UNDEFINED, 4));
        addStructureElement(new StructureElement("Autotalk", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Undefined7", StructureElementType.UNDEFINED, 1));
    }
    
    public DigimonEncounter(DigimonWorldAPI main, long baseAddress, short id) {
        super(main, baseAddress, id);
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
        return (short) readStructure("CurrentMP");
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
    
    public boolean isAutotalk() {
        return (byte) readStructure("Autotalk") != 0;
    }
    
    public void setAutotalk(boolean autotalk) {
        writeStructure("Autotalk", (byte) (autotalk ? 1 : 0));
    }
}
