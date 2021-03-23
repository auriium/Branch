package me.aurium.beetle.branch.permission.strategies;

import me.aurium.beetle.branch.context.StagedContext;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.permission.FallbackStrategy;

/**
 * Falls back to the at-execution-time parent node
 */
public class FallbackOneStrategy<T> implements FallbackStrategy<T> {

    @Override
    public ExecutionHandler<T> strategy(StagedContext<T> stagedContext) {

        CommandNode<T> toBeExecuted = stagedContext.getExecutedNode();

        if (!toBeExecuted.getPermission().attempt(stagedContext)) {
            //NO PERMISSIONS! fall back to the node above it. However, if toBeExecuted is the base node, fall back to the fallbackhandler

            return null;
        } else {
            //the user is authorized
            return toBeExecuted.getExecutionHandler();
        }
    }
}
