/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.events;

import io.papermc.paper.event.player.PlayerTradeEvent;
import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static me.abetgt.raft.util.RaftMisc.classExists;

/**
 * PaperEvents is used for specific Paper-only events.
 * If the server is running Spigot instead of Paper, these listeners will not be registered.
 * @author AbeTGT
 * @since 5/10/2022
 * @version 1.0
 */
public class PaperEvents implements Listener {
    @EventHandler
    public void onTrade(PlayerTradeEvent event){
        RaftEvents.simpleEvent("on player trade", event.getPlayer(), event);
    }
}
