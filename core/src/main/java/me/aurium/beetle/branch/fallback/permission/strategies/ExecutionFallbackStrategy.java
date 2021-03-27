package me.aurium.beetle.branch.fallback.permission.strategies;

import me.aurium.beetle.branch.handlers.context.ContextProducer;
import me.aurium.beetle.branch.handlers.api.FallbackHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;

public interface ExecutionFallbackStrategy<T> {


    void executeStrategy(T sender, String alias, String[] args, CommandNode<T> baseNode, FallbackHandler<T> fallback, ContextProducer<T> producer);



}
