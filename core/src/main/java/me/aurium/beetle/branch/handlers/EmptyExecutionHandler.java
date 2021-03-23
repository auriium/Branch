package me.aurium.beetle.branch.handlers;

import me.aurium.beetle.branch.context.NodeContext;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;

public class EmptyExecutionHandler<T> implements ExecutionHandler<T> {
    @Override
    public void handle(NodeContext<T> adapter) {

    }
}
