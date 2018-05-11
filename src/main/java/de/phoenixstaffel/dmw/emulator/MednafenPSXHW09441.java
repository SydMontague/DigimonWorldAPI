package de.phoenixstaffel.dmw.emulator;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.MemoryAccess;

public class MednafenPSXHW09441 implements Emulator {
    private static final long OFFSET_OFFSET = 0x8B2850;
    private static final String WINDOW_NAME = "RetroArch Beetle PSX HW 0.9.44.1 4a75947";
    
    private DigimonWorldAPI main;
    private MemoryAccess mednafenMemory = new MemoryAccess(getWindowName(), 0);
    
    public MednafenPSXHW09441(DigimonWorldAPI main) {
        this.main = main;
    }
    
    @Override
    public String getName() {
        return "MednafenPSXHW09441";
    }
    
    @Override
    public String getVersion() {
        return "0.9.44.1";
    }
    @Override
    public String getWindowName() {
        return WINDOW_NAME;
    }
    
    @Override
    public long getMemoryOffset() {
        return mednafenMemory.readInteger(OFFSET_OFFSET) - 0xA579A0L;
    }
    
    @Override
    public void setButtonState(PSXControllerButton button, boolean pressed) {
        throw new UnsupportedOperationException(); // TODO implement
    }
    
    @Override
    public boolean getButtonState(PSXControllerButton button) {
        return main.getButtons().getButtonState(button);
    }
    
}
