/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EvtPlayerJoin implements Listener {
    // Player Join
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        RaftEvents.simpleEvent("on player join", event.getPlayer(), event);
    }
}