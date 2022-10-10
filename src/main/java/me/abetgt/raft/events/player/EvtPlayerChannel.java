/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChannelEvent;

public class EvtPlayerChannel implements Listener {
    // Player Channel
    @EventHandler
    public void onPlayerChannel(PlayerChannelEvent event){
        RaftEvents.simpleEvent("on player channel", event.getPlayer(), event);
    }
}