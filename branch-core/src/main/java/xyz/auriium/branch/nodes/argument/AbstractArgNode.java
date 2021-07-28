package xyz.auriium.branch.nodes.argument;

import xyz.auriium.branch.anomalies.NoInputProvidedAnomaly;
import xyz.auriium.branch.execution.Block;
import xyz.auriium.branch.execution.NodeContext;
import xyz.auriium.branch.execution.api.ArgExecution;
import xyz.auriium.branch.execution.api.Execution;
import xyz.auriium.branch.execution.api.SuggestionHandler;
import xyz.auriium.branch.nodes.argument.model.ContextualBaseArgument;
import xyz.auriium.branch.nodes.results.model.Result;
import xyz.auriium.branch.nodes.EndpointNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public abstract class AbstractArgNode<T> extends EndpointNode<T> {

    protected abstract List<ContextualBaseArgument<T,?>> getArguments();
    protected abstract ArgumentContextHandler<T> getContextHandler();

    @Override
    public Result<Execution<T>> getExecution(NodeContext<T> context) {


        Arguments argumentObject = new Arguments();
        Deque<Block> subdeque = new ArrayDeque<>(context.getResults().reducedPath());

        int argsLeft = getArguments().size();

        for (ContextualBaseArgument<T,?> argument : getArguments()) {

            if (subdeque.peek() == null) return Result.fail(
                    new NoInputProvidedAnomaly(argument.getClass(), argument.getType(), argument.getLabel(), context.getArgs().length + 1, context.getArgs().length)
            ); //noInputProvidedExternal if there

            assert argument.reservedBlockAmount() > 0 : "Cannot be negative or zero";

            List<Block> collect = new ArrayList<>();

            for (int v = 0; v < argument.reservedBlockAmount(); ++v) {
                Block blk = subdeque.pollFirst();

                if (blk == null) return Result.fail(null); //noInputProvidedInternal if theres not enough for the NEXT RESERVATION inside this arg

                collect.add(blk);
            }

            Result<?> res = argument.parse(context.getSender(), context.getAlias(), collect);

            if (!res.isSuccessful()) {
                return Result.transmuteFail(res);
            }

            argumentObject.put(argument.getLabel(), res.getSuccess());
        }

        return Result.success(new ArgExecution<>(getContextHandler(), context, argumentObject));
    }

    @Override
    public SuggestionHandler<T> getSuggestionHandler() {
        return null; //TODO
    }
}
