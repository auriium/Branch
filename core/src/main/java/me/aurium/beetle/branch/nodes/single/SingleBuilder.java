package me.aurium.beetle.branch.nodes.single;

import me.aurium.beetle.api.command.ContextHandler;
import me.aurium.beetle.branch.Builder;
import me.aurium.beetle.branch.adapter.ContextHandlerAdapter;
import me.aurium.beetle.branch.block.Block;

import java.util.Objects;

public class SingleBuilder<T> implements Builder<T> {

    private Block block;
    private ContextHandlerAdapter<T> contextHandler;

    public SingleBuilder<T> withIdentifier(Block identifier) {
        this.block = identifier;

        return this;
    }

    public SingleBuilder<T> withHandler(ContextHandlerAdapter<T> handler) {
        this.contextHandler = handler;

        return this;
    }

    public SingleNode<T> build() {
        Objects.requireNonNull(block);
        Objects.requireNonNull(contextHandler);

        return new SingleNode<>(block, contextHandler);
    }

    public static SingleBuilder<?> of(boolean fancyBuilder) {
        return null;
    }

}
