package xyz.auriium.branch.centralized.base;

import xyz.auriium.branch.centralized.typeadapter.ManagerAdapter;
import xyz.auriium.branch.execution.ContextProvider;
import xyz.auriium.branch.execution.api.Execution;
import xyz.auriium.branch.fallback.strategies.FallbackSearchStrategy;
import xyz.auriium.branch.interfacing.handlers.InterfacingHandler;
import xyz.auriium.branch.nodes.CommandNode;

/**
 * Nodebase that simply runs the execution runnable
 * @param <I> input type
 * @param <A> adapted type
 */
public abstract class RunNodeBase<I,A extends I> extends AbstractNodeBase<I,A> {

    public RunNodeBase(ManagerAdapter<I, A> adapter, CommandNode<A> baseNode, FallbackSearchStrategy<A> strategy, ContextProvider<A> provider, InterfacingHandler<I> handler) {
        super(adapter, baseNode, strategy, provider, handler);
    }

    @Override
    void submitExecution(Execution<A> execution) {
        execution.run();
    }
}
