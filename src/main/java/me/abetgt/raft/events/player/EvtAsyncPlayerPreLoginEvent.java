package me.abetgt.raft.events.player;

import me.abetgt.raft.RaftEvents;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EvtAsyncPlayerPreLoginEvent implements Listener {
    // Async Player Pre Login
    @EventHandler
    public void onAsyncLogin(org.bukkit.event.player.AsyncPlayerPreLoginEvent event){
        RaftEvents.simpleEvent("on player async prelogin", null, event);
    }
}
