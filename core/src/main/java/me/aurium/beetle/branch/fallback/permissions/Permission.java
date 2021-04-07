package me.aurium.beetle.branch.fallback.permissions;

/**
 *
 */
public interface Permission<T> {

   boolean attempt(T sender, String alias, String[] args); //because fuck you

   String easyName();

}
