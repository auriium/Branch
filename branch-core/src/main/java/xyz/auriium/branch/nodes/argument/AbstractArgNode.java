package xyz.auriium.branch.nodes.argument;

import xyz.auriium.branch.base.EnhancedNodeContext;
import xyz.auriium.branch.interfacing.exceptional.anomalies.TooFewInputsExternalAnomaly;
import xyz.auriium.branch.base.NodeContext;
import xyz.auriium.branch.base.execution.ArgExecution;
import xyz.auriium.branch.base.execution.Execution;
import xyz.auriium.branch.nodes.ProcessingNode;
import xyz.auriium.branch.nodes.argument.model.ContextualBaseArgument;
import xyz.auriium.branch.results.PostProcessSearch;
import xyz.auriium.branch.results.PreProcessSearch;
import xyz.auriium.branch.results.SearchPair;
import xyz.auriium.branch.results.Result;

import java.util.*;

public abstract class AbstractArgNode<T> implements ProcessingNode<T, Arguments> {

    protected abstract List<ContextualBaseArgument<T,?>> getArguments();
    protected abstract ArgumentContextHandler<T> getContextHandler();

    @Override
    public Result<Execution<T>> searchExecute(NodeContext<T> ctx, PreProcessSearch<T> input) {

        for (ContextualBaseArgument<T,?> argument : getArguments()) {

        }

        return Result.success(null);
    }

    @Override
    public Result<SearchPair<T, Arguments>> searchStepOneExecute(NodeContext<T> context, PreProcessSearch<T> preProcessSearch) {

        Arguments argumentObject = new Arguments();
        Queue<String> subQueue = new LinkedList<>(preProcessSearch.getRemainingStrings());

        int argsLeft = getArguments().size();

        for (ContextualBaseArgument<T,?> argument : getArguments()) {

            if (subQueue.peek() == null) {

                if (argument.getOptional().isPresent()) { //if this is an optional argument
                    argumentObject.put(argument.getLabel(),argument.getOptional().get());

                    continue;
                } else {
                    return Result.fail(
                            new TooFewInputsExternalAnomaly()
                    ); //throw


                }


            }

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
