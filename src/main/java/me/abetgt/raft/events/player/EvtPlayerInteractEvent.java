/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EvtPlayerInteractEvent implements Listener {
    // Player Interact
    @EventHandler
    public void onBlockBreak(org.bukkit.event.player.PlayerInteractEvent event){
        RaftEvents.simpleEvent("on player interact", event.getPlayer(), event);
    }
}