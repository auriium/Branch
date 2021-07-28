package xyz.auriium.branch.centralized.base;

import xyz.auriium.branch.centralized.typeadapter.ManagerAdapter;
import xyz.auriium.branch.execution.ContextProvider;
import xyz.auriium.branch.fallback.strategies.FallbackSearchStrategy;
import xyz.auriium.branch.centralized.information.description.Description;
import xyz.auriium.branch.interfacing.exceptional.AnomalyHandler;
import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.nodes.IdentifiableNode;

/**
 * Adapting node base that delegates identifier calls to the first node in the base stack.
 */
public class DelegatingNodeBase<A,C extends A> extends RunNodeBase<A,C> {

    private final IdentifiableNode<C> baseNode;

    protected DelegatingNodeBase(ManagerAdapter<A, C> adapter, AnomalyHandler<A, C> handler, IdentifiableNode<C> baseNode, FallbackSearchStrategy<C> strategy, ContextProvider<C> provider) {
        super(adapter, handler, baseNode, strategy, provider);

        this.baseNode = baseNode;
    }


    @Override
    public Description getDescription() {
        return baseNode.getDescription();
    }

    @Override
    public String getIdentifier() {
        return baseNode.getIdentifier().getIdentifier();
    }
}
