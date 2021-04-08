package me.aurium.beetle.branch.handlers.context;


import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;

public abstract class AbstractNodeContext<T> implements NodeContext<T> {

    private final T sender;
    private final String alias;
    private final String[] args;

    private final CommandNode<T> baseNode;
    private final SearchInfo<T> searchInfo;

    protected AbstractNodeContext(T sender, String alias, String[] args, CommandNode<T> baseNode, SearchInfo<T> result) {
        this.sender = sender;
        this.alias = alias;
        this.args = args;

        this.searchInfo = result;
        this.baseNode = baseNode;
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
    public CommandNode<T> getBaseExecutedNode() {
        return baseNode;
    }

    @Override
    public SearchInfo<T> getResults() {
        return searchInfo;
    }

}
