package me.abetgt.raft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

import static me.abetgt.raft.RaftEvents.config;

public class RaftConfig {

    private static File file;
    private static FileConfiguration customFile;

    public static void setup(){
        file = new File(Raft.getRaftDataFolder(), "script.yml");

        if (!file.exists()){
            // Fixed warning: Warning:(23, 23) Result of 'File.createNewFile()' is ignored
            try {file.createNewFile();} catch (IOException exception){
                exception.printStackTrace();
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try {
            customFile.save(file);
        } catch (IOException e){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&aRaft&r] Couldn't save config."));
        }
    }

    public static boolean hasContent(){
        // Fixed warning: Warning:(41, 9) 'if' statement can be simplified
        return config.getKeys(true).size() == 0;
    }

    public static void reload(Player player){
        try {
            for (String key : config.getKeys(true)){
                Bukkit.getConsoleSender().sendMessage("Raft Key Loader: Loaded key \"" + key + "\"");
                if (!(player == null)){
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lRaft >> &rRaft Key Loader: Loaded key \"" + key + "\""));
                }
            }
            try {
                customFile.save(file);
            } catch (IOException ignored){}
            customFile = YamlConfiguration.loadConfiguration(file);
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&aRaft&r] Successfully reloaded config."));
            if (!(player == null)){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lRaft >> &rSuccessfully reloaded config."));
            }
            for (String key : config.getKeys(true)){
                Bukkit.getConsoleSender().sendMessage("Raft Key Loader: Loaded key \"" + key + "\"");
                if (!(player == null)){
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lRaft >> &rRaft Key Loader: Loaded key \"" + key + "\""));
                }
            }

        } catch (IllegalArgumentException exception){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&aRaft&r] Couldn't reload config; config returned null."));
            if (!(player == null)){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lRaft >> &rCouldn't reload config; config returned null."));
            }
        }
    }

}
