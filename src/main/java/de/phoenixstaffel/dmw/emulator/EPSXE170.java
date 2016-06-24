package de.phoenixstaffel.dmw.emulator;

import de.phoenixstaffel.dmw.DigimonWorldAPI;

public class EPSXE170 implements Emulator {
    private static final long INPUT_SETTINGS = 0x004BDB70;
    private static final long OUTPUT_START = 0x0050F0D0;
    
    private DigimonWorldAPI main;
    private EPSXEInputSettings input;
    
    public EPSXE170(DigimonWorldAPI main) {
        this.main = main;
        this.input = new EPSXEInputSettings(main, INPUT_SETTINGS);
    }
    
    @Override
    public String getName() {
        return "ePSXe";
    }
    
    @Override
    public String getVersion() {
        return "1.7.0";
    }
    
    @Override
    public long getMemoryOffset() {
        return -0x10B980;
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
