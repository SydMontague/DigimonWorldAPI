package de.phoenixstaffel.dmw.emulator;


public interface Emulator {
    public String getName();
    
    public String getVersion();
    
    public String getWindowName();
    
    public long getMemoryOffset();
    
    public void setButtonState(PSXControllerButton button, boolean pressed);
    
    public boolean getButtonState(PSXControllerButton button);
}
