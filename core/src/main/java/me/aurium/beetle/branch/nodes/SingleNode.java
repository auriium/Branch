package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.api.block.path.Block;
import me.aurium.beetle.api.block.path.BlockPath;
import me.aurium.beetle.api.command.ContextHandler;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.IndividualNode;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class SingleNode<T> implements IndividualNode<T> {

    private final Block identifier;
    private final ContextHandler<T> handler;

    public SingleNode(Block identifier, ContextHandler<T> contextHandler) {
        this.identifier = identifier;
        this.handler = contextHandler;
    }

    @Override
    public Block getIdentifier() {
        return identifier;
    }

/*
    @Override
    public CommandNode<T> getRoot() {
        return root;
    }

    @Override
    public CommandNode<T> getParent() {
        return parent;
    }
*/

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

    public static class Builder<T> {

        private final CommandNode<T> root;
        private final CommandNode<T> parent;

        private Block block;
        private ContextHandler<T> contextHandler;

        public Builder(CommandNode<T> root, CommandNode<T> parent) {
            this.root = root;
            this.parent = parent;
        }

        public Builder<T> setIdentifier(Block identifier) {
            this.block = identifier;

            return this;
        }

        public Builder<T> setHandler(ContextHandler<T> handler) {
            this.contextHandler = handler;

            return this;
        }

        public SingleNode<T> build() {
            return new SingleNode<>(root,parent,block,contextHandler);
        }

    }

    public interface BuilderConsumer<T> {
        void consume(Builder<T> builder);
    }
}
