package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.context.NodeContext;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.handlers.api.SuggestionHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.nodes.api.IdentifiableNode;
import me.aurium.beetle.branch.util.PreStoredHashSet;

import java.util.Optional;

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
    public Optional<CommandNode<T>> getSpecificNode(BlockPath blockPath) {
        if (blockPath.isEmpty()) return Optional.ofNullable(nodes.getAlreadyStored());

        for (IdentifiableNode<T> node : nodes.getContents()) {
            if (blockPath.startsWith(node.getIdentifier())) {
                return node.getSpecificNode(blockPath.withoutBase());
            }
        }
        return Optional.ofNullable(nodes.getAlreadyStored());
    }

    @Override
    public ExecutionHandler<T> getExecutionHandler(NodeContext<T> adapter) {
        return nodes.getAlreadyStored().getExecutionHandler(adapter);
    }

    @Override
    public SuggestionHandler<T> getSuggestionHandler(NodeContext<T> adapter) {
        //TODO sort this out

        return (context) -> {
            //this works because this suggestion handler only gets called if we are on this object lmfao
            Block matchableBlock = context.executedPath().getAllBlocks().getLast();

            return null;
        };
    }

}
