package xyz.auriium.branch.base.execution;

import xyz.auriium.branch.base.EnhancedNodeContext;

public class BasicExecution<T> implements Execution<T> {

    private final ExecutionHandler<T> handler;
    private final EnhancedNodeContext<T> node;

    public BasicExecution(ExecutionHandler<T> handler, EnhancedNodeContext<T> node) {
        this.handler = handler;
        this.node = node;
    }

    @Override
    public void run() {
        handler.handle(node);
    }

}
