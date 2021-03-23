package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.handlers.EmptySuggestionHandler;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.handlers.api.SuggestionHandler;
import me.aurium.beetle.branch.nodes.api.EndpointNode;
import me.aurium.beetle.branch.nodes.result.GetNodeResult;
import me.aurium.beetle.branch.nodes.result.NullableNodeResult;
import me.aurium.beetle.branch.permission.Permission;

public class SingleNode<T> implements EndpointNode<T> {

    private final Block identifier;

    private final ExecutionHandler<T> executionHandler;
    private final SuggestionHandler<T> suggestionHandler;

    public SingleNode(Block identifier, ExecutionHandler<T> executionHandler) {
        this.identifier = identifier;

        this.executionHandler = executionHandler;
        this.suggestionHandler = new EmptySuggestionHandler<>();
    }

    @Override
    public Block getIdentifier() {
        return identifier;
    }

    @Override
    public GetNodeResult<T> getSpecificNode(BlockPath blockPath) {
        return new NullableNodeResult<>(this,blockPath);
    }

    @Override
    public ExecutionHandler<T> getExecutionHandler() {
        return executionHandler;
    }

    @Override
    public SuggestionHandler<T> getSuggestionHandler() {
        return suggestionHandler;
    }

    @Override
    public Permission<T> getPermission() {
        return null;
    }


}
