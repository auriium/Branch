package me.aurium.beetle.branch.permission;

/**
 * Representing something that you can have that determines the accessibility of a command
 */
public interface Permission<T> {

    boolean hasAccessToUse(T user);
    boolean hasAccessToSee(T user);

}
