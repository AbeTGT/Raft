/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class EvtPlayerQuit implements Listener {
    // Player Quit
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        RaftEvents.simpleEvent("on player quit", event.getPlayer(), event);
    }
}