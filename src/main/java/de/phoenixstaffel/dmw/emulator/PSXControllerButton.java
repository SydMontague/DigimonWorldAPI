package de.phoenixstaffel.dmw.emulator;

public enum PSXControllerButton {
    LEFT("Left"),
    RIGHT("Right"),
    UP("Up"),
    DOWN("Down"),
    TRIANGLE("Triangle"),
    CIRCLE("Circle"),
    CROSS("Cross"),
    SQUARE("Square"),
    L1("L1"),
    L2("L2"),
    R1("R1"),
    R2("R2"),
    START("Start"),
    SELECT("Select");
    
    private String name;
    
    private PSXControllerButton(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
