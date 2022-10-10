/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player;

import me.abetgt.raft.RaftEvents;
import me.abetgt.raft.util.RaftDeprecation;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * AsyncPlayerChatEvent
 * @author AbeTGT
 */
public class EvtAsyncPlayerChatEvent implements Listener {
    @RaftDeprecation
    @EventHandler
    public void onBlockBreak(org.bukkit.event.player.AsyncPlayerChatEvent event){
        RaftEvents.simpleEvent("on player async chat", event.getPlayer(), event);
    }
}