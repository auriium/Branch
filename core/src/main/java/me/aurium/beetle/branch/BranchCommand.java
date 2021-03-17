package me.aurium.beetle.branch;

import me.aurium.beetle.api.command.Command;
import me.aurium.beetle.api.command.ContextHandler;

public interface BranchCommand<T> extends Command<T> {

    CommandNode<T> getBaseNode();

    default ContextHandler<T> noArgsMissingOrError() {
        return (context) -> {
            context.debugString("An error occurred while executing this command!");

            return false;
        };
    }

}
