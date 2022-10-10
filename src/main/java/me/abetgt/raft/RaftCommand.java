package me.abetgt.raft;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * RaftCommand is used to make the "/raft (reload|info)" command.
 * @author AbeTGT
 * @since 3/10/2022
 */
public class RaftCommand implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length > 0){
                if (args[0].equalsIgnoreCase("reload")) {
                    RaftConfig.reload(player);
                } else if (args[0].equalsIgnoreCase("info")){
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lRaft >> &rMade by AbeTGT, created 3/10/2022, message made 9:19pm"));
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lRaft >> &rInvalid argument."));
                }
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lRaft >> &rPlease provide an existing argument."));
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args){
        List<String> list = Arrays.asList("reload", "info");
        String input = args[0].toLowerCase();

        List<String> completions = null;
        for (String s: list){
            if(s.startsWith(input)){
                if (completions == null){
                    completions = new ArrayList();
                }
                completions.add(s);
            }
        }
        if (completions != null) Collections.sort(completions);
        return completions;
    }
}
