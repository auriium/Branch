package me.aurium.beetle.branch.nodes.branching;

import me.aurium.beetle.branch.builder.Builder;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.builder.BuilderPair;
import me.aurium.beetle.branch.nodes.single.SingleBuilder;
import me.aurium.beetle.branch.util.PreStoredHashSet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

public class BranchingBuilder<T> implements Builder<T> {

    private final Set<CommandNode<T>> commands = new HashSet<>();

    private Block block;
    private CommandNode<T> noArgs;
    private boolean linked;

    public void withIdentifier(Block block) {
        this.block = block;
    }

    public <C extends Builder<T>> void withNode(C key, Consumer<C> consumer) {
        consumer.accept(key);

        commands.add(key.build());
    }

    public <C extends SingleBuilder<T>> void withNoArgs(C key, Consumer<C> consumer, boolean linked) {
        consumer.accept(key);

        this.noArgs = key.build();
        this.linked = linked;
    }

    @Override
    public BranchingNode<T> build() {

        Objects.requireNonNull(block);

        PreStoredHashSet<CommandNode<T>> set;

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
}