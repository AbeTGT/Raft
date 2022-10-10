/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class PlayerBedEvents implements Listener {
    // Player Bed Enter
    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event){
        RaftEvents.simpleEvent("on player enter bed", event.getPlayer(), event);
    }
    // Player Bed Leave
    @EventHandler
    public void onPlayerBedLeave(PlayerBedLeaveEvent event){
        RaftEvents.simpleEvent("on player leave bed", event.getPlayer(), event);
    }
}
