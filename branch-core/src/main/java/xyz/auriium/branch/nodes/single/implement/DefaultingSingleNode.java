package xyz.auriium.branch.nodes.single.implement;

import xyz.auriium.branch.execution.Block;
import xyz.auriium.branch.execution.StringBlock;
import xyz.auriium.branch.fallback.permissions.EmptyPermission;
import xyz.auriium.branch.fallback.permissions.Permission;
import xyz.auriium.branch.nodes.single.implement.ImplementableSingleNode;

public abstract class DefaultingSingleNode<T> extends ImplementableSingleNode<T> {

    @Override
    public Permission<T> getPermission() {
        return new EmptyPermission<>();
    }

    @Override
    public Block getIdentifier() {
        return StringBlock.of(getName());
    }

    abstract String getName();
}
