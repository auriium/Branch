package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.handlers.api.SuggestionHandler;
import me.aurium.beetle.branch.nodes.api.IdentifiableNode;
import me.aurium.beetle.branch.nodes.result.GetNodeResult;
import me.aurium.beetle.branch.nodes.result.NullableNodeResult;
import me.aurium.beetle.branch.permission.Permission;
import me.aurium.beetle.branch.util.PreStoredHashSet;

public class BranchingNode<T> implements IdentifiableNode<T> {

    private final PreStoredHashSet<IdentifiableNode<T>> nodes;
    private final Block path;

    private final Permission<T> permission;

    public BranchingNode(PreStoredHashSet<IdentifiableNode<T>> nodes, Block path, Permission<T> permission) {
        this.nodes = nodes;
        this.path = path;
        this.permission = permission;
    }

    @Override
    public Block getIdentifier() {
        return path;
    }

    @Override
    public GetNodeResult<T> getSpecificNode(BlockPath blockPath) {

        if (blockPath.isEmpty()) return new NullableNodeResult<>(nodes.getAlreadyStored(),blockPath);

        for (IdentifiableNode<T> node : nodes.getContents()) {

            BlockPath subPath = blockPath.withoutBase(); //get everything after the index

            if (blockPath.startsWith(node.getIdentifier())) {
                return node.getSpecificNode(blockPath.withoutBase());
            }
        }
        return new NullableNodeResult<>(nodes.getAlreadyStored(), blockPath);
    }

    @Override
    public ExecutionHandler<T> getExecutionHandler() {
        return nodes.getAlreadyStored().getExecutionHandler();
    }

    @Override
    public SuggestionHandler<T> getSuggestionHandler() {
        //TODO sort this out

        return (context) -> {
            //this works because this suggestion handler only gets called if we are on this object lmfao
            Block matchableBlock = context.executedPath().getAllBlocks().getLast();

            return null;
        };
    }

    @Override
    public Permission<T> getPermission() {
        return permission;
    }


}
