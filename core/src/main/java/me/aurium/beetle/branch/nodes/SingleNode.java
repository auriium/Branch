package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.IdentifiableNode;
import me.aurium.beetle.branch.adapter.ContextHandlerAdapter;
import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.BlockPath;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class SingleNode<T> implements AloneNode<T> {

    private final Block identifier;
    private final ContextHandlerAdapter<T> handler;

    public SingleNode(Block identifier, ContextHandlerAdapter<T> contextHandler) {
        this.identifier = identifier;
        this.handler = contextHandler;
    }

    @Override
    public Block getIdentifier() {
        return identifier;
    }

    @Override
    public Optional<IdentifiableNode<T>> getSpecificNode(BlockPath blockPath) {
        return Optional.of(this);
    }

    @Override
    public Collection<IdentifiableNode<T>> getLinkedNodes() {
        return Collections.emptySet();
    }

    @Override
    public ContextHandlerAdapter<T> getContextHandler() {
        return handler;
    }

}
