package me.aurium.beetle.branch.handlers.context;

import me.aurium.beetle.branch.fallback.message.BaseContext;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;

/**
 * Produces context adapters, like the stock ContextSource for contexts.
 */
public interface ContextProducer<T> {

    NodeContext<T> produce(T sender, String alias, String[] strings, CommandNode<T> baseNode, SearchInfo<T> search, BaseContext<T> baseContext);

    Context<T> produce(T sender, String alias, String[] strings);

}
