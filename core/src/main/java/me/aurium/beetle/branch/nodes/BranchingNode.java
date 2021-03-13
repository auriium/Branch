package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.api.command.ContextHandler;
import me.aurium.beetle.api.nodes.path.Block;
import me.aurium.beetle.api.nodes.path.BlockPath;
import me.aurium.beetle.branch.PreStoredHashSet;
import me.aurium.beetle.branch.CommandNode;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class BranchingNode<T> implements CommandNode<T> {

    private final PreStoredHashSet<CommandNode<T>> nodes;
    private final CommandNode<T> root;
    private final CommandNode<T> parent;
    private final Block path;

    public BranchingNode(PreStoredHashSet<CommandNode<T>> nodes, CommandNode<T> root, CommandNode<T> parent, Block path) {
        this.nodes = nodes;
        this.root = root;
        this.parent = parent;
        this.path = path;
    }

    @Override
    public BlockPath getAbsolutePath() {
        return parent.getAbsolutePath().resolve(path);
    }

    @Override
    public Block getShortPath() {
        return path;
    }

    @Override
    public CommandNode<T> getRoot() {
        return root;
    }

    @Override
    public CommandNode<T> getParent() {
        return parent;
    }

    @Override
    public Optional<CommandNode<T>> getSpecificNode(BlockPath blockPath) {
        for (CommandNode<T> node : this.getLinkedNodes()) {
            if (blockPath.startsWith(node.getShortPath())) {
                return node.getSpecificNode(blockPath);
            }
        }
        return Optional.empty();
    }

    @Override
    public Collection<CommandNode<T>> getLinkedNodes() {
        return nodes.getContents();
    }

    @Override
    public ContextHandler<T> getContextHandler() {
        return nodes.getAlreadyStored().getContextHandler();
    }

    public static class Builder<T> {
        private final CommandNode<T> root;
        private final CommandNode<T> parent;

        private Block block;

        private Set<CommandNode<T>> commands;
        private CommandNode<T> noArgs;

        private boolean linked = false;

        public Builder(CommandNode<T> root, CommandNode<T> parent) {
            this.root = root;
            this.parent = parent;
            this.commands = new HashSet<>();
        }

        public BranchingNode<T> build() {

            if (linked) {
                if (noArgs == null) {
                    throw new IllegalStateException("Cannot be linked with no noargs handler!");
                } else {
                    PreStoredHashSet<CommandNode<T>> set = new PreStoredHashSet<>(noArgs, commands, true);
                }
            } else {

            }



            return new BranchingNode<>()
        }
    }
}
