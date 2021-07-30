package xyz.auriium.branch.nodes;

import xyz.auriium.branch.execution.EnhancedNodeContext;
import xyz.auriium.branch.execution.NodeContext;
import xyz.auriium.branch.execution.api.Execution;
import xyz.auriium.branch.nodes.results.PostProcessSearch;
import xyz.auriium.branch.nodes.results.PreProcessSearch;
import xyz.auriium.branch.nodes.results.SearchPair;
import xyz.auriium.branch.nodes.results.model.Result;

/**
 * Node that doesn't give a shit but still handles enhancedNodeContexts
 * @param <T> the type
 */
public interface SimpleProcessingNode<T> extends ProcessingNode<T,Object> {

    Object returned = 0x01;

    @Override
    default Result<SearchPair<T, Object>> searchStepOneExecute(NodeContext<T> context, PreProcessSearch<T> preProcessSearch) {
        return Result.success(new SearchPair<>(PostProcessSearch.generate(preProcessSearch),returned));
    }

    @Override
    default Result<Execution<T>> searchStepTwoExecute(EnhancedNodeContext<T> context, Object object) {
        return onCommand(context);
    }

    Result<Execution<T>> onCommand(EnhancedNodeContext<T> context);
}
