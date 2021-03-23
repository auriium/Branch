package me.aurium.beetle.branch.permission.strategies;

import me.aurium.beetle.branch.context.StagedContext;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.permission.FallbackStrategy;

/**
 * does what it says on the tin (really just an example)
 */
public class AngryMessageStrategy<T> implements FallbackStrategy<T> {

    private final String antiPermissionMessage; //something like "You cannot run that!" or "Unknown command. Type /help for help!"

    public AngryMessageStrategy(String antiPermissionMessage) {
        this.antiPermissionMessage = antiPermissionMessage;
    }

    @Override
    public ExecutionHandler<T> strategy(StagedContext<T> stagedContext) {
        CommandNode<T> executedNode = stagedContext.getExecutedNode();

        if (!executedNode.getPermission().attempt(stagedContext)) {
            return (contex) -> {
              contex.messageSender(antiPermissionMessage);
            };
        } else {
            return executedNode.getExecutionHandler();
        }

    }
}
