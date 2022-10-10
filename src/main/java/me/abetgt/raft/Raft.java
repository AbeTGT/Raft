/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public final class Raft extends JavaPlugin implements Listener {

    static Raft raftInstance;
    static File dataFolder;

    @Override
    public void onEnable() {
        // Plugin startup
        // Calculate start time. This will be the start of the "Completed" time.
        long start = System.currentTimeMillis();
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&aRaft&r] Loading Raft v&a" + getDescription().getVersion()));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&aRaft&r] Loading configs"));

        // Sorting out config stuff (pretty boring)
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        raftInstance = this;
        dataFolder = getDataFolder();
        RaftConfig.setup();
        RaftConfig.get().options().copyDefaults(true);
        RaftConfig.save();
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&aRaft&r] Finished loading configs"));

        // Load commands
        Objects.requireNonNull(getCommand("raft")).setExecutor(new RaftCommand());
        Objects.requireNonNull(getCommand("raft")).setTabCompleter(new RaftCommand());
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&aRaft&r] Loading commands and listeners"));

        // Register all listeners and classes
        int registered = RaftRegisterAll.registerClasses();

        // Get the time from start and now
        long now = System.currentTimeMillis() - start / 1000;

        // Finish
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&aRaft&r] Successfully registered " + registered + " events!"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&aRaft&r] Completed in " + now + "s!"));
    }

    @EventHandler
    public void onReload(ServerLoadEvent event){
        if (event.getType() == ServerLoadEvent.LoadType.RELOAD){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&aRaft&r] &cWarning: Raft does not support reloading. Please restart your server instead of reloading next time. If any errors occur, you will not receive support or help if your server has been reloaded."));
        }
    }

    public static Raft getRaftInstance(){
        return raftInstance;
    }

    public static File getRaftDataFolder(){
        return dataFolder;
    }

    public static FileConfiguration getScriptConfig(){
        return RaftConfig.get();
    }
}
