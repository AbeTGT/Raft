/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class BetterLogger {

    private final String title;
    private final boolean addColors;

    public BetterLogger(String title, boolean addColors){
        this.title = title;
        this.addColors = addColors;
    }

    public void log(String message){
        String newMsg = ChatColor.translateAlternateColorCodes('&', message);
        if (!addColors) newMsg = ChatColor.stripColor(newMsg);
        Bukkit.getConsoleSender().sendMessage(newMsg);
    }
}