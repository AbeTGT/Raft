/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;

public class EvtPlayerAnimation implements Listener {
    // Player Animation
    @EventHandler
    public void onPlayerAnimation(PlayerAnimationEvent event){
        String[] syntaxes = {
                "on player animation",
                "on player animate"
        };
        RaftEvents.simpleEvent(syntaxes, event.getPlayer(), event);
    }
}