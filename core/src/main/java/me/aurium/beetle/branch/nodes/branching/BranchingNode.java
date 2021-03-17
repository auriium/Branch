package me.aurium.beetle.branch.nodes.branching;

import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.util.PreStoredHashSet;
import me.aurium.beetle.branch.adapter.ContextHandlerAdapter;
import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.BlockPath;

import java.util.*;

public class BranchingNode<T> implements CommandNode<T> {

    private final PreStoredHashSet<CommandNode<T>> nodes;
    private final Block path;

    public BranchingNode(PreStoredHashSet<CommandNode<T>> nodes, Block path) {
        this.nodes = nodes;
        this.path = path;
    }

    @Override
    public Block getIdentifier() {
        return path;
    }

    @Override
    public Optional<CommandNode<T>> getSpecificNode(BlockPath blockPath) {
        for (CommandNode<T> node : this.getLinkedNodes()) {
            if (blockPath.startsWith(node.getIdentifier())) {
                return node.getSpecificNode(blockPath.withoutBase());
            }
        }
        return Optional.ofNullable(nodes.getAlreadyStored());
    }

    @Override
    public Collection<CommandNode<T>> getLinkedNodes() {
        return nodes.getContents();
    }

    @Override
    public ContextHandlerAdapter<T> getContextHandler() {
        return nodes.getAlreadyStored().getContextHandler();
    }

}
