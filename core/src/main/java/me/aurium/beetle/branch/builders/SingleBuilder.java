package me.aurium.beetle.branch.builders;

import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.adapter.ContextHandlerAdapter;
import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.EmptyBlock;
import me.aurium.beetle.branch.block.StringBlock;
import me.aurium.beetle.branch.nodes.SingleNode;

import java.util.Objects;

public class SingleBuilder<T> implements AloneBuilder<T> {

    private Block block;
    private ContextHandlerAdapter<T> contextHandler;

    public void withIdentifier(Block identifier) {
        this.block = identifier;
    }

    public void withIdentifier(String string) {
        this.block = StringBlock.of(string);
    }

    public void withHandler(ContextHandlerAdapter<T> handler) {
        this.contextHandler = handler;
    }

    public SingleNode<T> build() {
        Objects.requireNonNull(block);
        Objects.requireNonNull(contextHandler);

        return new SingleNode<>(block, contextHandler);
    }

    @Override
    public CommandNode<T> buildWithoutIdentifier() {
        Objects.requireNonNull(contextHandler);

        return new SingleNode<>(EmptyBlock.of(),contextHandler);
    }

}
