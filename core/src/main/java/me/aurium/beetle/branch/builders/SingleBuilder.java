package me.aurium.beetle.branch.builders;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.EmptyBlock;
import me.aurium.beetle.branch.block.StringBlock;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.nodes.SingleNode;
import me.aurium.beetle.branch.nodes.api.CommandNode;

import java.util.Objects;

public class SingleBuilder<C> implements AloneBuilder<C> {

    private Block block;
    private ExecutionHandler<C> contextHandler;

    public void withIdentifier(Block identifier) {
        this.block = identifier;
    }

    public void withIdentifier(String string) {
        this.block = StringBlock.of(string);
    }

    public void withHandler(ExecutionHandler<C> handler) {
        this.contextHandler = handler;
    }

    public SingleNode<C> build() {
        Objects.requireNonNull(block);
        Objects.requireNonNull(contextHandler);

        return new SingleNode<>(block, contextHandler);
    }

    @Override
    public CommandNode<C> buildWithoutIdentifier() {
        Objects.requireNonNull(contextHandler);

        return new SingleNode<>(EmptyBlock.of(),contextHandler);
    }

}
