package de.phoenixstaffel.dmw.api.world;

import de.phoenixstaffel.dmw.DigimonWorldAPI;
import de.phoenixstaffel.dmw.core.BaseStructure;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.core.StructureElementType;
import de.phoenixstaffel.dmw.emulator.PSXControllerButton;

public class Buttons extends BaseStructure {
    private static final long BASE_ADDRESS = 0xB8C810;

    {
        addStructureElement(new StructureElement("Buttons", StructureElementType.SHORT));
    }
    
    public Buttons(DigimonWorldAPI main) {
        super(main, BASE_ADDRESS);
    }
    
    public boolean getButtonState(PSXControllerButton button) {
        short value = (short) readStructure("Buttons");
        switch(button) {
            case LEFT:
                return (value & 0x8000) != 0;
            case RIGHT:
                return (value & 0x2000) != 0;
            case UP:
                return (value & 0x1000) != 0;
            case DOWN:
                return (value & 0x4000) != 0;
            case TRIANGLE:
                return (value & 0x0010) != 0;
            case CIRCLE:
                return (value & 0x0020) != 0;
            case CROSS:
                return (value & 0x0040) != 0;
            case SQUARE:
                return (value & 0x0080) != 0;
            case L1:
                return (value & 0x0001) != 0;
            case L2:
                return (value & 0x0004) != 0;
            case R1:
                return (value & 0x0002) != 0;
            case R2:
                return (value & 0x0008) != 0;
            case START:
                return (value & 0x0800) != 0;
            case SELECT:
                return (value & 0x0100) != 0;
        }
        
        return false;
    }
    
}
