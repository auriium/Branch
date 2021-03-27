package me.aurium.beetle.branch.converted;

import me.aurium.beetle.api.command.Command;
import me.aurium.beetle.branch.context.Context;
import me.aurium.beetle.branch.nodes.CommandNode;

public interface BranchCommand<T> extends Command<T> {

    CommandNode<T> getBaseNode();

    default void noArgsMissingOrError(Context<T> context) {
        context.messageSender("An error occurred while executing this command!");
    }

}
