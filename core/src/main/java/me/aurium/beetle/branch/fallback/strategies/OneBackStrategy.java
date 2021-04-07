package me.aurium.beetle.branch.fallback.strategies;

import me.aurium.beetle.branch.interfacing.responses.common.NoPermissionResponse;
import me.aurium.beetle.branch.fallback.message.BaseContext;
import me.aurium.beetle.branch.handlers.api.Execution;
import me.aurium.beetle.branch.handlers.context.ContextProvider;
import me.aurium.beetle.branch.handlers.context.NodeContext;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInput;
import me.aurium.beetle.branch.nodes.results.SearchInfo;
import me.aurium.beetle.branch.nodes.results.model.Result;

public class OneBackStrategy<T> implements FallbackSearchStrategy<T> {

    @Override
    public Result<SearchInfo<T>> attemptPreprocess(T sender, String alias, String[] args, CommandNode<T> baseNode) {

        SearchInput input = SearchInput.of(args);
        SearchInfo<T> toBeExecuted = baseNode.getSpecificNode(input);


        //1. Check permissions and access (preprocessing)

        while (!toBeExecuted.resultingNode().getPermission().attempt(sender, alias, args)) {
            //something is wrong with the execution (e.g. wrong args or you did something bad), pass above one.

            if (toBeExecuted.resultingNode().equals(baseNode)) {
                return Result.fail(new NoPermissionResponse(baseNode));

            } else {
                toBeExecuted = baseNode.getSpecificNode(input.withoutTop()); //regress backwards a node
            }
        }

        return Result.success(toBeExecuted);
    }


    @Override
    public Result<Execution> attemptExecution(T sender, String alias, String[] args, CommandNode<T> baseNode, SearchInfo<T> result, BaseContext<T> baseContext, ContextProvider<T> producer) {
        NodeContext<T> produced = producer.produce(sender,alias,args,baseNode, result, baseContext);

        Result<Execution> info = result.resultingNode().getHandling().getExecution(produced);

        if (!info.isSuccessful()) {
            return info;
        }

        result.resultingNode().getHandling().getExecutionHandler().getExecution().orElseThrow().handle(produced); //this should never be null thanks to the preprocess
    }


    //TODO old code - refer to it if you need to
    /*SearchInput input = SearchInput.of(args);

    SearchResult<T> toBeExecuted = baseNode.getSpecificNode(input);

    Context<T> failed = producer.produce(sender,alias,args);

    //1. Check permissions and access (preprocessing)

        while (!toBeExecuted.resultingNode().getPermission().attempt(sender, alias, args) || toBeExecuted.resultingNode().getExecutionHandler().getExecution().isEmpty()) {
        //something is wrong with the execution (e.g. wrong args or you did something bad), pass above one.

        if (toBeExecuted.resultingNode().equals(baseNode)) {

            fallback.handle(failed);

            return Optional.empty();

        } else {
            toBeExecuted = baseNode.getSpecificNode(input.withoutTop()); //regress backwards a node
        }
    }

        return Optional.of(toBeExecuted);

    //execute and process

    NodeContext<T> produced = producer.produce(sender,alias,args,toBeExecuted.resultingNode(), baseNode, toBeExecuted.reducedPath(), toBeExecuted.initialPath(), fallback);

        toBeExecuted.resultingNode().getExecutionHandler().getExecution().get().handle(produced);*/
}
