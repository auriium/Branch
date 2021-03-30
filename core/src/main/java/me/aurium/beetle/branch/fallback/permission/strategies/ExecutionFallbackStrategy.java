package me.aurium.beetle.branch.fallback.permission.strategies;

import me.aurium.beetle.branch.fallback.message.BaseContext;
import me.aurium.beetle.branch.handlers.context.ContextProducer;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;

import java.util.Optional;

public interface ExecutionFallbackStrategy<T> {


    Optional<SearchInfo<T>> attemptPreprocess(T sender, String alias, String[] args, CommandNode<T> baseNode);
    void attemptExecution(T sender, String alias, String[] args, CommandNode<T> baseNode, SearchInfo<T> result, BaseContext<T> baseContext, ContextProducer<T> producer);



}
