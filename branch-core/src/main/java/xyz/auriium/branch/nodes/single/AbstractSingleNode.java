package xyz.auriium.branch.nodes.single;

import xyz.auriium.branch.base.execution.blocks.Block;
import xyz.auriium.branch.base.EnhancedNodeContext;
import xyz.auriium.branch.base.execution.BasicExecution;
import xyz.auriium.branch.base.execution.Execution;
import xyz.auriium.branch.base.execution.ExecutionHandler;
import xyz.auriium.branch.nodes.SimpleProcessingNode;
import xyz.auriium.branch.results.Result;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSingleNode<T> implements SimpleProcessingNode<T> {

    public static List<Block> returned = new ArrayList<>();

    @Override
    public Result<Execution<T>> onCommand(EnhancedNodeContext<T> context) {
        return Result.success(new BasicExecution<>(getHandler(), context));
    }

    protected abstract ExecutionHandler<T> getHandler();

}
