package de.phoenixstaffel.dmw;

import java.util.Random;

import de.phoenixstaffel.dmw.api.ActiveMap;
import de.phoenixstaffel.dmw.api.World;
import de.phoenixstaffel.dmw.events.EventHandlingMethod;
import de.phoenixstaffel.dmw.events.EventManager;
import de.phoenixstaffel.dmw.events.LoadGameEvent;
import de.phoenixstaffel.dmw.events.NewGameEvent;
import de.phoenixstaffel.dmw.plugins.PluginManager;

/*
 * TODO let randomiser start the emulator?
 * TODO create "Digimon World API" module
 */
public class DigimonWorldAPI {
    private static long SLEEP_TIME = 10L;
    private static long SEED_TOP = 0xB8FE6C;
    private static long SEED_BOTTOM = 0xB8FE74;
    
    /**
     * Used for new game check. It's set to 1 at reset and set to 0 once you press new game.
     */
    private static long BACK_DIMENSION_TIMER = 0xC159ED;
    private static long MAX_HP = 0xBAD190;
    
    private MemoryAccess manager = new MemoryAccess();
    private EventManager eventManager = new EventManager();
    private PluginManager pluginManager;
    
    private ItemManager itemManager = new ItemManager(this);
    private MovesManager moveManager = new MovesManager(this);
    private DigimonManager digimonManager = new DigimonManager(this);
    
    private int seed = 0;
    
    private ActiveMap map = new ActiveMap(this);
    private World world = new World(this);
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        new DigimonWorldAPI();
    }
    
    public DigimonWorldAPI() {
        eventManager.registerEvents(this);
        pluginManager = new PluginManager(this);
        
        // while (true)
        // run();
    }
    
    @SuppressWarnings("unused")
    private void run() {
        // runStateChangeCheck();
        
        try {
            Thread.sleep(SLEEP_TIME);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unused")
    private void runStateChangeCheck() {
        int localBackDimensionTimer = manager.readByte(BACK_DIMENSION_TIMER);
        int localMaxHP = manager.readByte(MAX_HP);
        int oldSeed = seed;
        
        seed = (manager.readShort(SEED_TOP) << 16) + manager.readShort(SEED_BOTTOM) << 0;
        
        if (seed == 0 && localMaxHP == 0 && localBackDimensionTimer == 0) {
            eventManager.callEvent(new NewGameEvent());
            System.out.println("NewGameEvent " + seed + " " + oldSeed);
        }
        else if (oldSeed != seed && localMaxHP != 0) {
            eventManager.callEvent(new LoadGameEvent());
            System.out.println("LoadGameEvent " + seed + " " + oldSeed);
        }
    }
    
    @EventHandlingMethod
    public void onNewGame(NewGameEvent event) {
        Random rand = new Random();
        
        int newSeed = 0;
        while (newSeed == 0)
            newSeed = rand.nextInt();
        
        manager.writeShort(SEED_TOP, (short) (newSeed >> 16));
        manager.writeShort(SEED_BOTTOM, (short) (newSeed));
        seed = newSeed;
        System.out.println("New Game started, seed is " + seed + " " + newSeed);
    }
    
    @EventHandlingMethod
    public void onGameLoad(LoadGameEvent event) {
        System.out.println("Savestate loaded, new seed is " + seed);
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
