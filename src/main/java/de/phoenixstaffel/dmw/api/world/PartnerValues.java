package de.phoenixstaffel.dmw.api.world;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;

public class PartnerValues extends BaseStructure {
    
    {
        addStructureElement(new StructureElement("Condition", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Unknown1", StructureElementType.UNDEFINED, 23));
        addStructureElement(new StructureElement("PoopLevel", StructureElementType.INT));
        addStructureElement(new StructureElement("Unknown2", StructureElementType.UNDEFINED, 2));
        addStructureElement(new StructureElement("VirusBar", StructureElementType.SHORT));
        addStructureElement(new StructureElement("PoopingTimer", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Tiredness", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Unknown3", StructureElementType.UNDEFINED, 4));
        addStructureElement(new StructureElement("Discipline", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Happiness", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Unknown4", StructureElementType.UNDEFINED, 16));
        addStructureElement(new StructureElement("EnergyLevel", StructureElementType.SHORT));
        addStructureElement(new StructureElement("FoodLevel", StructureElementType.SHORT));
        addStructureElement(new StructureElement("StarvationTimer", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Weight", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Unknown5", StructureElementType.UNDEFINED, 2));
        addStructureElement(new StructureElement("Unknown6", StructureElementType.UNDEFINED, 2));
        addStructureElement(new StructureElement("RemainingLifetime", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Age", StructureElementType.SHORT));
        addStructureElement(new StructureElement("TrainingBoostFlag", StructureElementType.BYTE));
        addStructureElement(new StructureElement("Unknown7", StructureElementType.UNDEFINED, 1));
        addStructureElement(new StructureElement("TrainingBoost", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Unknown8", StructureElementType.UNDEFINED, 2));
        addStructureElement(new StructureElement("CareMistakes", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Battles", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Unknown8", StructureElementType.UNDEFINED, 8));
        addStructureElement(new StructureElement("FishCaught", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Unknown9", StructureElementType.UNDEFINED, 6));
        addStructureElement(new StructureElement("UpgradeCounterHP", StructureElementType.SHORT));
        addStructureElement(new StructureElement("UpgradeCounterMP", StructureElementType.SHORT));
        addStructureElement(new StructureElement("UpgradeCounterOffense", StructureElementType.SHORT));
        addStructureElement(new StructureElement("UpgradeCounterEmpty", StructureElementType.SHORT));
        addStructureElement(new StructureElement("UpgradeCounterDefense", StructureElementType.SHORT));
        addStructureElement(new StructureElement("UpgradeCounterSpeed", StructureElementType.SHORT));
        addStructureElement(new StructureElement("UpgradeCounterBrains", StructureElementType.SHORT));
        addStructureElement(new StructureElement("Unknown10", StructureElementType.UNDEFINED, 2));
        addStructureElement(new StructureElement("SukamonBackupHP", StructureElementType.SHORT));
        addStructureElement(new StructureElement("SukamonBackupMP", StructureElementType.SHORT));
        addStructureElement(new StructureElement("SukamonBackupOffense", StructureElementType.SHORT));
        addStructureElement(new StructureElement("SukamonBackupDefense", StructureElementType.SHORT));
        addStructureElement(new StructureElement("SukamonBackupSpeed", StructureElementType.SHORT));
        addStructureElement(new StructureElement("SukamonBackupBrains", StructureElementType.SHORT));
    }
    
    public PartnerValues(DigimonWorldAPI main, long baseAddress) {
        super(main, baseAddress);
    }
    
    public DigimonConditions getConditions() {
        return new DigimonConditions((byte) readStructure("Condition"));
    }
    
    public void setDigimonConditions(DigimonConditions conditions) {
        writeStructure("Condition", conditions.getValue());
    }
    
    public int getPoopLevel() {
        return (int) readStructure("PoopLevel");
    }
    
    public void setPoopLevel(int level) {
        writeStructure("PoopLevel", level);
    }
    
    public short getVirusBar() {
        return (short) readStructure("VirusBar");
    }
    
    public void setVirusBar(short value) {
        writeStructure("VirusBar", value);
    }
    
    public short getPoopingTimer() {
        return (short) readStructure("PoopingTimer");
    }
    
    public void setPoopingTimer(short value) {
        writeStructure("PoopingTimer", value);
    }
    
    public short getTiredness() {
        return (short) readStructure("Tiredness");
    }
    
    public void setTiredness(short value) {
        writeStructure("Tiredness", value);
    }
    
    public short getDiscipline() {
        return (short) readStructure("Discipline");
    }
    
    public void setDiscipline(short value) {
        writeStructure("Discipline", value);
    }
    
    public short getHappiness() {
        return (short) readStructure("Happiness");
    }
    
    public void setHappiness(short value) {
        writeStructure("Happiness", value);
    }
    
    public short getEnergyLevel() {
        return (short) readStructure("EnergyLevel");
    }
    
    public void setEnergyLevel(short value) {
        writeStructure("EnergyLevel", value);
    }
    
    public short getFoodLevel() {
        return (short) readStructure("FoodLevel");
    }
    
    public void setFoodLevel(short value) {
        writeStructure("FoodLevel", value);
    }
    
    public short getStarvationTimer() {
        return (short) readStructure("StarvationTimer");
    }
    
    public void setStarvationTimer(short value) {
        writeStructure("StarvationTimer", value);
    }
    
    public short getWeight() {
        return (short) readStructure("Weight");
    }
    
    public void setWeight(short value) {
        writeStructure("Weight", value);
    }
    
    public short getRemainingLifetime() {
        return (short) readStructure("RemainingLifetime");
    }
    
    public void setRemainingLifetime(short value) {
        writeStructure("RemainingLifetime", value);
    }
    
    public short getAge() {
        return (short) readStructure("Age");
    }
    
    public void setAge(short value) {
        writeStructure("Age", value);
    }
    
    public TrainingBoostFlags getTrainingBoostFlag() {
        return new TrainingBoostFlags((byte) readStructure("TrainingBoostFlag"));
    }
    
    public void setTrainingBoostFlag(TrainingBoostFlags value) {
        writeStructure("TrainingBoostFlag", value.getValue());
    }
    
    public short getTrainingBoost() {
        return (short) readStructure("TrainingBoost");
    }
    
    public void setTrainingBoost(short value) {
        writeStructure("TrainingBoost", value);
    }
    
    public short getCareMistakes() {
        return (short) readStructure("CareMistakes");
    }
    
    public void setCareMistakes(short value) {
        writeStructure("CareMistakes", value);
    }
    
    public short getBattles() {
        return (short) readStructure("Battles");
    }
    
    public void setBattles(short value) {
        writeStructure("Battles", value);
    }
    
    public short getFishCaught() {
        return (short) readStructure("FishCaught");
    }
    
    public void setFishCaught(short value) {
        writeStructure("FishCaught", value);
    }
    
    public short getUpgradeCounterHP() {
        return (short) readStructure("UpgradeCounterHP");
    }
    
    public void setUpgradeCounterHP(short value) {
        writeStructure("UpgradeCounterHP", value);
    }
    
    public short getUpgradeCounterMP() {
        return (short) readStructure("UpgradeCounterMP");
    }
    
    public void setUpgradeCounterMP(short value) {
        writeStructure("UpgradeCounterMP", value);
    }
    
    public short getUpgradeCounterOffense() {
        return (short) readStructure("UpgradeCounterOffense");
    }
    
    public void setUpgradeCounterOffense(short value) {
        writeStructure("UpgradeCounterOffense", value);
    }
    
    public short getUpgradeCounterEmpty() {
        return (short) readStructure("UpgradeCounterEmpty");
    }
    
    public void setUpgradeCounterEmpty(short value) {
        writeStructure("UpgradeCounterEmpty", value);
    }
    
    public short getUpgradeCounterDefense() {
        return (short) readStructure("UpgradeCounterDefense");
    }
    
    public void setUpgradeCounterDefense(short value) {
        writeStructure("UpgradeCounterDefense", value);
    }
    
    public short getUpgradeCounterSpeed() {
        return (short) readStructure("UpgradeCounterSpeed");
    }
    
    public void setUpgradeCounterSpeed(short value) {
        writeStructure("UpgradeCounterSpeed", value);
    }
    
    public short getUpgradeCounterBrains() {
        return (short) readStructure("UpgradeCounterBrains");
    }
    
    public void setUpgradeCounterBrains(short value) {
        writeStructure("UpgradeCounterBrains", value);
    }
    
    public short getSukamonBackupHP() {
        return (short) readStructure("SukamonBackupHP");
    }
    
    public void setSukamonBackupHP(short value) {
        writeStructure("SukamonBackupHP", value);
    }
    
    public short getSukamonBackupMP() {
        return (short) readStructure("SukamonBackupMP");
    }
    
    public void setSukamonBackupMP(short value) {
        writeStructure("SukamonBackupMP", value);
    }
    
    public short getSukamonBackupOffense() {
        return (short) readStructure("SukamonBackupOffense");
    }
    
    public void setSukamonBackupOffense(short value) {
        writeStructure("SukamonBackupOffense", value);
    }
    
    public short getSukamonBackupDefense() {
        return (short) readStructure("SukamonBackupDefense");
    }
    
    public void setSukamonBackupDefense(short value) {
        writeStructure("SukamonBackupDefense", value);
    }
    
    public short getSukamonBackupSpeed() {
        return (short) readStructure("SukamonBackupSpeed");
    }
    
    public void setSukamonBackupSpeed(short value) {
        writeStructure("SukamonBackupSpeed", value);
    }
    
    public short getSukamonBackupBrains() {
        return (short) readStructure("SukamonBackupBrains");
    }
    
    public void setSukamonBackupBrains(short value) {
        writeStructure("SukamonBackupBrains", value);
    }
    
}
