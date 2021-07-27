package xyz.auriium.branch.nodes.single;

import xyz.auriium.branch.execution.Block;
import xyz.auriium.branch.execution.NodeContext;
import xyz.auriium.branch.execution.api.BasicExecution;
import xyz.auriium.branch.execution.api.Execution;
import xyz.auriium.branch.execution.api.ExecutionHandler;
import xyz.auriium.branch.execution.api.SuggestionHandler;
import xyz.auriium.branch.nodes.EndpointNode;
import xyz.auriium.branch.nodes.results.model.Result;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSingleNode<T> extends EndpointNode<T> {

    public static List<Block> returned = new ArrayList<>();

    @Override
    public SuggestionHandler<T> getSuggestionHandler() {
        return (ignored) -> returned;
    }

    @Override
    public Result<Execution<T>> getExecution(NodeContext<T> context) {
        //TODO return bad result if search failed / more than 1 result left

        return Result.success(new BasicExecution<>(getHandler(),context));
    }

    protected abstract ExecutionHandler<T> getHandler();
}
