package de.phoenixstaffel.dmw.api.digimon;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.api.Item;
import de.phoenixstaffel.dmw.api.enums.SleepCycle;
import de.phoenixstaffel.dmw.api.enums.TrainingType;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class RaisingValues extends BaseStructure {
    private static final int HUNGER_LENGHT = 8;
    
    {
        addStructureElement(new StructureElement("HungerTimes", StructureElementType.BYTE_ARRAY, HUNGER_LENGHT));
        addStructureElement(new StructureElement("EnergyCapacity", StructureElementType.BYTE));
        addStructureElement(new StructureElement("EnergyThreshold", StructureElementType.BYTE));
        addStructureElement(new StructureElement("EnergyUsage", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Unknown1", StructureElementType.UNDEFINED, 1));
        addStructureElement(new StructureElement("PoopTime", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Unknown2", StructureElementType.UNDEFINED, 3));
        addStructureElement(new StructureElement("PoopSize", StructureElementType.BYTE));
        addStructureElement(new StructureElement("FavoriteFood", StructureElementType.BYTE));
        addStructureElement(new StructureElement("SleepCycle", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Unknown3", StructureElementType.UNDEFINED, 1));
        addStructureElement(new StructureElement("TrainingType", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Unknown4", StructureElementType.UNDEFINED, 7));
    }
    
    public RaisingValues(DigimonWorldAPI main, long baseAddress, int id) {
        super(main, baseAddress, id);
    }
    
    public byte[] getFeedingTimes() {
        return (byte[]) readStructure("HungerTimes");
    }
    
    public void setFeedingTimes(byte[] array) {
        writeStructure("HungerTimes", array);
    }
    
    public byte getEnergyCapacity() {
        return (byte) readStructure("EnergyCapacity");
    }
    
    public void setEnergyCapacity(byte cap) {
        writeStructure("EnergyCapacity", cap);
    }
    
    public byte getEnergyThreshold() {
        return (byte) readStructure("EnergyThreshold");
    }
    
    public void setEnergyThreshold(byte threshold) {
        writeStructure("EnergyThreshold", threshold);
    }
    
    public byte getEnergyUsage() {
        return (byte) readStructure("EnergyUsage");
    }
    
    public void setEnergyUsage(byte usage) {
        writeStructure("EnergyUsage", usage);
    }
    
    public byte getPoopTime() {
        return (byte) readStructure("PoopTime");
    }
    
    public void setPoopTime(byte poopTime) {
        writeStructure("PoopTime", poopTime);
    }
    
    public byte getPoopSize() {
        return (byte) readStructure("PoopSize");
    }
    
    public void setPoopSize(byte poopSize) {
        writeStructure("PoopSize", poopSize);
    }
    
    public Item getFavoriteFood() {
        return getMain().getItemManager().getItem((byte) readStructure("FavoriteFood"));
    }
    
    public void setFavoriteFood(Item item) {
        setFavoriteFood((byte) item.getId());
    }
    
    public void setFavoriteFood(byte food) {
        writeStructure("FavoriteFood", food);
    }
    
    public SleepCycle getSleepCycle() {
        return SleepCycle.valueOf((byte) readStructure("SleepCycle"));
    }
    
    public void setSleepCycle(SleepCycle sleepCycle) {
        writeStructure("SleepCycle", sleepCycle.getId());
    }
    
    public TrainingType getTrainingType() {
        return TrainingType.valueOf((byte) readStructure("TrainingType"));
    }
    
    public void setTrainingType(TrainingType trainingType) {
        writeStructure("TrainingType", trainingType.getId());
    }
}
