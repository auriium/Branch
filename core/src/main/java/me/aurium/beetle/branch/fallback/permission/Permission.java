package me.aurium.beetle.branch.fallback.permission;

/**
 *
 */
public interface Permission<T> {

   boolean attempt(T sender, String alias, String[] args); //because fuck you

}
