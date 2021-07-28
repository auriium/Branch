package xyz.auriium.branch.nodes.single.implement;

import xyz.auriium.branch.execution.NodeContext;
import xyz.auriium.branch.execution.api.ExecutionHandler;
import xyz.auriium.branch.nodes.single.AbstractSingleNode;

public abstract class ImplementableSingleNode<T> extends AbstractSingleNode<T> {

    protected ExecutionHandler<T> getHandler() {
        return this::onExecution;
    }

    abstract void onExecution(NodeContext<T> context);



}
