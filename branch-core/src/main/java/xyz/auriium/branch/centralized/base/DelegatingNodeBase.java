package xyz.auriium.branch.centralized.base;

import xyz.auriium.branch.centralized.typeadapter.ManagerAdapter;
import xyz.auriium.branch.execution.ContextProvider;
import xyz.auriium.branch.fallback.strategies.FallbackSearchStrategy;
import xyz.auriium.branch.interfacing.information.description.Description;
import xyz.auriium.branch.interfacing.handlers.InterfacingHandler;
import xyz.auriium.branch.nodes.IdentifiableNode;

/**
 * Adapting node base that delegates identifier calls to the first node in the base stack.
 */
public class DelegatingNodeBase<A,C extends A> extends RunNodeBase<A,C> {

    private final IdentifiableNode<C> baseNode;

    public DelegatingNodeBase(ManagerAdapter<A, C> adapter, IdentifiableNode<C> baseNode, FallbackSearchStrategy<C> strategy, ContextProvider<C> provider, InterfacingHandler<A> handler) {
        super(adapter, baseNode, strategy, provider, handler);

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
