package me.aurium.beetle.branch.nodes.model;

import me.aurium.beetle.branch.handlers.api.SuggestionHandler;
import me.aurium.beetle.branch.nodes.results.ExecutionResult;
import me.aurium.beetle.branch.nodes.results.SearchInput;
import me.aurium.beetle.branch.nodes.results.SearchInfo;
import me.aurium.beetle.branch.fallback.permission.Permission;
import me.aurium.beetle.branch.nodes.results.model.Result;

/**
 * Base object
 * @param <T> fuck
 */
public interface CommandNode<T> {

    SearchInfo<T> getSpecificNode(SearchInput path);

    ExecutionResult<T> getExecutionHandler();
    SuggestionHandler<T> getSuggestionHandler();

    /**
     * Gets the permission required to execute and interact with this node. Depending on the base, this may cause the node to become locked, or just completely be ignored.
     * @return the permission binding
     */
    Permission<T> getPermission();
}
