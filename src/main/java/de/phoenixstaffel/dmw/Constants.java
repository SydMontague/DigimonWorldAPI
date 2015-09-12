package de.phoenixstaffel.dmw;

public class Constants {
    
    private static final long SMALL_FLOPPY_VALUE = 0xB8BCFC;
    private static final long MEDIUM_FLOPPY_VALUE = 0xB8BCFE;
    private static final long LARGE_FLOPPY_VALUE = 0xB8BD00;
    
    private MemoryAccess memory;
    
    public Constants(DigimonWorldAPI main) {
        memory = main.getMemoryAccess();
    }
    
    public short getSmallFloppyValue() {
        return memory.readShort(SMALL_FLOPPY_VALUE);
    }
    
    public short getMediumFloppyValue() {
        return memory.readShort(MEDIUM_FLOPPY_VALUE);
    }
    
    public short getLargeFloppyValue() {
        return memory.readShort(LARGE_FLOPPY_VALUE);
    }
    
    public void setSmallFloppyValue(short value) {
        memory.writeShort(SMALL_FLOPPY_VALUE, value);
    }
    
    public void setMediumFloppyValue(short value) {
        memory.writeShort(MEDIUM_FLOPPY_VALUE, value);
    }
    
    public void setLargeFloppyValue(short value) {
        memory.writeShort(LARGE_FLOPPY_VALUE, value);
    }
}
