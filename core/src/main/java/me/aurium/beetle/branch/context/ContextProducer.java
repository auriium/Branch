package me.aurium.beetle.branch.context;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.nodes.CommandNode;

/**
 * Produces context adapters, like the stock ContextSource for contexts.
 */
public interface ContextProducer<T> {

    NodeContext<T> produce(T sender, String alias, String[] strings, CommandNode<T> executedNode, CommandNode<T> baseNode, BlockPath executedPath, BlockPath basePath);

    Context<T> produce(T sender, String alias, String[] strings);

}
