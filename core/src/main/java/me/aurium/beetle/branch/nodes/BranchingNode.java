package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.handlers.api.SuggestionHandler;
import me.aurium.beetle.branch.nodes.result.*;
import me.aurium.beetle.branch.permission.Permission;
import me.aurium.beetle.branch.util.PreStoredHashSet;

/**
 * TODO: missing a Node for noargs will cause it to rely on fallback rather than throwning exceptions and being bad
 * @param <T>
 */
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
    public NodeResult<T> getSpecificNode(BlockPath blockPath) {

        if (blockPath.isEmpty()) return new NodeResult<>(this,blockPath);

        for (IdentifiableNode<T> node : nodes.getContents()) {

            BlockPath subPath = blockPath.withoutBase(); //get everything after the index

            if (blockPath.startsWith(node.getIdentifier())) {
                return node.getSpecificNode(subPath);
            }
        }
        return new NodeResult<>(this, blockPath);
    }

    @Override
    public ExecutionResult<T> getExecutionHandler() {

        if (nodes.getAlreadyStored().isPresent()) {
            return nodes.getAlreadyStored().get().getExecutionHandler();
        } else {
            return ExecutionResult.empty(); //FALL BACK SOLDIER
        }

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
