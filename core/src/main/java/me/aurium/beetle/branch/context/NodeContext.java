package me.aurium.beetle.branch.context;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.nodes.api.CommandNode;


public interface NodeContext<T> extends Context<T> {

    CommandNode<T> getExecutedNode();
    CommandNode<T> getBaseExecutedNode();

    BlockPath executedPath();
    BlockPath fullPath();

    boolean equals(Object comparison);

}
