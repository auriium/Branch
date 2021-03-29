package me.aurium.beetle.branch.handlers.context;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.handlers.api.FallbackHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;

/**
 * Produces context adapters, like the stock ContextSource for contexts.
 */
public interface ContextProducer<T> {

    NodeContext<T> produce(T sender, String alias, String[] strings, CommandNode<T> executedNode, CommandNode<T> baseNode, BlockPath executedPath, BlockPath basePath, FallbackHandler<T> handler);

    Context<T> produce(T sender, String alias, String[] strings);

}
