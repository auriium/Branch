package me.aurium.beetle.branch.nodes.argument;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.context.NodeContext;
import me.aurium.beetle.branch.nodes.api.CommandNode;

public class DelegatingArgumentContext<T> implements ArgumentContext<T>{

    private final NodeContext<T> delegate;
    private final Arguments arguments;

    public DelegatingArgumentContext(NodeContext<T> delegate, Arguments arguments) {
        this.delegate = delegate;
        this.arguments = arguments;
    }

    @Override
    public T getSender() {
        return delegate.getSender();
    }

    @Override
    public String getAlias() {
        return delegate.getAlias();
    }

    @Override
    public String[] getArgs() {
        return delegate.getArgs();
    }

    @Override
    public void messageSender(String string) {
        delegate.messageSender(string);
    }

    @Override
    public CommandNode<T> getExecutedNode() {
        return delegate.getExecutedNode();
    }

    @Override
    public CommandNode<T> getBaseExecutedNode() {
        return delegate.getBaseExecutedNode();
    }

    @Override
    public BlockPath executedPath() {
        return delegate.executedPath();
    }

    @Override
    public Arguments getArgumentContainer() {
        return arguments;
    }
}
