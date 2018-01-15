package de.phoenixstaffel.dmw.emulator;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.MemoryAccess;

public class PSXfin113 implements Emulator {
    private static final long OFFSET_OFFSET = 0x571A5C;
    private static final String WINDOW_NAME = "PSXfin";
    
    private DigimonWorldAPI main;
    private MemoryAccess psxfinMemory = new MemoryAccess(getWindowName(), 0);
    
    public PSXfin113(DigimonWorldAPI main) {
        this.main = main;
    }
    
    @Override
    public String getName() {
        return "PSXfin";
    }
    
    @Override
    public String getVersion() {
        return "1.13";
    }

    @Override
    public String getWindowName() {
        return WINDOW_NAME;
    }
    
    @Override
    public long getMemoryOffset() {
        return psxfinMemory.readInteger(OFFSET_OFFSET) - 0xA579A0L;
    }
    
    @Override
    public void setButtonState(PSXControllerButton button, boolean pressed) {
        throw new UnsupportedOperationException(); // TODO implement
    }
    
    @Override
    public boolean getButtonState(PSXControllerButton button) {
        throw new UnsupportedOperationException(); // TODO implement
    }
    
}
