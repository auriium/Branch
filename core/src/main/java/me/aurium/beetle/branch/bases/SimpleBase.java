package me.aurium.beetle.branch.bases;

import me.aurium.beetle.api.nodes.impl.StringBlockPath;
import me.aurium.beetle.api.nodes.path.BlockPath;
import me.aurium.beetle.branch.CommandBase;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.Context;
import me.aurium.beetle.branch.ContextHandler;

import java.util.Optional;

/// FIXME: 3/10/21 I've discovered that a nodemap cannot be built with both it's parent and contents being set up correctly
public class SimpleBase<T> implements CommandBase<T> {

    private final CommandNode<T> baseNode;

    public SimpleBase(CommandNode<T> baseNode) {
        this.baseNode = baseNode;
    }

    @Override
    public ContextHandler<T> getHandler(Context<T> context) {
        BlockPath correctPath = StringBlockPath.of(context.getArgs());
        Optional<CommandNode<T>> node = baseNode.getSpecificNode(correctPath);

        if (node.isPresent()) {
            return node.get().getContextHandler();
        } else {
            return baseNode.getContextHandler();
        }
    }

    @Override
    public void handle(Context<T> context) {
        getHandler(context).consume(context);
    }
}
