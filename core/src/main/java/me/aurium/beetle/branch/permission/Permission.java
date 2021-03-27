package me.aurium.beetle.branch.permission;

/**
 *
 */
public interface Permission<T> {

   boolean attempt(T sender, String alias, String[] args); //because fuck you

}
