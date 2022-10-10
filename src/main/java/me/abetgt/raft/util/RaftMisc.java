/**
 * This file is a part of Raft.
 * 2022 AbeTGT.
 * @author AbeTGT.
 */
package me.abetgt.raft.util;

import org.bukkit.GameMode;

import java.lang.reflect.Method;

public class RaftMisc {

    /**
    calculateGameMode() is used to determine the correct calculation for the number of a game mode.
     @author AbeTGT
    @since 3/10/2022 10:03pm
     */
    public static GameMode calculateGameMode(int mode){
        if (mode == 0) {return GameMode.SURVIVAL;}
        else if (mode == 1) {return GameMode.CREATIVE;}
        else if (mode == 2) {return GameMode.ADVENTURE;}
        else if (mode == 3) {return GameMode.SPECTATOR;}
        return GameMode.SURVIVAL;
    }

    // From Skript
    /**
     * Tests whether a method exists in the given class.
     *
     * @param c The class
     * @param methodName The name of the method
     * @param parameterTypes The parameter types of the method
     * @return Whether the given method exists.
     */
    public static boolean methodExists(final Class<?> c, final String methodName, final Class<?>... parameterTypes) {
        try {
            c.getDeclaredMethod(methodName, parameterTypes);
            return true;
        } catch (final NoSuchMethodException | SecurityException e) {
            return false;
        }
    }

    /**
     * Tests whether a method exists in the given class, and whether the return type matches the expected one.
     * <p>
     * Note that this method doesn't work properly if multiple methods with the same name and parameters exist but have different return types.
     *
     * @param c The class
     * @param methodName The name of the method
     * @param parameterTypes The parameter types of the method
     * @param returnType The expected return type
     * @return Whether the given method exists.
     */
    public static boolean methodExists(final Class<?> c, final String methodName, final Class<?>[] parameterTypes, final Class<?> returnType) {
        try {
            final Method m = c.getDeclaredMethod(methodName, parameterTypes);
            return m.getReturnType() == returnType;
        } catch (final NoSuchMethodException | SecurityException e) {
            return false;
        }
    }

    /**
     * Tests whether a given class exists in the classpath.
     *
     * @param className The {@link Class#getCanonicalName() canonical name} of the class
     * @return Whether the given class exists.
     */
    public static boolean classExists(final String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException exception) {
            return false;
        }
    }

    // Raft start
    /**
     * Tests whether a given class exists in the classpath.
     *
     * @param classNames The {@link Class#getCanonicalName() canonical name} of the class
     * @return Whether the given class exists.
     */
    public static boolean classExistsArray(final String[] classNames) {
        try {
            for (String c : classNames){
                Class.forName(c);
                return true;
            }
        } catch (ClassNotFoundException exception) {
            return false;
        }
        return false;
    }
    // Raft end
}