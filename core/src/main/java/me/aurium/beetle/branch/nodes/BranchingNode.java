package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.handlers.api.BranchHandler;
import me.aurium.beetle.branch.handlers.api.Execution;
import me.aurium.beetle.branch.handlers.context.NodeContext;
import me.aurium.beetle.branch.interfacing.common.NoIntegratedArgsResponse;
import me.aurium.beetle.branch.nodes.model.IdentifiableNode;
import me.aurium.beetle.branch.nodes.results.*;
import me.aurium.beetle.branch.fallback.permissions.Permission;
import me.aurium.beetle.branch.nodes.results.model.Result;
import me.aurium.beetle.branch.utility.PreStoredHashSet;

import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO: missing a Node for noargs will cause it to rely on fallback rather than throwning exceptions and being bad (DONE - ish)
 *
 * Nodes should always assume that the first block in the blockpath is theirs to consume
 *
 * @param <T>
 */
public class BranchingNode<T> implements IdentifiableNode<T> {

    private final PreStoredHashSet<IdentifiableNode<T>> nodes;
    private final Block path;
    private final BranchHandler<T> handler;

    private final Permission<T> permission;

    public BranchingNode(PreStoredHashSet<IdentifiableNode<T>> nodes, Block path, Permission<T> permission) {
        this.nodes = nodes;
        this.path = path;
        this.permission = permission;

        this.handler = new BranchingHandler<>(nodes);
    }

    @Override
    public Block getIdentifier() {
        return path;
    }

    @Override
    public SearchInfo<T> getSpecificNode(SearchInput input) {

        Deque<Block> blockPath = input.getReducablePath();

        for (IdentifiableNode<T> node : nodes.getContents()) {
            if (blockPath.getFirst().equals(node.getIdentifier())) {
                blockPath.removeFirst(); //consume

                return node.getSpecificNode(input);
            }
        }

        return new SearchInfo<>(this, input); //empty handling is in the strategy
    }

    @Override
    public BranchHandler<T> getHandling() {
        return handler;
    }

    @Override
    public Permission<T> getPermission() {
        return permission;
    }

    public static final class BranchingHandler<T> implements BranchHandler<T> {

        private final PreStoredHashSet<IdentifiableNode<T>> nodeShit;

        public BranchingHandler(PreStoredHashSet<IdentifiableNode<T>> nodeShit) {
            this.nodeShit = nodeShit;
        }


        @Override
        public Result<Execution<T>> getExecution(NodeContext<T> context) {
            if (nodeShit.getAlreadyStored() == null) {
                return Result.fail(NoIntegratedArgsResponse.of(context));
            } else {
                return nodeShit.getAlreadyStored().getHandling().getExecution(context);
            }
        }

        @Override
        public List<String> getSuggestions(NodeContext<T> context) {

            //TODO fix this bullshit, add close-to-queue
            return nodeShit.getContents().stream().map(s -> s.getIdentifier().getIdentifier()).collect(Collectors.toList());
        }

    }


}
