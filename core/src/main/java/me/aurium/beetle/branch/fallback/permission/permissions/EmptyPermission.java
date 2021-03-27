package me.aurium.beetle.branch.fallback.permission.permissions;

import me.aurium.beetle.branch.fallback.permission.Permission;

public class EmptyPermission<T> implements Permission<T> {

    @Override
    public boolean attempt(T sender, String alias, String[] args) {
        return true;
    }
}
