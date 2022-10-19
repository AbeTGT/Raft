package me.abetgt.raft.util.command;

import me.abetgt.raft.Raft;
import me.abetgt.raft.util.BetterLogger;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.defaults.BukkitCommand;

import java.lang.reflect.Field;

public class RegisterCommand {

    BetterLogger logger = new BetterLogger("", true);

    public void registerCommands(String command) {
        registerCommand(command, new CreateCommand(command));
        Raft.getCommandArray().add(command);
        logger.log("Raft: Done registering");
    }

    private void registerCommand(String fallback, BukkitCommand command) {
        try {
            Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
            boolean register = commandMap.register(fallback, command);
            if (!register) logger.log("Failed to register Raft Command");
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
    }
}