package me.aurium.beetle.branch.permission;

/**
 * Representing something that you can have that determines the accessibility of a command
 */
public interface PermAccessor<T> {

    boolean hasAccessToUse(T user, Permission permission);
    boolean hasAccessToSee(T user, Permission permission);

}
