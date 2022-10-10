/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.block;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

public class EvtBlockDispense implements Listener {
    // Block Dispense
    @EventHandler
    public void onBlockBreak(BlockDispenseEvent event){
        RaftEvents.simpleEvent("on block dispense", null, event);
    }
}