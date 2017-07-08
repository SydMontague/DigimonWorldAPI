package de.phoenixstaffel.dmw;

import java.util.Random;

import de.phoenixstaffel.dmw.api.ActiveMap;
import de.phoenixstaffel.dmw.api.World;
import de.phoenixstaffel.dmw.emulator.EPSXE170;
import de.phoenixstaffel.dmw.emulator.EPSXE190;
import de.phoenixstaffel.dmw.emulator.Emulator;
import de.phoenixstaffel.dmw.events.EventManager;
import de.phoenixstaffel.dmw.plugins.PluginManager;

/*
 * TODO let randomiser start the emulator?
 */
public class DigimonWorldAPI {
    private static long SLEEP_TIME = 10L;
    
    /**
     * Used for new game check. It's set to 1 at reset and set to 0 once you press new game.
     */
    private static final long BACK_DIMENSION_TIMER = 0xC159ED;
    private static final long MAX_HP = 0xBAD190;
    
    private final MemoryAccess manager;
    private final Emulator emulator;
    
    private final EventManager eventManager;
    private final PluginManager pluginManager;
    
    private final ItemManager itemManager;
    private final MovesManager moveManager;
    private final DigimonManager digimonManager;
    
    private final ActiveMap map;
    private final World world;
    
    private GameState state = null;
    private static boolean RUN = true;
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        new DigimonWorldAPI();
    }
    
    public DigimonWorldAPI() {
        emulator = new EPSXE170(this); // TODO detect emulator type and version
        manager = new MemoryAccess(emulator.getMemoryOffset());
        
        eventManager = new EventManager();
        
        itemManager = new ItemManager(this);
        moveManager = new MovesManager(this);
        digimonManager = new DigimonManager(this);
        
        map = new ActiveMap(this);
        world = new World(this);
        
        Random r = new Random();
        
        state = initState();
        
        pluginManager = new PluginManager(this);
        
        while (RUN)
            run();
    }
    
    private void run() {
        stateCheck();
        
        try {
            Thread.sleep(SLEEP_TIME);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private GameState initState() {
        int backDimensionTimer = manager.readByte(BACK_DIMENSION_TIMER);
        int maxHP = manager.readByte(MAX_HP);
        
        return backDimensionTimer == 1 && maxHP == 0 ? GameState.MENU : GameState.INGAME;
    }
    
    private void stateCheck() {
        int backDimensionTimer = manager.readByte(BACK_DIMENSION_TIMER);
        int maxHP = manager.readByte(MAX_HP);
        
        state = state.hasChanged(this, backDimensionTimer, maxHP);
    }
    
    public Emulator getEmulator() {
        return emulator;
    }
    
    public World getWorld() {
        return world;
    }
    
    public ActiveMap getActiveMap() {
        return map;
    }
    
    public MemoryAccess getMemoryAccess() {
        return manager;
    }
    
    public EventManager getEventManager() {
        return eventManager;
    }
    
    public ItemManager getItemManager() {
        return itemManager;
    }
    
    public MovesManager getMovesManager() {
        return moveManager;
    }
    
    public DigimonManager getDigimonManager() {
        return digimonManager;
    }
    
    public PluginManager getPluginManager() {
        return pluginManager;
    }
}
