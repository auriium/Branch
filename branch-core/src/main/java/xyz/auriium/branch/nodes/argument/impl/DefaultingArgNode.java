package xyz.auriium.branch.nodes.argument.impl;

import xyz.auriium.branch.base.permissions.EmptyPermission;
import xyz.auriium.branch.base.permissions.Permission;

public abstract class DefaultingArgNode<T> extends ImplementableArgNode<T> {

    @Override
    public Permission<T> getPermission() {
        return EmptyPermission.instance();
    }

}
