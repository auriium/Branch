package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.IdentifiableNode;
import me.aurium.beetle.branch.util.PreStoredHashSet;
import me.aurium.beetle.branch.adapter.ContextHandlerAdapter;
import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.BlockPath;

import java.util.*;

public class BranchingNode<T> implements IdentifiableNode<T> {

    private final PreStoredHashSet<IdentifiableNode<T>> nodes;
    private final Block path;

    public BranchingNode(PreStoredHashSet<IdentifiableNode<T>> nodes, Block path) {
        this.nodes = nodes;
        this.path = path;
    }

    @Override
    public Block getIdentifier() {
        return path;
    }

    @Override
    public Optional<IdentifiableNode<T>> getSpecificNode(BlockPath blockPath) {
        for (IdentifiableNode<T> node : this.getLinkedNodes()) {
            if (blockPath.startsWith(node.getIdentifier())) {
                return node.getSpecificNode(blockPath.withoutBase());
            }
        }
        return Optional.ofNullable(nodes.getAlreadyStored());
    }

    @Override
    public Collection<IdentifiableNode<T>> getLinkedNodes() {
        return nodes.getContents();
    }

    @Override
    public ContextHandlerAdapter<T> getContextHandler() {
        return nodes.getAlreadyStored().getContextHandler();
    }

}
