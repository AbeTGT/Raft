/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft;

import me.abetgt.raft.util.RaftMisc;
import org.bukkit.entity.Player;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RaftReflection {

    HashMap<Class<?>, String> effectList = new HashMap<Class<?>, String>();
    ArrayList<Class<?>> effectQueueList = new ArrayList<Class<?>>();

    public void registerSpecificEffect(Class<?> c, String suffix){
        if (RaftMisc.methodExists(c, "onExecute")){
            if (!effectList.containsKey(c) || !effectList.containsValue(suffix)){
                effectList.put(c, suffix);
            }
        }
    }

    public void outerFunction(Object object, Method method, Player message, String event) throws Exception {
        Object[] parameters = new Object[2];
        parameters[0] = message;
        parameters[1] = event;
        method.invoke(object, parameters);
    }

    public void runSpecificEffect(Class<?> c, String suffix, Player player, String event) throws Exception {
        Class[] parameterTypes = new Class[1];
        for (Class<?> i : effectList.keySet()){
            if (effectList.get(i).equals(suffix)){
                parameterTypes[0] = i;
                RaftReflection main = new RaftReflection();
                main.outerFunction(main, i.getMethod("onExecute", parameterTypes[0]), player, event);
            }
        }
    }

    String packageName = getClass().getPackage().getName();

    public Set<Class> findAllClassesUsingReflectionsLibrary(String packageName) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        return new HashSet<>(reflections.getSubTypesOf(Object.class));
    }

    public void registerExecuteEffect(String suffix) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (suffix != null){
            for (Class<?> i : effectQueueList){
                registerSpecificEffect(i, suffix);
            }
        } else {
            for (Class<?> clazz : findAllClassesUsingReflectionsLibrary(packageName + "." + "effects")){
                if (RaftMisc.methodExists(clazz, "giveSyntax")){
                    Object method = clazz.getMethod("giveSyntax").invoke(clazz);
                    effectQueueList.add(clazz);
                }
            }
        }
    }
}