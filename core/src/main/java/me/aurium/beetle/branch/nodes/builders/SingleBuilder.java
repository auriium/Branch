package me.aurium.beetle.branch.nodes.builders;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.EmptyBlock;
import me.aurium.beetle.branch.block.StringBlock;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.nodes.SingleNode;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.fallback.permission.Permission;
import me.aurium.beetle.branch.fallback.permission.permissions.EmptyPermission;

import java.util.Objects;

public class SingleBuilder<C> implements AloneBuilder<C> {

    private Block block;
    private ExecutionHandler<C> contextHandler;
    private Permission<C> permission = new EmptyPermission<>();

    public void withIdentifier(Block identifier) {
        this.block = identifier;
    }

    public void withIdentifier(String string) {
        this.block = StringBlock.of(string);
    }

    public void withHandler(ExecutionHandler<C> handler) {
        this.contextHandler = handler;
    }

    public void withPermission(Permission<C> permission) {
        this.permission = permission;
    }

    public SingleNode<C> build() {
        Objects.requireNonNull(block);
        Objects.requireNonNull(contextHandler);

        return new SingleNode<>(block, contextHandler, permission);
    }

    @Override
    public CommandNode<C> buildWithoutIdentifier() {
        Objects.requireNonNull(contextHandler);

        return new SingleNode<>(EmptyBlock.of(),contextHandler, permission);
    }

}
