/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class EvtPlayerArmorStandManipulate implements Listener {
    // Player Armor Stand Manipulate
    @EventHandler
    public void onPlayerArmorStandManipulate(PlayerArmorStandManipulateEvent event){
        RaftEvents.simpleEvent("on player manipulate armor stand", event.getPlayer(), event);
    }
}