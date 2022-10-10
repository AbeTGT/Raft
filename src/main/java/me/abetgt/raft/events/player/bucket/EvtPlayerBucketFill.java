/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player.bucket;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;

public class EvtPlayerBucketFill implements Listener {
    // Player Bucket Fill
    @EventHandler
    public void onPlayerBucketFill(PlayerBucketFillEvent event){
        String[] syntaxes = {
                "on player fill with bucket",
                "on player bucket fill",
                "on player fill a bucket",
                "on player filled a bucket",
                "on player filling a bucket"
        };
        RaftEvents.simpleEvent(syntaxes, event.getPlayer(), event);
    }
}