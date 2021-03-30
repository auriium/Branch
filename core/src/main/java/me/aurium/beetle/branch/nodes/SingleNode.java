package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.handlers.EmptySuggestionHandler;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.handlers.api.SuggestionHandler;
import me.aurium.beetle.branch.nodes.model.EndpointNode;
import me.aurium.beetle.branch.nodes.results.ExecutionResult;
import me.aurium.beetle.branch.nodes.results.SearchInput;
import me.aurium.beetle.branch.nodes.results.SearchInfo;
import me.aurium.beetle.branch.fallback.permission.Permission;
import me.aurium.beetle.branch.nodes.results.model.Result;
import me.aurium.beetle.branch.nodes.results.model.SuccessfulResult;

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
    public Result<SearchInfo<T>> getSpecificNode(SearchInput input) {
        input.getReducablePath().removeFirst(); //consume

        return new SuccessfulResult<>(new SearchInfo<>(this,input));
    }

    //TODO these maybe need to go somewhere else to a sort of parser
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
