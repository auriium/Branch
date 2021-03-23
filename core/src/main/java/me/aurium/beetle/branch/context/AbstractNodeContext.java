package me.aurium.beetle.branch.context;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.nodes.api.CommandNode;

public abstract class AbstractNodeContext<T> extends AbstractContext<T> implements NodeContext<T> {

    private final CommandNode<T> executed;
    private final CommandNode<T> base;
    private final BlockPath path;

    protected AbstractNodeContext(T t, String alias, String[] args, CommandNode<T> executed, CommandNode<T> base, BlockPath path) {
        super(t, alias, args);
        this.executed = executed;
        this.base = base;
        this.path = path;
    }

    @Override
    public CommandNode<T> getExecutedNode() {
        return executed;
    }

    @Override
    public CommandNode<T> getBaseExecutedNode() {
        return base;
    }

    @Override
    public BlockPath executedPath() {
        return path;
    }
}
