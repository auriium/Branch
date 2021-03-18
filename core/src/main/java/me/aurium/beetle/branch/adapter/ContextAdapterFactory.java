package me.aurium.beetle.branch.adapter;

import me.aurium.beetle.api.command.Context;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.IdentifiableNode;
import me.aurium.beetle.branch.block.BlockPath;

/**
 * Produces context adapters, like the stock ContextSource for contexts.
 */
public interface ContextAdapterFactory<T> {

    ContextAdapter<T> produce(T t, String alias, String[] strings, IdentifiableNode<T> executedNode, CommandNode<T> baseNode, BlockPath path);
    Context<T> context(T t, String alias, String[] strings);

}
