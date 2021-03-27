package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.handlers.EmptySuggestionHandler;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.handlers.api.SuggestionHandler;
import me.aurium.beetle.branch.nodes.api.EndpointNode;
import me.aurium.beetle.branch.nodes.result.ExecutionResult;
import me.aurium.beetle.branch.nodes.result.NodeResult;
import me.aurium.beetle.branch.fallback.permission.Permission;

public class SingleNode<T> implements EndpointNode<T> {

    private final Block identifier;

    private final ExecutionHandler<T> executionHandler;
    private final SuggestionHandler<T> suggestionHandler;

    private final Permission<T> permission;

    public SingleNode(Block identifier, ExecutionHandler<T> executionHandler, Permission<T> permission) {
        this.identifier = identifier;

        this.executionHandler = executionHandler;
        this.permission = permission;

        this.suggestionHandler = new EmptySuggestionHandler<>();
    }

    @Override
    public Block getIdentifier() {
        return identifier;
    }

    @Override
    public NodeResult<T> getSpecificNode(BlockPath blockPath) {
        return new NodeResult<>(this,blockPath);
    }

    @Override
    public ExecutionResult<T> getExecutionHandler() {
        return new ExecutionResult<>(executionHandler);
    }

    @Override
    public SuggestionHandler<T> getSuggestionHandler() {
        return suggestionHandler;
    }

    @Override
    public Permission<T> getPermission() {
        return permission;
    }


}
