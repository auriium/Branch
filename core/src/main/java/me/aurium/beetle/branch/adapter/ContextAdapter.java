package me.aurium.beetle.branch.adapter;

import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.IdentifiableNode;
import me.aurium.beetle.branch.block.BlockPath;

/**
 * cum eternal
 * @param <T> cum
 */
public interface ContextAdapter<T> {

    IdentifiableNode<T> getExecutedNode();
    CommandNode<T> getBaseExecutedNode();

    BlockPath executedPath();

    //adapter

    T getSender();
    String getAlias();
    String[] getArgs();
    void messageSender(String var1);

    boolean equals(Object var1);

}
