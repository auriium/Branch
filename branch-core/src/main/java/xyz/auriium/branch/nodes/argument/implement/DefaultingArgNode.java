package xyz.auriium.branch.nodes.argument.implement;

import xyz.auriium.branch.fallback.permissions.EmptyPermission;
import xyz.auriium.branch.fallback.permissions.Permission;

public abstract class DefaultingArgNode<T> extends ImplementableArgNode<T> {

    @Override
    public Permission<T> getPermission() {
        return new EmptyPermission<>();
    }

}
