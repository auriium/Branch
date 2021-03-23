package me.aurium.beetle.branch.context;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.nodes.api.CommandNode;

/**
 * Produces context adapters, like the stock ContextSource for contexts.
 */
public interface ContextProducer<T> {

    NodeContext<T> produce(T t, String alias, String[] strings, CommandNode<T> executedNode, CommandNode<T> baseNode, BlockPath executedPath, BlockPath fullPath);

    Context<T> produce(T t, String alias, String[] strings);

}
