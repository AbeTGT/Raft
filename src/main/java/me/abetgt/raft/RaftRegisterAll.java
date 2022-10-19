/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft;

import me.abetgt.raft.custom.BetterRTP.events.EvtRTPTeleportPostEvent;
import me.abetgt.raft.events.PaperEvents;
import me.abetgt.raft.events.block.*;
import me.abetgt.raft.events.player.*;
import me.abetgt.raft.events.player.bucket.EvtPlayerBucketFill;
import me.abetgt.raft.events.player.bucket.entity.EvtPlayerBucketAxolotl;
import me.abetgt.raft.events.player.world.EvtPlayerChangeWorld;
import me.abetgt.raft.util.RaftMisc;
import org.bukkit.Bukkit;

public class RaftRegisterAll {
    static Raft raftInstance = Raft.getRaftInstance();

    static String bukkitPlayerString = "org.bukkit.event.player.";
    static int registeredListeners = 0;

    // All the classes get registered here.

    // TODO: Rewrite this system and make it more efficient
    public static int registerClasses(){

        // Player Related Events

        // Bed Events
        String[] bedEvents = {bukkitPlayerString + "PlayerBedEnterEvent", bukkitPlayerString + "PlayerBedLeaveEvent"};
        if (RaftMisc.classExistsArray(bedEvents)){
            Bukkit.getServer().getPluginManager().registerEvents(new PlayerBedEvents(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Player Interact Event
        if (RaftMisc.classExists("org.bukkit.event.player.PlayerInteractEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtPlayerInteractEvent(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Player Async Chat
        if (RaftMisc.classExists("org.bukkit.event.player.AsyncPlayerChatEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtAsyncPlayerChatEvent(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Player Async Pre Login
        if (RaftMisc.classExists("org.bukkit.event.player.AsyncPlayerPreLoginEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtAsyncPlayerPreLoginEvent(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Player Animation
        if (RaftMisc.classExists("org.bukkit.event.player.PlayerAnimationEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtPlayerAnimation(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Player Bucket Empty
        if (RaftMisc.classExists("org.bukkit.event.player.PlayerArmorStandManipulateEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtPlayerArmorStandManipulate(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Player Bucket
        //if (RaftMisc.classExists("org.bukkit.event.player.PlayerBucketEvent")){
            //Bukkit.getServer().getPluginManager().registerEvents(new EvtPlayerBucket(), raftInstance);
        //}

        // Player Bucket Fill
        if (RaftMisc.classExists("org.bukkit.event.player.PlayerBucketFillEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtPlayerBucketFill(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Player Change World
        if (RaftMisc.classExists("org.bukkit.event.player.PlayerChangedWorldEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtPlayerChangeWorld(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Player Channel
        if (RaftMisc.classExists("org.bukkit.event.player.PlayerChannelEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtPlayerChannel(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Player Command
        if (RaftMisc.classExists("org.bukkit.event.player.PlayerCommandPreprocessEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtPlayerCommand(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Player Item Mending
        if (RaftMisc.classExists("org.bukkit.event.player.PlayerItemMendEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtPlayerItemMend(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Player Join
        if (RaftMisc.classExists("org.bukkit.event.player.PlayerJoinEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtPlayerJoin(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Player Quit
        if (RaftMisc.classExists("org.bukkit.event.player.PlayerQuitEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtPlayerQuit(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Player Riptide
        if (RaftMisc.classExists("org.bukkit.event.player.PlayerRiptideEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtPlayerRiptide(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Player Damage
        if (RaftMisc.classExists("org.bukkit.event.entity.EntityDamageEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtPlayerDamage(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Block Related Events

        // Block Break
        if (RaftMisc.classExists("org.bukkit.event.block.BlockBreakEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtBlockBreak(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Block Place
        if (RaftMisc.classExists("org.bukkit.event.block.BlockPlaceEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtBlockPlace(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Block Dispense
        if (RaftMisc.classExists("org.bukkit.event.block.BlockDispenseEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtBlockDispense(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // Entity Related Events

        // Player Bucket Axolotl
        if (RaftMisc.classExists("org.bukkit.event.player.PlayerBucketEntityEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtPlayerBucketAxolotl(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        // BetterRTP

        // Player Post Teleport
        if (RaftMisc.classExists("me.SuperRonanCraft.BetterRTP.references.customEvents.RTP_TeleportPostEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new EvtRTPTeleportPostEvent(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        if (RaftMisc.classExists("io.papermc.paper.event.player.PlayerTradeEvent")){
            Bukkit.getServer().getPluginManager().registerEvents(new PaperEvents(), raftInstance);
            registeredListeners = registeredListeners + 1;
        }

        return registeredListeners;
    }
}