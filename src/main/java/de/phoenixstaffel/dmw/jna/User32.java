package de.phoenixstaffel.dmw.jna;

public interface User32 extends com.sun.jna.platform.win32.User32 {
    
    HWND FindWindowA(String lpClassName, String lpWindowName);
}
