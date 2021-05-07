package me.aurium.branch.centralized.base;

import me.aurium.branch.centralized.typeadapter.ManagerAdapter;
import me.aurium.branch.execution.ContextProvider;
import me.aurium.branch.fallback.strategies.FallbackSearchStrategy;
import me.aurium.branch.information.description.Description;
import me.aurium.branch.interfacing.handlers.InterfacingHandler;
import me.aurium.branch.nodes.CommandNode;
import me.aurium.branch.nodes.IdentifiableNode;

/**
 * Adapting node base that delegates identifier calls to the first node in the base stack.
 * @param <T> t
 * @param <C> c
 */
public class DelegatingNodeBase<T,C extends T> extends AdaptingNodeBase<T,C> {

    private final IdentifiableNode<C> baseNode;

    public DelegatingNodeBase(ManagerAdapter<T, C> adapter, IdentifiableNode<C> baseNode, FallbackSearchStrategy<C> strategy, ContextProvider<C> provider, InterfacingHandler<T> handler) {
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
