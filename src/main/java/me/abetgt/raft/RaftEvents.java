/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.util.ArrayList;

/**
 * RaftEvents is used to make the events (e.g on block break).
 * @author AbeTGT
 * @since 3/10/2022
 */
public class RaftEvents {
    static FileConfiguration config = Raft.getScriptConfig();

    static ArrayList<String> syntaxList = new ArrayList<>();

    /**
     * Calls an event manually.
     * {@link RaftEvents#addToEventArray(String)} needs to be called before.
     * For a more simpler option, try using {@link RaftEvents#simpleEvent(String, Player, Event)}
     * @see RaftEvents#addToEventArray(String)
     * @see RaftEvents#simpleEvent(String, Player, Event)
     * @param syntax The syntax to be used (e.g on block break)
     * @param player The player involved, null if there is none.
     * @param event The event in question.
     * @author AbeTGT
     * @since 3/10/2022 - 4/10/2022
     */
    public static void callEvent(String syntax, Player player, Event event){
        for (String t : syntaxList){
            if (syntax.equalsIgnoreCase(t) && config.contains(t)){
                RaftEffects.runEffects(player, t, event);
            }
        }
    }

    /**
     * Calls an event manually.
     * {@link RaftEvents#addToEventArray(String)} needs to be called before.
     * For a more simpler option, try using {@link RaftEvents#simpleEvent(String, Player, Event)}
     * @see RaftEvents#addToEventArray(String)
     * @see RaftEvents#simpleEvent(String, Player, Event)
     * @param syntaxes The array of syntaxes to be used (e.g on block break, on player riptide)
     * @param player The player involved, null if there is none.
     * @param event The event in question.
     * @author AbeTGT
     * @since 3/10/2022 - 4/10/2022
     */
    public static void callEvent(String[] syntaxes, Player player, Event event){
        for (String t : syntaxList){
            for (String i : syntaxes){
                if (i.equalsIgnoreCase(t) && config.contains(t)){
                    RaftEffects.runEffects(player, t, event);
                }
            }
        }
    }

    /**
     * Adds an event syntax to the event array list, and *technically* registers it.
     * {@link RaftEvents#callEvent(String, Player, Event)} needs to be called after.
     * @see RaftEvents#callEvent(String, Player, Event)
     * @see RaftEvents#simpleEvent(String, Player, Event)
     * @param stringToAdd The string to add to the array list.
     */
    public static void addToEventArray(String stringToAdd){
        if (!syntaxList.contains(stringToAdd)){
            syntaxList.add(stringToAdd);
        }
    }

    /**
     * Adds array event syntaxes to the event array list, and *technically* registers them.
     * {@link RaftEvents#callEvent(String, Player, Event)} needs to be called after.
     * @see RaftEvents#callEvent(String, Player, Event)
     * @see RaftEvents#simpleEvent(String[], Player, Event)
     * @param stringsToAdd The strings to add to the array list.
     */
    public static void addToEventArray(String[] stringsToAdd){
        for (String i : stringsToAdd){
            if (!syntaxList.contains(i)){
                syntaxList.add(i);
            }
        }
    }

    /**
     * Allows for making events easy. This is better to use.
     * Do not worry about adding anything to the event array - this will automatically be done and called.
     * @param syntax The syntax to be used (e.g on block break)
     * @param player The player involved, null if there is none.
     * @param event The event in question.
     * @author AbeTGT
     * @since 3/10/2022 - 4/10/2022
     * @see RaftEvents#callEvent(String, Player, Event)
     * @see RaftEvents#addToEventArray(String)
     */
    public static void simpleEvent(String syntax, Player player, Event event){
        addToEventArray(syntax);
        callEvent(syntax, player, event);
    }

    /**
     * Allows for making events easy. This is better to use.
     * Do not worry about adding anything to the event array - this will automatically be done and called.
     * @param syntaxes The syntaxes to be used (e.g on block break)
     * @param player The player involved, null if there is none.
     * @param event The event in question.
     * @author AbeTGT
     * @since 5/10/2022 - version 1.0
     * @see RaftEvents#callEvent(String, Player, Event)
     * @see RaftEvents#addToEventArray(String[])
     */
    public static void simpleEvent(String[] syntaxes, Player player, Event event){
        addToEventArray(syntaxes);
        callEvent(syntaxes, player, event);
    }
}