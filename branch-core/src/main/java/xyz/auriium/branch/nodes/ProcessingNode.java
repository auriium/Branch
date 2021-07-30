package xyz.auriium.branch.nodes;

import xyz.auriium.branch.execution.DelegatingEnhancedContext;
import xyz.auriium.branch.execution.EnhancedNodeContext;
import xyz.auriium.branch.execution.NodeContext;
import xyz.auriium.branch.execution.api.Execution;
import xyz.auriium.branch.nodes.results.PreProcessSearch;
import xyz.auriium.branch.nodes.results.SearchPair;
import xyz.auriium.branch.nodes.results.model.Result;

public interface ProcessingNode<T,O> extends EndpointNode<T> {

    Result<SearchPair<T,O>>searchStepOneExecute(NodeContext<T> context, PreProcessSearch<T> preProcessSearch);
    Result<Execution<T>> searchStepTwoExecute(EnhancedNodeContext<T> context, O object);

    @Override
    default Result<Execution<T>> searchExecute(NodeContext<T> context, PreProcessSearch<T> input) {

        var pairResult = searchStepOneExecute(context, input);

        if (!pairResult.isSuccessful()) return Result.transmuteFail(pairResult);

        SearchPair<T,O> searchPair = pairResult.getSuccess();

        return searchStepTwoExecute(new DelegatingEnhancedContext<>(context, searchPair.getSearch()), searchPair.getObject());
    }
}
