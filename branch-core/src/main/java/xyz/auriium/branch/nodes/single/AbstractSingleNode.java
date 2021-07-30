package xyz.auriium.branch.nodes.single;

import xyz.auriium.branch.centralized.information.description.Description;
import xyz.auriium.branch.execution.Block;
import xyz.auriium.branch.execution.EnhancedNodeContext;
import xyz.auriium.branch.execution.NodeContext;
import xyz.auriium.branch.execution.api.BasicExecution;
import xyz.auriium.branch.execution.api.Execution;
import xyz.auriium.branch.execution.api.ExecutionHandler;
import xyz.auriium.branch.execution.api.SuggestionHandler;
import xyz.auriium.branch.execution.blocks.EndpointBlock;
import xyz.auriium.branch.fallback.permissions.Permission;
import xyz.auriium.branch.nodes.EndpointNode;
import xyz.auriium.branch.nodes.SimpleProcessingNode;
import xyz.auriium.branch.nodes.results.InitialSearch;
import xyz.auriium.branch.nodes.results.PreProcessSearch;
import xyz.auriium.branch.nodes.results.model.Result;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSingleNode<T> implements SimpleProcessingNode<T> {

    public static List<Block> returned = new ArrayList<>();

    @Override
    public SuggestionHandler<T> getSuggestionHandler() {
        return (ignored) -> returned;
    }

    @Override
    public Result<Execution<T>> onCommand(EnhancedNodeContext<T> context) {
        return Result.success(new BasicExecution<>(getHandler(), context));
    }

    protected abstract ExecutionHandler<T> getHandler();

}
