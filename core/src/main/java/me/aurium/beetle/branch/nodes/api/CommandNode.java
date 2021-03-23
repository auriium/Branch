package me.aurium.beetle.branch.nodes.api;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.handlers.api.SuggestionHandler;
import me.aurium.beetle.branch.nodes.result.GetNodeResult;
import me.aurium.beetle.branch.permission.Permission;

import java.util.Optional;

/**
 * Base object
 * @param <T> fuck
 */
public interface CommandNode<T> {

    GetNodeResult<T> getSpecificNode(BlockPath path);

    ExecutionHandler<T> getExecutionHandler();
    SuggestionHandler<T> getSuggestionHandler();

    /**
     * Gets the permission required to execute and interact with this node. Depending on the base, this may cause the node to become locked, or just completely be ignored.
     * @return the permission binding
     */
    Permission<T> getPermission();
}
