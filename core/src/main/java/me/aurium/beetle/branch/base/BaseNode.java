package me.aurium.beetle.branch.base;

import me.aurium.beetle.api.command.ContextHandler;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.BlockPath;

import java.util.Collection;
import java.util.Optional;

public class BaseNode<T> implements CommandNode<T> {

    private final CommandNode<T> delegatingNode;
    private final Block commandName;

    public BaseNode(Block commandName, CommandNode<T> delegatingNode) {
        this.delegatingNode = delegatingNode;
        this.commandName = commandName;
    }

    @Override
    public Block getIdentifier() {
        return commandName;
    }

    @Override
    public Optional<CommandNode<T>> getSpecificNode(BlockPath path) {
        return Optional.empty();
    }

    @Override
    public Collection<CommandNode<T>> getLinkedNodes() {
        return null;
    }

    @Override
    public ContextHandler<T> getContextHandler() {
        return null;
    }
}
