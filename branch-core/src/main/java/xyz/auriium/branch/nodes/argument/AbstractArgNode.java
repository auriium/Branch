package xyz.auriium.branch.nodes.argument;

import xyz.auriium.branch.execution.EnhancedNodeContext;
import xyz.auriium.branch.interfacing.exceptional.anomalies.TooFewInputsInternalAnomaly;
import xyz.auriium.branch.execution.Block;
import xyz.auriium.branch.execution.NodeContext;
import xyz.auriium.branch.execution.api.ArgExecution;
import xyz.auriium.branch.execution.api.Execution;
import xyz.auriium.branch.execution.api.SuggestionHandler;
import xyz.auriium.branch.nodes.ProcessingNode;
import xyz.auriium.branch.nodes.argument.model.ContextualBaseArgument;
import xyz.auriium.branch.nodes.results.PostProcessSearch;
import xyz.auriium.branch.nodes.results.PreProcessSearch;
import xyz.auriium.branch.nodes.results.SearchPair;
import xyz.auriium.branch.nodes.results.model.Result;
import xyz.auriium.branch.nodes.EndpointNode;

import java.util.*;

public abstract class AbstractArgNode<T> implements ProcessingNode<T, Arguments> {

    protected abstract List<ContextualBaseArgument<T,?>> getArguments();
    protected abstract ArgumentContextHandler<T> getContextHandler();

    @Override
    public SuggestionHandler<T> getSuggestionHandler() {
        return null; //TODO implement
    }

    @Override
    public Result<SearchPair<T, Arguments>> searchStepOneExecute(NodeContext<T> context, PreProcessSearch<T> preProcessSearch) {

        Arguments argumentObject = new Arguments();
        Queue<String> subQueue = new LinkedList<>(preProcessSearch.getRemainingStrings());

        int argsLeft = getArguments().size();

        for (ContextualBaseArgument<T,?> argument : getArguments()) {

            if (subQueue.peek() == null) return Result.fail(
                    new TooFewInputsInternalAnomaly(argument.getClass(), argument.getType(), context.getArgs().length + 1, context.getArgs().length)
            ); //noInputProvidedExternal if there

            assert argument.reservedBlockAmount() > 0 : "Cannot be negative or zero";

            List<String> collected = new ArrayList<>();

            for (int v = 0; v < argument.reservedBlockAmount(); ++v) {
                String blk = subQueue.peek();

                if (blk == null) return Result.fail(null); //noInputProvidedInternal if theres not enough for the NEXT RESERVATION inside this arg

                collected.add(subQueue.remove());
            }

            Result<?> res = argument.parse(context.getSender(), context.getAlias(), collected);

            if (!res.isSuccessful()) {
                return Result.transmuteFail(res);
            }

            preProcessSearch.getRemainingBlocks().add(argument.getType());
            argumentObject.put(argument.getLabel(), res.getSuccess());
        }


        return Result.success(new SearchPair<>(PostProcessSearch.generate(preProcessSearch),argumentObject));
    }

    @Override
    public Result<Execution<T>> searchStepTwoExecute(EnhancedNodeContext<T> context, Arguments object) {
        return Result.success(new ArgExecution<>(getContextHandler(),context,object));
    }
}
