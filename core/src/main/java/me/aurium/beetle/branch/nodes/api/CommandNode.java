package me.aurium.beetle.branch.nodes.api;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.context.NodeContext;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.handlers.api.SuggestionHandler;

import java.util.Optional;

/**
 * Base object
 * @param <T> fuck
 */
public interface CommandNode<T> {

    Optional<CommandNode<T>> getSpecificNode(BlockPath path);

    ExecutionHandler<T> getExecutionHandler(NodeContext<T> adapter);
    SuggestionHandler<T> getSuggestionHandler(NodeContext<T> adapter);

}
