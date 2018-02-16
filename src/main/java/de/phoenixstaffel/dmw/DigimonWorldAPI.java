package de.phoenixstaffel.dmw;

import java.util.Random;

import de.phoenixstaffel.dmw.api.ActiveMap;
import de.phoenixstaffel.dmw.api.World;
import de.phoenixstaffel.dmw.api.world.Buttons;
import de.phoenixstaffel.dmw.api.world.Triggers;
import de.phoenixstaffel.dmw.emulator.Emulator;
import de.phoenixstaffel.dmw.emulator.PSXfin113;
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
    private final Buttons buttons;
    private final Triggers triggers;
    
    private GameState state = null;
    private static boolean RUN = true;
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        new DigimonWorldAPI();
    }
    
    public DigimonWorldAPI() {
        emulator = new PSXfin113(this); // TODO detect emulator type and version
        manager = new MemoryAccess(emulator.getWindowName(), emulator.getMemoryOffset());
        
        eventManager = new EventManager();
        
        itemManager = new ItemManager(this);
        moveManager = new MovesManager(this);
        digimonManager = new DigimonManager(this);
        buttons = new Buttons(this);
        triggers = new Triggers(this);
        
        map = new ActiveMap(this);
        world = new World(this);
        
        Random r = new Random();
        
        state = initState();
        
        pluginManager = new PluginManager(this);
        
        System.out.println(world.getPartner().getEntity().getCurrentHP());
        System.out.println(world.getPartner().getEntity().getName());
        System.out.println(manager.readString(0xBAD1B0, 10));
        //while (RUN)
        //    run();
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

    public Buttons getButtons() {
        return buttons;
    }
}
