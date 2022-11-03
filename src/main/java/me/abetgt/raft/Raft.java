/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft;

import me.abetgt.raft.util.BetterLogger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public final class Raft extends JavaPlugin implements Listener {

    BetterLogger logger = new BetterLogger("", true);
    static Raft raftInstance;
    static File dataFolder;

    static ArrayList<String> commandArray = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup
        // Enable listeners from this class
        getServer().getPluginManager().registerEvents(this, this);
        // Calculate start time. This will be the start of the "Completed" time.
        long start = System.currentTimeMillis();
        logger.log("[&aRaft&r] Loading Raft v&a" + getDescription().getVersion());
        logger.log("[&aRaft&r] Loading configs");

        // Sorting out config stuff (pretty boring)
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        raftInstance = this;
        dataFolder = getDataFolder();
        RaftConfig.setup();
        RaftConfig.get().options().copyDefaults(true);
        RaftConfig.save();
        logger.log("[&aRaft&r] Finished loading configs");

        // Load commands
        Objects.requireNonNull(getCommand("raft")).setExecutor(new RaftCommand());
        Objects.requireNonNull(getCommand("raft")).setTabCompleter(new RaftCommand());
        logger.log("[&aRaft&r] Loading commands and listeners");

        // Register all listeners and classes
        int registered = RaftRegisterAll.registerClasses();

        // Get the time from start and now
        long now = System.currentTimeMillis() - start;

        // Finish
        logger.log("[&aRaft&r] Successfully registered " + registered + " events!");
        logger.log("[&aRaft&r] Completed in " + now + "ms!");
        if (RaftConfig.hasContent()) logger.log("[&aRaft&r] No script content found, maybe you should write some ;)");
    }

    @EventHandler
    public void onReload(ServerLoadEvent event){
        if (event.getType() == ServerLoadEvent.LoadType.RELOAD){
            logger.log("[&aRaft&r] &cWarning: Raft does not support reloading. Please restart your server instead of reloading next time. If any errors occur, you will not receive support or help if your server has been reloaded.");
        }
    }

    public static Raft getRaftInstance(){
        return raftInstance;
    }

    public static File getRaftDataFolder(){
        return dataFolder;
    }

    public static ArrayList<String> getCommandArray(){
        return commandArray;
    }

    public static FileConfiguration getScriptConfig(){
        return RaftConfig.get();
    }
}
