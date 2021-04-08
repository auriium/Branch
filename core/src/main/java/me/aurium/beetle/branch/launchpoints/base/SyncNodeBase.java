package me.aurium.beetle.branch.launchpoints.base;

import me.aurium.beetle.branch.handlers.api.Execution;
import me.aurium.beetle.branch.handlers.context.ContextProvider;
import me.aurium.beetle.branch.handlers.context.NodeContext;
import me.aurium.beetle.branch.interfacing.handlers.InterfacingHandler;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.fallback.strategies.FallbackSearchStrategy;
import me.aurium.beetle.branch.nodes.results.SearchInfo;
import me.aurium.beetle.branch.nodes.results.model.Result;

import java.util.List;

/**
 * Represents a nodebase that will perform it's executions synchronously
 * @param <C>
 */
public class SyncNodeBase<C> implements NodeBase<C> {

    private final CommandNode<C> baseNode;
    private final FallbackSearchStrategy<C> strategy;

    private final ContextProvider<C> provider;
    private final InterfacingHandler<C> handler;

    public SyncNodeBase(CommandNode<C> baseNode, FallbackSearchStrategy<C> strategy, ContextProvider<C> provider, InterfacingHandler<C> handler) {
        this.baseNode = baseNode;
        this.provider = provider;
        this.strategy = strategy;
        this.handler = handler;
    }

    @Override
    public void execute(C executor, String alias, String[] args) {
        Result<SearchInfo<C>> result = strategy.attemptPreprocess(executor,alias,args,baseNode);

        if (!result.isSuccessful()) {
            handler.sendMessage(executor, result.getFailure());
            return;
        }

        SearchInfo<C> info = result.getSuccess();
        NodeContext<C> produced = provider.produce(executor,alias,args,baseNode,info);

        Result<Execution<C>> execution = info.resultingNode().getHandling().getExecution(produced);

        if (!execution.isSuccessful()) {
            handler.sendMessage(executor, execution.getFailure());
            return;
        }

        execution.getSuccess().run();
    }

    @Override
    public List<String> suggest(C c, String alias, String[] args) {
        return null;
    }
}
