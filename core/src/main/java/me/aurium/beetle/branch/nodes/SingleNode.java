package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.context.NodeContext;
import me.aurium.beetle.branch.handlers.EmptySuggestionHandler;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.handlers.api.SuggestionHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.nodes.api.EndpointNode;

import java.util.Optional;

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
    public Optional<CommandNode<T>> getSpecificNode(BlockPath blockPath) {
        return Optional.of(this);
    }

    @Override
    public ExecutionHandler<T> getExecutionHandler(NodeContext<T> adapter) {
        return executionHandler;
    }

    @Override
    public SuggestionHandler<T> getSuggestionHandler(NodeContext<T> adapter) {
        return suggestionHandler;
    }


}
