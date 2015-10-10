package de.phoenixstaffel.dmw;

import de.phoenixstaffel.dmw.api.ActiveMap;
import de.phoenixstaffel.dmw.api.World;
import de.phoenixstaffel.dmw.emulator.EPSXE190;
import de.phoenixstaffel.dmw.emulator.Emulator;
import de.phoenixstaffel.dmw.events.EventManager;
import de.phoenixstaffel.dmw.plugins.PluginManager;

/*
 * TODO let randomiser start the emulator?
 * TODO create "Digimon World API" module
 */
public class DigimonWorldAPI {
    private static long SLEEP_TIME = 10L;
    
    /**
     * Used for new game check. It's set to 1 at reset and set to 0 once you press new game.
     */
    private static long BACK_DIMENSION_TIMER = 0xC159ED;
    private static long MAX_HP = 0xBAD190;
    
    private MemoryAccess manager = new MemoryAccess();
    private Emulator emulator;
    
    private EventManager eventManager = new EventManager();
    private PluginManager pluginManager;
    
    private ItemManager itemManager = new ItemManager(this);
    private MovesManager moveManager = new MovesManager(this);
    private DigimonManager digimonManager = new DigimonManager(this);
    
    private ActiveMap map = new ActiveMap(this);
    private World world = new World(this);
    
    private GameState state = null;
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        new DigimonWorldAPI();
    }
    
    public DigimonWorldAPI() {
        emulator = new EPSXE190(this); // TODO detect emulator type and version
        pluginManager = new PluginManager(this);
        eventManager.registerEvents(this);
        
        state = initState();
        
        while (true)
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
