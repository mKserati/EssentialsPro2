package de.essentialspro;

import de.essentialspro.commands.CommandGamemode;
import de.essentialspro.listener.JoinListener;
import de.essentialspro.utils.Utilities;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class EssentialsPro extends JavaPlugin {

    private static Utilities utilities;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Plugin gestartet!");

        // LOADING LISTENER
        loadListener();

        // LOADING COMMANDS

        loadCommands();

        // LOADING OTHER STAFF

        utilities = new Utilities();
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
        getCommand("gamemode").setExecutor(new CommandGamemode());
    }

    public static Utilities getUtilities() {
        return utilities;
    }
}
