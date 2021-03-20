package me.aurium.beetle.branch.adapter;

import me.aurium.beetle.api.command.Context;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.IdentifiableNode;
import me.aurium.beetle.branch.block.BlockPath;

public class ContextWrapper<T> implements ContextAdapter<T> {

    private final Context<T> context;
    private final IdentifiableNode<T> executedNode;
    private final CommandNode<T> baseNode;
    private final BlockPath executedPath;

    public ContextWrapper(Context<T> context, IdentifiableNode<T> executedNode, CommandNode<T> baseNode, BlockPath executedPath) {
        this.context = context;
        this.executedNode = executedNode;
        this.baseNode = baseNode;
        this.executedPath = executedPath;
    }

    @Override
    public IdentifiableNode<T> getExecutedNode() {
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
    public T getSender() {
        return context.getSender();
    }

    @Override
    public String getAlias() {
        return context.getAlias();
    }

    @Override
    public String[] getArgs() {
        return context.getArgs();
    }

    @Override
    public void messageSender(String var1) {
        context.debugString(var1);
    }
}
