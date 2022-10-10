/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events.player.bucket;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class EvtPlayerBucketEmpty implements Listener {
    // Player Bucket Empty
    @EventHandler
    public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event){
        RaftEvents.simpleEvent("on player empty bucket", event.getPlayer(), event);
    }
}