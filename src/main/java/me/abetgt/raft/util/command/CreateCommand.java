package me.abetgt.raft.util.command;

import me.abetgt.raft.util.BetterLogger;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class CreateCommand extends BukkitCommand {
    // TODO: Fix Paper's deprecations
    public CreateCommand(String command) {
        super(command);
        setAliases(Arrays.asList(command));
        BetterLogger logger = new BetterLogger("", true);
        logger.log("Raft: Done create command " + command);
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        Player player = (Player) sender;
        if (!player.hasPermission(getPermission())) {
            player.sendMessage(getPermissionMessage());
            return true;
        }
        return true;
    }
}
