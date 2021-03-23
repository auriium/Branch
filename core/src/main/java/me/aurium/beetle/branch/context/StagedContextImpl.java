package me.aurium.beetle.branch.context;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.handlers.api.FallbackHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;

public class StagedContextImpl<T> implements StagedContext<T> {

    private final T sender;
    private final String alias;
    private final String[] args;
    private final CommandNode<T> executedNode;
    private final CommandNode<T> baseNode;
    private final BlockPath executedPath;
    private final BlockPath basePath;
    private final FallbackHandler<T> fallbackHandler;

    public StagedContextImpl(T sender, String alias, String[] args, CommandNode<T> executedNode, CommandNode<T> baseNode, BlockPath executedPath, BlockPath basePath, FallbackHandler<T> fallbackHandler) {
        this.sender = sender;
        this.alias = alias;
        this.args = args;
        this.executedNode = executedNode;
        this.baseNode = baseNode;
        this.executedPath = executedPath;
        this.basePath = basePath;
        this.fallbackHandler = fallbackHandler;
    }

    @Override
    public T getSender() {
        return sender;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public String[] getArgs() {
        return args;
    }

    @Override
    public CommandNode<T> getExecutedNode() {
        return executedNode;
    }

    @Override
    public CommandNode<T> getBaseExecutedNode() {
        return baseNode;
    }

    @Override
    public BlockPath executedPath() {
        return executedPath;
    }

    @Override
    public BlockPath fullPath() {
        return basePath;
    }

    @Override
    public NodeContext<T> stage(ContextProducer<T> producer) {
        return producer.produce(sender,alias,args,executedNode,baseNode,executedPath,basePath);
    }

    @Override
    public FallbackHandler<T> getFallbackAction() {
        return fallbackHandler;
    }
}
