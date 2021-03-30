package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.handlers.api.BranchHandler;
import me.aurium.beetle.branch.handlers.api.SuggestionHandler;
import me.aurium.beetle.branch.handlers.context.NodeContext;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.model.IdentifiableNode;
import me.aurium.beetle.branch.nodes.results.*;
import me.aurium.beetle.branch.fallback.permission.Permission;
import me.aurium.beetle.branch.nodes.results.model.FailingResult;
import me.aurium.beetle.branch.nodes.results.model.Result;
import me.aurium.beetle.branch.util.PreStoredHashSet;

import java.util.Deque;
import java.util.List;

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
            return null;
        };
    }

    @Override
    public Permission<T> getPermission() {
        return permission;
    }

    public static final class BranchingHandler<T> implements BranchHandler<T> {

        private final CommandNode<T> alreadyPresent;

        @Override
        public void getExecution(NodeContext<T> context) {

        }

        @Override
        public List<String> getSuggestions(NodeContext<T> context) {
            return null;
        }

    }


}
