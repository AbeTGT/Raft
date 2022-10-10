/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player.world;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class EvtPlayerChangeWorld implements Listener {
    // Player Changed World
    @EventHandler
    public void onPlayerChangeWorld(PlayerChangedWorldEvent event){
        String[] syntaxes = {
                "on player change world",
                "on player changing world",
                "on player world change",
        };
        RaftEvents.simpleEvent(syntaxes, event.getPlayer(), event);
    }
}