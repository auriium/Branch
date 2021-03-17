package me.aurium.beetle.branch.adapter;

import me.aurium.beetle.api.command.Context;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.block.BlockPath;

/**
 * cum eternal
 * @param <T> cum
 */
public interface ContextAdapter<T> {

    CommandNode<T> getExecutedNode();
    CommandNode<T> getBaseExecutedNode();

    BlockPath executedPath();

    //adapter

    T getSender();
    String getAlias();
    String[] getArgs();
    void debugString(String var1);

    boolean equals(Object var1);

}
