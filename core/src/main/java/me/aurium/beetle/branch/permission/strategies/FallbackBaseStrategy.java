package me.aurium.beetle.branch.permission.strategies;

import me.aurium.beetle.branch.context.StagedContext;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.permission.FallbackStrategy;

public class FallbackBaseStrategy<T> implements FallbackStrategy<T> {

    @Override
    public ExecutionHandler<T> strategy(StagedContext<T> stagedContext) {
        //this strategy should: if base node, fall back to fallback-strategy. If not, fall back to base node's executor.

        CommandNode<T> executed = stagedContext.getExecutedNode();
        CommandNode<T> baseNode = stagedContext.getBaseExecutedNode();

        if (executed.equals(baseNode)) {
            //todo remove this
            return (s) -> {
                stagedContext.getFallbackAction().handle(s);
            };
        }

        return null;
    }
}
