package de.essentialspro;

import de.essentialspro.listener.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class EssentialsPro extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Plugin gestartet!");
        loadListener();

        loadCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadListener() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
    }

    public void loadCommands() {

    }
}
