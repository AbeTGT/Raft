/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.effects;

import me.abetgt.raft.Raft;
import me.abetgt.raft.RaftReflection;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * This is an effect by class.
 */
public class EffExecuteConsole implements Listener {

    FileConfiguration config = Raft.getScriptConfig();
    String syntax = "execute player command";

    public void giveSyntax(Class classChosen) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        RaftReflection raftReflection = new RaftReflection();
        raftReflection.registerExecuteEffect(syntax);
    }

    public void onExecute(Player ifPlayer, String c){
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), Objects.requireNonNull(config.getString(c + "execute console command")));
    }
}
