package me.unfoundagent.logger;

import me.unfoundagent.logger.listeners.EventListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Logger extends JavaPlugin {

    // Reference to the LogManager class
    private LogManager logManager;

    @Override
    public void onEnable() {
        // When the plugin is enabled, it will create a new LogManager object and pass this plugin to it
        this.logManager = new LogManager(this);
        // Register the EventListener class to listen for events and pass the logManager to it and pass this plugin to EventListener
        getServer().getPluginManager().registerEvents(new EventListener(logManager), this);

        getLogger().info(ChatColor.GREEN + "Logger plugin enabled and logging events!");
    }

    @Override
    public void onDisable() {
        if (logManager != null) {
            logManager.saveLog();
        }
    }
}
