package me.aurium.beetle.branch.context;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.nodes.api.CommandNode;


public interface NodeContext<T> extends Context<T> {

    CommandNode<T> getExecutedNode();
    CommandNode<T> getBaseExecutedNode();

    BlockPath executedPath();
    BlockPath fullPath();

    boolean equals(Object comparison);

    //TODO add more cool features like the debug message sender,
    // because NodeContext should be a collection of both context and context-specific actions? /review a248

}
