/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.custom.BetterRTP.events;

import me.SuperRonanCraft.BetterRTP.references.customEvents.RTP_TeleportPostEvent;
import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Called after a player has teleported.
 */
public class EvtRTPTeleportPostEvent implements Listener {
    @EventHandler
    public void onPlayerPostTeleport(RTP_TeleportPostEvent event){
        String[] syntaxes = {
                "on player post teleport with BetterRTP",
                "on player teleport after with BetterRTP",
                "on player teleport post with BetterRTP",
                "on player after teleport with BetterRTP"
        };
        RaftEvents.simpleEvent(syntaxes, event.getPlayer(), event);
    }
}