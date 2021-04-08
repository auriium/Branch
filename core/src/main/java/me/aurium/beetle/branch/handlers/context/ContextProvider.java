package me.aurium.beetle.branch.handlers.context;

import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;

/**
 * Produces context adapters, like the stock ContextSource for contexts.
 */
public interface ContextProvider<T> {

    NodeContext<T> produce(T sender, String alias, String[] strings, CommandNode<T> baseNode, SearchInfo<T> search);

}
