package xyz.auriium.branch.nodes.single.impl;

import xyz.auriium.branch.base.NodeContext;
import xyz.auriium.branch.base.execution.ExecutionHandler;
import xyz.auriium.branch.nodes.single.AbstractSingleNode;

public abstract class ImplementableSingleNode<T> extends AbstractSingleNode<T> {

    protected ExecutionHandler<T> getHandler() {
        return this::onExecution;
    }

    abstract void onExecution(NodeContext<T> context);



}
