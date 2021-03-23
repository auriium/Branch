package me.aurium.beetle.branch.builders;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.EmptyBlock;
import me.aurium.beetle.branch.block.StringBlock;
import me.aurium.beetle.branch.nodes.BranchingNode;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.nodes.api.IdentifiableNode;
import me.aurium.beetle.branch.util.PreStoredHashSet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

public class BranchingBuilder<T> implements Builder<T> {

    private final Set<IdentifiableNode<T>> commands = new HashSet<>();

    private Block block;
    private IdentifiableNode<T> noArgs;
    private boolean linked;

    public void withIdentifier(Block block) {
        this.block = block;
    }

    public void withIdentifier(String string) {
        this.block = StringBlock.of(string);
    }

    public <C extends Builder<T>> void withNode(C key, Consumer<C> consumer) {
        consumer.accept(key);

        commands.add(key.build());
    }

    public <C extends SingleBuilder<T>> void withNoArgs(C key, boolean linked, Consumer<C> consumer) {
        consumer.accept(key);

        this.noArgs = key.build();
        this.linked = linked;
    }

    @Override
    public BranchingNode<T> build() {

        Objects.requireNonNull(block);

        PreStoredHashSet<IdentifiableNode<T>> set;

        if (noArgs == null) {
            if (linked) {
                throw new IllegalStateException("Attempted link without no-arguments handler!");
            } else {
                set = new PreStoredHashSet<>(commands,false);
            }
        } else {
            set = new PreStoredHashSet<>(noArgs,commands,linked);
        }

        return new BranchingNode<>(set,block);
    }

    @Override
    public CommandNode<T> buildWithoutIdentifier() {

        PreStoredHashSet<IdentifiableNode<T>> set;

        if (noArgs == null) {
            if (linked) {
                throw new IllegalStateException("Attempted link without no-arguments handler!");
            } else {
                set = new PreStoredHashSet<>(commands,false);
            }
        } else {
            set = new PreStoredHashSet<>(noArgs,commands,linked);
        }

        return new BranchingNode<>(set, EmptyBlock.of());
    }
}