/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player.bucket.entity;

import me.abetgt.raft.RaftEvents;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEntityEvent;

public class EvtPlayerBucketAxolotl implements Listener {
    // Player Bucket
    @EventHandler
    public void onPlayerBucket(PlayerBucketEntityEvent event){
        if (event.getEntity().getType() != EntityType.AXOLOTL) return;
        String[] syntaxes = {
                "on player axolotl with bucket",
                "on player bucket interact with axolotl",
                "on player use a bucket",
                "on player fill a bucket with axolotl",
                "on player fill a bucket with an axolotl"
        };
        RaftEvents.simpleEvent(syntaxes, event.getPlayer(), event);
    }
}