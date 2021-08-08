package xyz.auriium.branch.nodes.argument.impl;

import xyz.auriium.branch.nodes.argument.AbstractArgNode;
import xyz.auriium.branch.nodes.argument.ArgumentContext;
import xyz.auriium.branch.nodes.argument.ArgumentContextHandler;

public abstract class ImplementableArgNode<T> extends AbstractArgNode<T> {

    @Override
    protected ArgumentContextHandler<T> getContextHandler() {
        return this::onExecution;
    }

    /**
     * Method representing the execution of the node
     * @param context pojo representing arguments + default context
     */
    abstract void onExecution(ArgumentContext<T> context);
}
