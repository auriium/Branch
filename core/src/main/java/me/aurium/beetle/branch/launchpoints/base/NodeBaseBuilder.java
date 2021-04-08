package me.aurium.beetle.branch.launchpoints.base;

import me.aurium.beetle.branch.fallback.strategies.OneBackStrategy;
import me.aurium.beetle.branch.handlers.context.ContextProvider;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.fallback.strategies.FallbackSearchStrategy;

public class NodeBaseBuilder<T> {

    private ContextProvider<T> producer;

    private CommandNode<T> base;
    private FallbackSearchStrategy<T> strategy = new OneBackStrategy<>();

    public NodeBaseBuilder<T> withBaseNode(CommandNode<T> node) {
        this.base = node;

        return this;
    }

    public NodeBaseBuilder<T> withStrategy(FallbackSearchStrategy<T> strategy) {
        this.strategy = strategy;

        return this;
    }

}
