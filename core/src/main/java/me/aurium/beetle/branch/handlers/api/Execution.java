package me.aurium.beetle.branch.handlers.api;

import me.aurium.beetle.branch.handlers.context.NodeContext;

public class Execution<T> implements Runnable {

    private final ExecutionHandler<T> handler;
    private final NodeContext<T> node;

    public Execution(ExecutionHandler<T> handler, NodeContext<T> node) {
        this.handler = handler;
        this.node = node;
    }

    @Override
    public void run() {
        handler.handle(node);
    }
}
