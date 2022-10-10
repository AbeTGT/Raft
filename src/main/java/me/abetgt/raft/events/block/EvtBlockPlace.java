/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.block;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class EvtBlockPlace implements Listener {
    // Block Place
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        RaftEvents.simpleEvent("on block place", event.getPlayer(), event);
    }
}