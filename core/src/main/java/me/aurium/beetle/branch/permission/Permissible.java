package me.aurium.beetle.branch.permission;

public interface Permissible<T> {

    Permission<T> getPermission();

}
