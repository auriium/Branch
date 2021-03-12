package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.api.command.ContextHandler;
import me.aurium.beetle.api.nodes.path.Block;
import me.aurium.beetle.api.nodes.path.BlockPath;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.IndividualNode;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class SingleCommandNode<T> implements IndividualNode<T> {

    private final CommandNode<T> root;
    private final CommandNode<T> parent;
    private final Block identifier;
    private final ContextHandler<T> handler;

    public SingleCommandNode(CommandNode<T> root, CommandNode<T> parent, Block identifier, ContextHandler<T> contextHandler) {
        this.root = root;
        this.parent = parent;
        this.identifier = identifier;
        this.handler = contextHandler;
    }

    @Override
    public BlockPath getAbsolutePath() {
        return parent.getAbsolutePath().resolve(identifier);
    }

    @Override
    public Block getShortPath() {
        return identifier;
    }

    @Override
    public CommandNode<T> getRoot() {
        return root;
    }

    @Override
    public CommandNode<T> getParent() {
        return parent;
    }

    @Override
    public Optional<CommandNode<T>> getSpecificNode(BlockPath blockPath) {
        return Optional.of(this);
    }

    @Override
    public Collection<CommandNode<T>> getLinkedNodes() {
        return Collections.emptySet();
    }

    @Override
    public ContextHandler<T> getContextHandler() {
        return handler;
    }
}
