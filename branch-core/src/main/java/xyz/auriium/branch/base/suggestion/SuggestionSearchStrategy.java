package xyz.auriium.branch.base.suggestion;

import xyz.auriium.branch.base.NodeContext;

import java.util.List;

/**
 * Retrieves a single suggestion completion based on contextual arguments: likely delegates to the nodes themselves
 * as well as an adapter for conversion of type
 * @param <I> input type
 */
public interface SuggestionSearchStrategy<I> {

    List<String> order(List<Suggestion<I>> suggestions, NodeContext<I> ctx);

}
