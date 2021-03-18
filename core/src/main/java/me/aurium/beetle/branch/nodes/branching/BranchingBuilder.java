package me.aurium.beetle.branch.nodes.branching;

import me.aurium.beetle.branch.builder.Builder;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.builder.BuilderPair;
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

    public BranchingBuilder<T> withIdentifier(Block block) {
        this.block = block;

        return this;
    }

    public <C extends Builder<T>> void coolShit(BuilderPair<C> key, Consumer<C> consumer) {
        C builder = key.newBuilder();

        consumer.accept(builder);

        commands.add(builder.build());
    }

    public <C extends Builder<T>> void something(C key, Consumer<C> consumer) {
        consumer.accept(key);

        commands.add(key.build());
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

    public BranchingBuilder<T> add(Builder<T> builder) {
        this.commands.add(builder.build());

        return this;
    }

    public BranchingBuilder<T> wiff(Builder<T> builder) {
        return new BranchingBuilder<T>().add(builder);
    }

    public static <T> BranchingBuilder<T> with(Builder<T> builder) {
        return new BranchingBuilder<T>().add(builder);
    }
}