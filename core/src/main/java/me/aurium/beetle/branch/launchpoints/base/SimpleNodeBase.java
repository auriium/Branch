package me.aurium.beetle.branch.launchpoints.base;

import me.aurium.beetle.branch.handlers.context.ContextProducer;
import me.aurium.beetle.branch.handlers.api.FallbackHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.fallback.permission.strategies.ExecutionFallbackStrategy;

import java.util.List;

public class SimpleNodeBase<C> implements NodeBase<C> {

    private final CommandNode<C> baseNode;
    private final ContextProducer<C> factory;

    private final FallbackHandler<C> fallbackHandler;
    private final ExecutionFallbackStrategy<C> strategy;

    public <X> SimpleNodeBase(CommandNode<C> baseNode, ContextProducer<C> factory, FallbackHandler<C> fallbackHandler, ExecutionFallbackStrategy<C> strategy) {

        this.baseNode = baseNode;
        this.factory = factory;
        this.fallbackHandler = fallbackHandler;
        this.strategy = strategy;
    }

    @Override
    public void execute(C executor, String alias, String[] args) {
        strategy.executeStrategy(executor,alias,args,baseNode, fallbackHandler,factory);
    }

    @Override
    public List<String> suggest(C c, String alias, String[] args) {
        return null;
    }
}
