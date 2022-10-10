/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRiptideEvent;

public class EvtPlayerRiptide implements Listener {
    // Player Riptide
    @EventHandler
    public void onPlayerRiptide(PlayerRiptideEvent event){
        RaftEvents.simpleEvent("on player riptide", event.getPlayer(), event);
    }
}