package me.aurium.beetle.branch.handlers.api;

import me.aurium.beetle.branch.context.NodeContext;

public interface ExecutionHandler<T> {

    void handle(NodeContext<T> adapter);

}
