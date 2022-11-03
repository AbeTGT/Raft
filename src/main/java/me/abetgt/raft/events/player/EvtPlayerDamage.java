package me.abetgt.raft.events.player;

import me.abetgt.raft.RaftEvents;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EvtPlayerDamage implements Listener {
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event){
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        String[] syntax = {
                "on player damage",
                "on player take damage"
        };
        RaftEvents.simpleEvent(syntax, player, event);
    }
}
