package xyz.auriium.branch.nodes.branching;

import xyz.auriium.branch.execution.Block;
import xyz.auriium.branch.execution.StringBlock;
import xyz.auriium.branch.fallback.permissions.EmptyPermission;
import xyz.auriium.branch.fallback.permissions.Permission;
import xyz.auriium.branch.centralized.information.description.Description;
import xyz.auriium.branch.centralized.information.description.StringDescription;
import xyz.auriium.branch.nodes.help.HelpNode;
import xyz.auriium.branch.nodes.Builder;
import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.nodes.IdentifiableNode;

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

    public IdentifiableNode<T> build() {

        Objects.requireNonNull(block);
        Objects.requireNonNull(permission);
        Description returned = Objects.requireNonNullElse(description,new StringDescription("Default description for subcommand " + block.getIdentifier()));

        if (noArgs == null) {
            noArgs = HelpNode.of(permission,returned);
        }

        return new BranchingNode<>(new ExclusivePrestoredSet<>(noArgs,commands),block, returned, permission);
    }

}
