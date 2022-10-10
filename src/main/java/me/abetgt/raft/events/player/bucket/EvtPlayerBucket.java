/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player.bucket;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEvent;

public class EvtPlayerBucket implements Listener {
    // Player Bucket
    @EventHandler
    public void onPlayerBucket(PlayerBucketEvent event){
        String[] syntaxes = {
                "on player interact with bucket",
                "on player bucket interact",
                "on player use a bucket",
                "on player bucket interaction",
                "on player interaction with bucket"
        };
        RaftEvents.simpleEvent(syntaxes, event.getPlayer(), event);
    }
}