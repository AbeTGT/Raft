/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class EvtPlayerCommand implements Listener {
    // Player Command
    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event){
        RaftEvents.simpleEvent("on player command", event.getPlayer(), event);
    }
}