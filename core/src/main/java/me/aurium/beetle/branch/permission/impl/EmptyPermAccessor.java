package me.aurium.beetle.branch.permission.impl;

import me.aurium.beetle.branch.permission.PermAccessor;
import me.aurium.beetle.branch.permission.Permission;

public class EmptyPermAccessor<T> implements PermAccessor<T> {

    @Override
    public boolean hasAccessToUse(T user, Permission permission) {
        return true;
    }

    @Override
    public boolean hasAccessToSee(T user, Permission permission) {
        return true;
    }
}
