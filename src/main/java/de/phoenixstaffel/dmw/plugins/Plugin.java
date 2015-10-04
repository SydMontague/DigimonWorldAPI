package de.phoenixstaffel.dmw.plugins;

import de.phoenixstaffel.dmw.DigimonWorldAPI;

public abstract class Plugin {
    private final DigimonWorldAPI main;
    private final PluginProperties properties;
    private final ClassLoader loader;
    
    public Plugin(DigimonWorldAPI main, PluginProperties properties, ClassLoader loader) {
        this.main = main;
        this.properties = properties;
        this.loader = loader;
    }
    
    public abstract void onEnable();
    
    public abstract void onDisable();
    
    public DigimonWorldAPI getDigimonWorld() {
        return main;
    }
    
    public PluginProperties getProperties() {
        return properties;
    }
    
    protected ClassLoader getClassLoader() {
        return loader;
    }
}
