package de.phoenixstaffel.dmw.emulator;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class EPSXEInputSettings extends BaseStructure {
    
    {
        addStructureElement(new StructureElement("Left", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Right", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Up", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Down", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Triangle", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Circle", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Cross", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Square", StructureElementType.SHORT));
        addStructureElement(new StructureElement("L1", StructureElementType.SHORT));
        addStructureElement(new StructureElement("L2", StructureElementType.SHORT));
        addStructureElement(new StructureElement("R1", StructureElementType.SHORT));
        addStructureElement(new StructureElement("R2", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Start", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Select", StructureElementType.SHORT));
    }
    
    public EPSXEInputSettings(DigimonWorldAPI main, long baseAddress) {
        super(main, baseAddress, 0);
    }
    
    public short getButtonMapping(PSXControllerButton button) {
        return (short) readStructure(button.getName());
    }
    
    public void setButtonMapping(PSXControllerButton button, short value) {
        writeStructure(button.getName(), value);
    }
    
    public short getLeft() {
        return (short) readStructure("Left");
    }
    
    public void setLeft(short value) {
        writeStructure("Left", value);
    }
    
    public short getRight() {
        return (short) readStructure("Right");
    }
    
    public void setRight(short value) {
        writeStructure("Right", value);
    }
    
    public short getUp() {
        return (short) readStructure("Up");
    }
    
    public void setUp(short value) {
        writeStructure("Up", value);
    }
    
    public short getDown() {
        return (short) readStructure("Down");
    }
    
    public void setDown(short value) {
        writeStructure("Down", value);
    }
    
    public short getTriangle() {
        return (short) readStructure("Triangle");
    }
    
    public void setTriangle(short value) {
        writeStructure("Triangle", value);
    }
    
    public short getCircle() {
        return (short) readStructure("Circle");
    }
    
    public void setCircle(short value) {
        writeStructure("Circle", value);
    }
    
    public short getCross() {
        return (short) readStructure("Cross");
    }
    
    public void setCross(short value) {
        writeStructure("Cross", value);
    }
    
    public short getSquare() {
        return (short) readStructure("Square");
    }
    
    public void setSquare(short value) {
        writeStructure("Square", value);
    }
    
    public short getL1() {
        return (short) readStructure("L1");
    }
    
    public void setL1(short value) {
        writeStructure("L1", value);
    }
    
    public short getL2() {
        return (short) readStructure("L2");
    }
    
    public void setL2(short value) {
        writeStructure("L2", value);
    }
    
    public short getR1() {
        return (short) readStructure("R1");
    }
    
    public void setR1(short value) {
        writeStructure("R1", value);
    }
    
    public short getR2() {
        return (short) readStructure("R2");
    }
    
    public void setR2(short value) {
        writeStructure("R2", value);
    }
    
    public short getStart() {
        return (short) readStructure("Start");
    }
    
    public void setStart(short value) {
        writeStructure("Start", value);
    }
    
    public short getSelect() {
        return (short) readStructure("Select");
    }
    
    public void setSelect(short value) {
        writeStructure("Select", value);
    }
}
