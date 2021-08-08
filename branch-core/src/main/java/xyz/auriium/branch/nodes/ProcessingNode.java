package xyz.auriium.branch.nodes;

import xyz.auriium.branch.base.DelegatingEnhancedContext;
import xyz.auriium.branch.base.EnhancedNodeContext;
import xyz.auriium.branch.base.NodeContext;
import xyz.auriium.branch.base.execution.Execution;
import xyz.auriium.branch.results.PreProcessSearch;
import xyz.auriium.branch.results.SearchPair;
import xyz.auriium.branch.results.Result;

public interface ProcessingNode<T,O> extends EndpointNode<T> {

    Result<SearchPair<T,O>>searchStepOneExecute(NodeContext<T> context, PreProcessSearch<T> preProcessSearch);
    Result<Execution<T>> searchStepTwoExecute(EnhancedNodeContext<T> context, O object);

    @Override
    default Result<Execution<T>> searchExecute(NodeContext<T> ctx, PreProcessSearch<T> input) {

        var pairResult = searchStepOneExecute(ctx, input);

        if (!pairResult.isSuccessful()) return Result.transmuteFail(pairResult);

        SearchPair<T,O> searchPair = pairResult.getSuccess();

        return searchStepTwoExecute(new DelegatingEnhancedContext<>(ctx, searchPair.getSearch()), searchPair.getObject());
    }
}
