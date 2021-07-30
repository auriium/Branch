package xyz.auriium.branch.nodes.single.implement;

import xyz.auriium.branch.execution.blocks.EndpointBlock;
import xyz.auriium.branch.fallback.permissions.EmptyPermission;
import xyz.auriium.branch.fallback.permissions.Permission;

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
