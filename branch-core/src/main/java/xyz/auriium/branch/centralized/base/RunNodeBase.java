package xyz.auriium.branch.centralized.base;

import xyz.auriium.branch.centralized.typeadapter.ManagerAdapter;
import xyz.auriium.branch.execution.ContextProvider;
import xyz.auriium.branch.execution.api.Execution;
import xyz.auriium.branch.fallback.strategies.FallbackSearchStrategy;
import xyz.auriium.branch.interfacing.exceptional.AnomalyHandler;
import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.nodes.results.SearcherEquality;

/**
 * Nodebase that simply runs the execution runnable
 * @param <I> input type
 * @param <A> adapted type
 */
public abstract class RunNodeBase<I,A extends I> extends AbstractNodeBase<I,A> {

    protected RunNodeBase(ManagerAdapter<I, A> adapter, AnomalyHandler<I, A> handler, CommandNode<A> baseNode, FallbackSearchStrategy<A> strategy, ContextProvider<A> provider, SearcherEquality equality) {
        super(adapter, handler, baseNode, strategy, provider, equality);
    }

    @Override
    void submitExecution(Execution<A> execution) {
        execution.run();
    }
}
