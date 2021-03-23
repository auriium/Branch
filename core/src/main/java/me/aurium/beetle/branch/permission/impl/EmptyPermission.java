package me.aurium.beetle.branch.permission.impl;

import me.aurium.beetle.branch.permission.Permission;

public class EmptyPermission<T> implements Permission<T> {

    @Override
    public boolean hasAccessToUse(T user) {
        return true;
    }

    @Override
    public boolean hasAccessToSee(T user) {
        return true;
    }

}
