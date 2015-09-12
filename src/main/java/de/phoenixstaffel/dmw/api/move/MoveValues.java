package de.phoenixstaffel.dmw.api.move;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.enums.MoveRange;
import de.phoenixstaffel.dmw.api.enums.Speciality;
import de.phoenixstaffel.dmw.api.enums.StatusEffect;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class MoveValues extends BaseStructure {
    {
        addStructureElement(new StructureElement("Power", StructureElementType.SHORT));
        addStructureElement(new StructureElement("MP", StructureElementType.BYTE));
        addStructureElement(new StructureElement("InvincibleTime", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Range", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Element", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Effect", StructureElementType.BYTE));
        addStructureElement(new StructureElement("BlockingFactor", StructureElementType.BYTE));
        addStructureElement(new StructureElement("EffectChance", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Unknown", StructureElementType.UNDEFINED, 7));
    }
    
    public MoveValues(DigimonWorldAPI main, long baseAddress, int id) {
        super(main, baseAddress, id);
    }
    
    public short getPower() {
        return (short) readStructure("Power");
    }
    
    public void setPower(short power) {
        writeStructure("Power", power);
    }
    
    public byte getMPUsage() {
        return (byte) readStructure("MP");
    }
    
    public void setMPUsage(byte mp) {
        writeStructure("MP", mp);
    }
    
    public byte getInvincibleTime() {
        return (byte) readStructure("InvincibleTime");
    }
    
    public void setInvincibleTime(short time) {
        writeStructure("InvincibleTime", time);
    }
    
    public MoveRange getRange() {
        return MoveRange.valueOf((byte) readStructure("Range"));
    }
    
    public void setRange(MoveRange range) {
        writeStructure("Range", range.getId());
    }
    
    public Speciality getElement() {
        return Speciality.valueOf((byte) readStructure("Element"));
    }
    
    public void setElement(Speciality element) {
        writeStructure("Element", element.getId());
    }
    
    public StatusEffect getEffect() {
        return StatusEffect.valueOf((byte) readStructure("Effect"));
    }
    
    public void setEffect(StatusEffect effect) {
        writeStructure("Effect", effect.getId());
    }
    
    public byte getBlockingFactor() {
        return (byte) readStructure("BlockingFactor");
    }
    
    public void setBlockingFactor(byte factor) {
        writeStructure("BlockingFactor", factor);
    }
    
    public byte getEffectChance() {
        return (byte) readStructure("EffectChance");
    }
    
    public void setEffectChance(byte chance) {
        writeStructure("EffectChance", chance);
    }
}
