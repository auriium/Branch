package me.aurium.beetle.branch.newnode;

import me.aurium.beetle.api.command.ContextHandler;
import me.aurium.beetle.api.nodes.path.Block;
import me.aurium.beetle.api.nodes.path.BlockPath;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.PreStoredHashSet;

import java.util.Collection;
import java.util.Optional;

public class NewBranchingNode<T> implements CommandNode<T> {

    private PreStoredHashSet<CommandNode<T>> nodes;
    private final CommandNode<T> root;
    private final CommandNode<T> parent;
    private final Block path;

    public NewBranchingNode(CommandNode<T> root, CommandNode<T> parent, Block path) {
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


}
