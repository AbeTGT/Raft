/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemMendEvent;

public class EvtPlayerItemMend implements Listener {
    // Player Item Mend
    @EventHandler
    public void onItemMend(PlayerItemMendEvent event){
        RaftEvents.simpleEvent("on player mend item", event.getPlayer(), event);
    }
}