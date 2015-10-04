package de.phoenixstaffel.dmw.plugins;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import de.phoenixstaffel.dmw.DigimonWorldAPI;

public class PluginManager {
    private static final String PLUGIN_FOLDER = "./plugins";
    private DigimonWorldAPI main;
    
    public PluginManager(DigimonWorldAPI main) {
        this.main = main;
        
        File pluginFolder = new File(PLUGIN_FOLDER);
        
        for (File file : pluginFolder.listFiles()) {
            if (!file.isFile())
                continue;
            
            if (!file.getName().endsWith(".jar"))
                continue;
            
            try {
                loadPlugin(file);
            }
            catch (Exception e) {
                System.out.println("Error while loading " + file.getName() + ".jar.");
            }
        }
    }
    
    private void loadPlugin(File file) throws Exception {
        @SuppressWarnings("resource")
        URLClassLoader loader = new URLClassLoader(new URL[] { file.toURI().toURL() }, this.getClass().getClassLoader());
        PluginProperties properties = loadPluginProperties(loader.findResource("plugin.properties").openStream());
        
        Class<?> clazz = loader.loadClass(properties.getMainClass());
        Plugin instance;
        if (!Plugin.class.isAssignableFrom(clazz)) {
            loader.close();
            throw new IllegalArgumentException();
        }
        
        instance = (Plugin) clazz.getConstructor(main.getClass(), PluginProperties.class, ClassLoader.class).newInstance(main, properties, loader);
        instance.onEnable();
    }
    
    private PluginProperties loadPluginProperties(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        
        Map<String, String> map = new HashMap<>();
        
        String line;
        while ((line = reader.readLine()) != null) {
            String[] array = line.split("=", 2);
            if (array.length != 2)
                continue;
            map.put(array[0], array[1]);
        }
        
        return new PluginProperties(map);
    }
    
}
