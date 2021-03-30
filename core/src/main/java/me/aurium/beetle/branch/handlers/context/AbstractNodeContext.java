package me.aurium.beetle.branch.handlers.context;

import me.aurium.beetle.branch.fallback.message.BaseContext;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;

public abstract class AbstractNodeContext<T> extends AbstractContext<T> implements NodeContext<T> {

    private final CommandNode<T> baseNode;
    private final SearchInfo<T> searchInfo;
    private final BaseContext<T> baseContext;

    protected AbstractNodeContext(T t, String alias, String[] strings, CommandNode<T> baseNode, SearchInfo<T> result, BaseContext<T> baseContext) {
        super(t, alias, strings);

        this.baseContext = baseContext;
        this.searchInfo = result;
        this.baseNode = baseNode;
    }

    @Override
    public CommandNode<T> getBaseExecutedNode() {
        return baseNode;
    }

    @Override
    public SearchInfo<T> getResults() {
        return searchInfo;
    }

    @Override
    public BaseContext<T> getBaseContext() {
        return baseContext;
    }
}
