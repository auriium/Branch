package me.aurium.beetle.branch.handlers.context;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.handlers.api.FallbackHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;

public abstract class AbstractNodeContext<T> extends AbstractContext<T> implements NodeContext<T> {

    private final CommandNode<T> executed;
    private final CommandNode<T> base;
    private final BlockPath executedPath;
    private final BlockPath fullPath;
    private final FallbackHandler<T> handler;

    protected AbstractNodeContext(T t, String alias, String[] strings, CommandNode<T> executedNode, CommandNode<T> baseNode, BlockPath executedPath, BlockPath basePath, FallbackHandler<T> handler) {
        super(t, alias, strings);
        this.executed = executedNode;
        this.base = baseNode;
        this.executedPath = executedPath;
        this.fullPath = basePath;
        this.handler = handler;
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
        return executedPath;
    }

    @Override
    public BlockPath fullPath() {
        return fullPath;
    }

    @Override
    public FallbackHandler<T> getFallbackAction() {
        return handler;
    }

}
