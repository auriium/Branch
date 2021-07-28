package xyz.auriium.branch.execution.api;

import xyz.auriium.branch.execution.NodeContext;

public class BasicExecution<T> implements Execution<T> {

    private final ExecutionHandler<T> handler;
    private final NodeContext<T> node;

    public BasicExecution(ExecutionHandler<T> handler, NodeContext<T> node) {
        this.handler = handler;
        this.node = node;
    }

    @Override
    public void run() {
        handler.handle(node);
    }

}
