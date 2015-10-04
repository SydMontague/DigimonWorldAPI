package de.phoenixstaffel.dmw.plugins;

import java.util.Map;

public class PluginProperties {
    private final String mainClass;
    private final String name;
    private final String author;
    private final String version;
    private final String description;
    
    public PluginProperties(Map<String, String> map) {
        mainClass = map.get("main");
        name = map.get("name");
        author = map.get("author");
        version = map.get("version");
        description = map.get("description");
        
        if (mainClass == null || name == null)
            throw new IllegalArgumentException();
    }
    
    public String getName() {
        return name;
    }
    
    public String getMainClass() {
        return mainClass;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getVersion() {
        return version;
    }
    
    public String getDescription() {
        return description;
    }
    
}
