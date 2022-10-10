package me.abetgt.raft;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class RaftConfig {

    private static File file;
    private static FileConfiguration customFile;

    public static void setup(){
        file = new File(Raft.getRaftDataFolder(), "script.yml");

        if (!file.exists()){
            try {file.createNewFile();} catch (IOException ignore){}
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

    public static void reload(Player player){
        try {
            customFile = YamlConfiguration.loadConfiguration(file);
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&aRaft&r] Successfully reloaded config."));
            if (!(player == null)){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lRaft >> &rSuccessfully reloaded config."));
            }
        } catch (IllegalArgumentException exception){
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&aRaft&r] Couldn't reload config; config returned null."));
            if (!(player == null)){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lRaft >> &rCouldn't reload config; config returned null."));
            }
        }
    }

}