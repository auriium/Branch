package xyz.auriium.branch.nodes.single.impl;

import xyz.auriium.branch.base.execution.blocks.EndpointBlock;
import xyz.auriium.branch.base.permissions.EmptyPermission;
import xyz.auriium.branch.base.permissions.Permission;

public abstract class DefaultingSingleNode<T> extends ImplementableSingleNode<T> {

    @Override
    public Permission<T> getPermission() {
        return EmptyPermission.instance();
    }

    @Override
    public EndpointBlock getIdentifier() {
        return new EndpointBlock(getName());
    }

    abstract String getName();
}
