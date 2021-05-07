package me.aurium.branch.nodes.branching;

import me.aurium.branch.execution.Block;
import me.aurium.branch.execution.StringBlock;
import me.aurium.branch.fallback.permissions.EmptyPermission;
import me.aurium.branch.fallback.permissions.Permission;
import me.aurium.branch.information.description.Description;
import me.aurium.branch.information.description.StringDescription;
import me.aurium.branch.nodes.single.HelpNode;
import me.aurium.branch.nodes.Builder;
import me.aurium.branch.nodes.CommandNode;
import me.aurium.branch.nodes.IdentifiableNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ExclusiveBranchingBuilder<T> implements Builder<T> {

    private final Set<IdentifiableNode<T>> commands;

    private Block block;
    private CommandNode<T> noArgs;
    private Permission<T> permission;
    private Description description;

    public ExclusiveBranchingBuilder() {
        this.commands = new HashSet<>();
        this.permission = new EmptyPermission<>();
        this.noArgs = new HelpNode<>();
    }

    public ExclusiveBranchingBuilder<T> withIdentifier(Block block) {
        this.block = block;

        return this;
    }

    public ExclusiveBranchingBuilder<T> withIdentifier(String string) {
        this.block = StringBlock.of(string);

        return this;
    }

    public ExclusiveBranchingBuilder<T> withPermission(Permission<T> permission) {
        this.permission = permission;

        return this;
    }

    public ExclusiveBranchingBuilder<T> withDescription(Description description) {
        this.description = description;

        return this;
    }

    public ExclusiveBranchingBuilder<T> withNode(IdentifiableNode<T> node) {
        commands.add(node);

        return this;
    }

    public ExclusiveBranchingBuilder<T> withNoArgs(CommandNode<T> node) {
        this.noArgs = node;

        return this;
    }

    public CommandNode<T> build() {

        Objects.requireNonNull(block);
        Objects.requireNonNull(permission);
        Objects.requireNonNull(noArgs);

        Description returned = Objects.requireNonNullElse(description,new StringDescription("Default description for subcommand " + block.getIdentifier()));

        return new BranchingNode<>(new ExclusivePrestoredSet<>(noArgs,commands),block, returned, permission);
    }

}
