package de.phoenixstaffel.dmw.api;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.PaddedStructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class Time extends BaseStructure {
    private static final long TIME_START = 0x00B8C85C;
    
    {
        addStructureElement(new PaddedStructureElement("Hours", 0, StructureElementType.SHORT));
        addStructureElement(new PaddedStructureElement("Minutes", 2, StructureElementType.SHORT));
        addStructureElement(new PaddedStructureElement("Year", 70, StructureElementType.SHORT));
        addStructureElement(new PaddedStructureElement("Day", 72, StructureElementType.SHORT));
    }
    
    public Time(DigimonWorldAPI main) {
        super(main, TIME_START);
    }
    
    public short getHours() {
        return (short) readStructure("Hours");
    }
    
    public void setHours(short value) {
        writeStructure("Hours", value);
    }
    
    public short getMinutes() {
        return (short) readStructure("Minutes");
    }
    
    public void setMinutes(short value) {
        writeStructure("Minutes", value);
    }
    
    public short getYear() {
        return (short) readStructure("Year");
    }
    
    public void setYear(short value) {
        writeStructure("Year", value);
    }
    
    public short getDay() {
        return (short) readStructure("Day");
    }
    
    public void setDay(short value) {
        writeStructure("Day", value);
    }
}
