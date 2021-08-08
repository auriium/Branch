package xyz.auriium.branch.base.execution;

import xyz.auriium.branch.base.EnhancedNodeContext;
import xyz.auriium.branch.nodes.argument.ArgumentContext;
import xyz.auriium.branch.nodes.argument.ArgumentContextHandler;
import xyz.auriium.branch.nodes.argument.Arguments;

public class ArgExecution<T> implements Execution<T> {

    private final ArgumentContextHandler<T> handler;
    private final EnhancedNodeContext<T> node;
    private final Arguments arguments;

    public ArgExecution(ArgumentContextHandler<T> handler, EnhancedNodeContext<T> node, Arguments arguments) {
        this.handler = handler;
        this.node = node;
        this.arguments = arguments;
    }


    @Override
    public void run() {
        handler.handle(new ArgumentContext<>(node, arguments));
    }

}
