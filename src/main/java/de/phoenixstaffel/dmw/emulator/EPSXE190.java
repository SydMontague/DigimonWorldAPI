package de.phoenixstaffel.dmw.emulator;

import de.phoenixstaffel.dmw.DigimonWorldAPI;

public class EPSXE190 implements Emulator {
    private static final long INPUT_SETTINGS = 0x004E2DF8;
    private static final long OUTPUT_START = 0x004F5100;
    private static final String WINDOW_NAME = "ePSXe - Enhanced PSX emulator";
    
    private DigimonWorldAPI main;
    private EPSXEInputSettings input;
    
    public EPSXE190(DigimonWorldAPI main) {
        this.main = main;
        this.input = new EPSXEInputSettings(main, INPUT_SETTINGS);
    }
    
    @Override
    public String getName() {
        return "ePSXe";
    }
    
    @Override
    public String getVersion() {
        return "1.9.0";
    }
    
    @Override
    public String getWindowName() {
        return WINDOW_NAME;
    }
    
    @Override
    public long getMemoryOffset() {
        return 0;
    }
    
    @Override
    public void setButtonState(PSXControllerButton button, boolean pressed) {
        main.getMemoryAccess().writeByte(OUTPUT_START + input.getButtonMapping(button), (byte) (pressed ? 1 : 0));
    }
    
    @Override
    public boolean getButtonState(PSXControllerButton button) {
        return main.getMemoryAccess().readByte(OUTPUT_START + input.getButtonMapping(button)) != 0;
    }
    
}
