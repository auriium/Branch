package me.aurium.beetle.branch.nodes.branching;

import me.aurium.beetle.branch.Builder;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.nodes.single.SingleBuilder;
import me.aurium.beetle.branch.util.PreStoredHashSet;
import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.nodes.single.SingleNode;

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

    public BranchingBuilder<T> single(Consumer<SingleBuilder<T>> consumer) {
        SingleBuilder<T> builder = new SingleBuilder<>();

        consumer.accept(builder);

        this.commands.add(builder);

        return null;
    }

    public <C extends Builder<T>> BranchingBuilder<T> withBuilder(Consumer<C> consumer) {
        return null;
    }


    @Deprecated
    public BranchingBuilder<T> withNode(CommandNode<T> commandNode) {
        this.commands.add(commandNode);

        return this;
    }

    @Deprecated
    public BranchingBuilder<T> withBuilder(Builder<T> builder) {
        this.commands.add(builder.build());

        return this;
    }

    @Deprecated
    public BranchingBuilder<T> withNoArgs(SingleNode<T> node, boolean linked) {
        this.noArgs = node;
        this.linked = linked;

        return this;
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

    public static <C> BranchingBuilder<C> make() {
        return new BranchingBuilder<>();
    }
}