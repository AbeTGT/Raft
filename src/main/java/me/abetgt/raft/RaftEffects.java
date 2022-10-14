/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */

package me.abetgt.raft;

import me.abetgt.raft.util.BetterLogger;
import me.abetgt.raft.util.RaftMisc;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Objects;

/**
 * RaftEffects is used to make the effects (e.g set player up velocity to/set the player's health to).
 * @author AbeTGT
 * @since 3/10/2022
 * @version 1.0
 */
public class RaftEffects {
    static FileConfiguration config = Raft.getScriptConfig();

    public static void log_noPlayer(String effect){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&aRaft&r] &cAn error occurred: There is no player specified. This could be because of an event that doesn't have a player involved."));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "[&aRaft&r] &cEffect attempt: " + effect));
    }

    static ArrayList<String> effectSyntaxList = new ArrayList<>();

    public static void runEffects(Player player, String event, Event chosenEvent){
        // c = the key for the config
        String c = event + ".";
        if (config.contains(c + "set player up velocity to")) {
            if (!(player == null)){
                player.setVelocity(new Vector(0.0, config.getInt(event + ".set player up velocity to"), 0.0));
            } else {
                log_noPlayer("set player up velocity to");
            }
        } if (config.contains(c + "set the player's health to")) {
            if (!(player == null)){
                player.setHealth(config.getInt(event + ".set the player's health to"));
            } else {
                log_noPlayer("set the player's health to");
            }
        } if (config.contains(c + "set the player's gamemode to")) {
            if (!(player == null)) {
                player.setGameMode(RaftMisc.calculateGameMode(config.getInt(event + ".set the player's gamemode to")));
            } else {
                log_noPlayer("set the player's gamemode to");
            }
        } if (config.contains(c + "send player message")) {
            if (!(player == null)) {
                player.sendMessage(Objects.requireNonNull(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getString(event + ".send player message")))));
            } else {
                log_noPlayer("send player message");
            }
        } if (config.contains(c + "make player chat")) {
            if (!(player == null)) {
                player.chat(Objects.requireNonNull(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getString(event + ".make player chat")))));
            } else {
                log_noPlayer("\"make player chat\"");
            }
        } if (config.contains(c + "broadcast")) {
            if (!(player == null)) {
                Bukkit.broadcastMessage(Objects.requireNonNull(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getString(event + ".broadcast")))));
            } else {
                log_noPlayer("\"broadcast\"");
            }
        } if (config.contains(c + "cancel event")) {
            String chosenString = config.getString(event + "." + "cancel event");
            if (chosenEvent instanceof Cancellable){
                if (Objects.equals(chosenString, "now") || Objects.equals(chosenString, "")){
                    ((Cancellable) chosenEvent).setCancelled(true);
                } else {
                    BetterLogger betterLogger = new BetterLogger(
                            "RaftEffects",
                            true);
                    betterLogger.log("[&aRaft&r] &cAn error occurred: You must provide an argument (either \"now\" or nothing).");
                    betterLogger.log("[&aRaft&r] &cEffect attempt: \"" + event + "\"");
            }
            } else {
                BetterLogger betterLogger = new BetterLogger(
                        "RaftEffects",
                        true);
                betterLogger.log("[&aRaft&r] &cAn error occurred: The event chosen does not implement Cancellable, which means that the event cannot be cancelled.");
                betterLogger.log("[&aRaft&r] &cEffect attempt: \"" + event + "\"");
            }
        } if (config.contains(c + "strike lightning at player's location")) {
            if (!(player == null)) {
                player.getWorld().strikeLightning(player.getLocation());
            } else {
                log_noPlayer("\"strike lightning at player's location\"");
            }
        } if (config.contains(c + "play sound to player")) {
            if (!(player == null)) {
                player.getWorld().playSound(player.getLocation(), Objects.requireNonNull(config.getString(c + "play sound to player")), 1, 1);
            } else {
                log_noPlayer("\"play sound to player\"");
            }
        } if (config.contains(c + "execute console command")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), Objects.requireNonNull(config.getString(c + "execute console command")));
        } if (config.contains(c + "execute player command")) {
            if (!(player == null)) {
                player.performCommand(Objects.requireNonNull(config.getString(c + "play sound to player")));
            } else {
                log_noPlayer("\"execute player command\"");
            }
        } if (config.contains(c + "create a temp string variable named")) {
            RaftVariable variable = new RaftVariable();
            variable.createVariable(config.getString(c + "create a temp string variable named"));
        } if (config.contains(c + "execute console command with variable")) {
            String configString = config.getString(c + "execute console command with variable");
            assert configString != null;
            String[] splitString = configString.split("%");
            Bukkit.getConsoleSender().sendMessage("Raft Split Strings: ");
            for (String t : splitString){
                Bukkit.getConsoleSender().sendMessage(t);
            }
        }
}}