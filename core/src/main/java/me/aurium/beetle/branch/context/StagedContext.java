package me.aurium.beetle.branch.context;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.handlers.api.FallbackHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;

/**
 * Something like a nodecontext that hasn't been activated yet
 */
public interface StagedContext<T> {

    T getSender();
    String getAlias();
    String[] getArgs();

    CommandNode<T> getExecutedNode();
    CommandNode<T> getBaseExecutedNode();

    BlockPath executedPath();
    BlockPath fullPath();

    boolean equals(Object comparison);

    NodeContext<T> stage(ContextProducer<T> producer);

    FallbackHandler<T> getFallbackAction();

}
