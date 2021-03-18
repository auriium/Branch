package me.aurium.beetle.branch.nodes.single;

import me.aurium.beetle.branch.adapter.ContextHandlerAdapter;
import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.builder.AloneBuilder;

import java.util.Objects;

public class SingleBuilder<T> implements AloneBuilder<T> {

    private Block block;
    private ContextHandlerAdapter<T> contextHandler;

    public void withIdentifier(Block identifier) {
        this.block = identifier;
    }

    public void withHandler(ContextHandlerAdapter<T> handler) {
        this.contextHandler = handler;
    }

    public SingleNode<T> build() {
        Objects.requireNonNull(block);
        Objects.requireNonNull(contextHandler);

        return new SingleNode<>(block, contextHandler);
    }

}
