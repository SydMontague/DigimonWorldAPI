package de.phoenixstaffel.dmw;

import de.phoenixstaffel.dmw.events.ConsoleResetEvent;
import de.phoenixstaffel.dmw.events.LoadGameEvent;
import de.phoenixstaffel.dmw.events.NewGameEvent;

public enum GameState {
    MENU
    {
        @Override
        public GameState hasChanged(DigimonWorldAPI main, int backDimensionTimer, int maxHP) {
            if (backDimensionTimer == 0 && maxHP == 0) {
                main.getEventManager().callEvent(new NewGameEvent());
                return INGAME;
            }
            else if (maxHP != 0) {
                main.getEventManager().callEvent(new LoadGameEvent());
                return INGAME;
            }
            
            return this;
        }
    },
    INGAME
    {
        @Override
        public GameState hasChanged(DigimonWorldAPI main, int backDimensionTimer, int maxHP) {
            if (backDimensionTimer == 1 && maxHP == 0) {
                main.getEventManager().callEvent(new ConsoleResetEvent());
                return MENU;
            }
            
            return this;
        }
    };
    
    /**
     * Check with the given values whether the game state has changed and, if it did, possibly execute a custom logic (e.g. firing events).
     * The method returns the current state of the game.
     * 
     * @param main The main instance of the API
     * @param backDimensionTimer the back dimension timer, a value that is set to 1 in the main menu and undefined ingame.
     * @param maxHP the maxMP of your Digimon Partner, a value that is set to 0 in the main menu and != 0 ingame.
     * @return the current state of the game
     */
    public abstract GameState hasChanged(DigimonWorldAPI main, int backDimensionTimer, int maxHP);
}
