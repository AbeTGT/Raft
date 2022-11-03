/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player;

import me.abetgt.raft.Raft;
import me.abetgt.raft.RaftEvents;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class EvtPlayerCommand implements Listener {
    // Player Command
    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event){
        RaftEvents.simpleEvent("on player command", event.getPlayer(), event);
        Bukkit.getLogger().info("Event Message: " + event.getMessage());
        event.getPlayer().sendMessage("Event Message: " + event.getMessage());
        for (String t : Raft.getCommandArray()){
            if (event.getMessage().equals("/" + t)){
                String[] syntaxes = {
                        "on command /" + t,
                };
                RaftEvents.simpleEvent(syntaxes, event.getPlayer(), event);
            }
        }
    }
}