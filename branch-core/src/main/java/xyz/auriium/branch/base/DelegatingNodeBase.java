package xyz.auriium.branch.base;

import xyz.auriium.branch.base.suggestion.SuggestionSearchStrategy;
import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.typeadapter.ManagerAdapter;
import xyz.auriium.branch.base.execution.ExecutionSearchStrategy;
import xyz.auriium.branch.nodes.description.Description;
import xyz.auriium.branch.interfacing.exceptional.AnomalyHandler;
import xyz.auriium.branch.nodes.IdentifiableNode;
import xyz.auriium.branch.results.SearcherEquality;

/**
 * Adapting node base that delegates identifier calls to the first node in the base stack.
 */
public class DelegatingNodeBase<A,C extends A> extends RunNodeBase<A,C> {

    private final IdentifiableNode<C> baseNode;

    public DelegatingNodeBase(ManagerAdapter<A, C> adapter, AnomalyHandler<A, C> handler, IdentifiableNode<C> baseNode, ExecutionSearchStrategy<C> executionStrategy, SuggestionSearchStrategy<C> suggestionStrategy, ContextProvider<C> provider, SearcherEquality equality) {
        super(adapter, handler, baseNode, executionStrategy, suggestionStrategy, provider, equality);
        this.baseNode = baseNode;
    }

    @Override
    public Description getDescription() {
        return baseNode.getDescription();
    }

    @Override
    public String getIdentifier() {
        return baseNode.getIdentifier().getLabel();
    }
}
