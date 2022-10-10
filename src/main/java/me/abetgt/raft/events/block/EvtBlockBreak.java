/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.block;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class EvtBlockBreak implements Listener {
    // Block Break
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        RaftEvents.simpleEvent("on block break", event.getPlayer(), event);
    }
}