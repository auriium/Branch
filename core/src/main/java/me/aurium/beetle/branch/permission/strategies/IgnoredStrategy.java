package me.aurium.beetle.branch.permission.strategies;

import me.aurium.beetle.branch.context.StagedContext;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.permission.FallbackStrategy;

public class IgnoredStrategy<T> implements FallbackStrategy<T> {

    @Override
    public ExecutionHandler<T> strategy(StagedContext<T> stagedContext) {
        return stagedContext.getExecutedNode().getExecutionHandler();
    }
}
