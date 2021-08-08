package xyz.auriium.branch.base;

import xyz.auriium.branch.base.suggestion.SuggestionSearchStrategy;
import xyz.auriium.branch.typeadapter.ManagerAdapter;
import xyz.auriium.branch.base.execution.Execution;
import xyz.auriium.branch.base.execution.ExecutionSearchStrategy;
import xyz.auriium.branch.interfacing.exceptional.AnomalyHandler;
import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.results.SearcherEquality;

/**
 * Nodebase that simply runs the execution runnable
 * @param <I> input type
 * @param <A> adapted type
 */
public abstract class RunNodeBase<I,A extends I> extends AbstractNodeBase<I,A> {

    protected RunNodeBase(ManagerAdapter<I, A> adapter, AnomalyHandler<I, A> handler, CommandNode<A> baseNode, ExecutionSearchStrategy<A> executionStrategy, SuggestionSearchStrategy<A> suggestionStrategy, ContextProvider<A> provider, SearcherEquality equality) {
        super(adapter, handler, baseNode, executionStrategy, suggestionStrategy, provider, equality);
    }

    @Override
    void submitExecution(Execution<A> execution) {
        execution.run();
    }
}
