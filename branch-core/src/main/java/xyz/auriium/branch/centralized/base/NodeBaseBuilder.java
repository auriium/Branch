/*
 *
 *  Branch
 *  Copyright © 2021 Aurium
 *
 *  Branch is free software: you can redistribute it and/or modify
 *  It under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *
 *  Branch is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with Branch. If not, see <https://www.gnu.org/licenses/>
 *  and navigate to version 3 of the GNU Affero General Public License.
 *
 */

package xyz.auriium.branch.centralized.base;

import xyz.auriium.branch.centralized.CentralizedManager;
import xyz.auriium.branch.centralized.typeadapter.ManagerAdapter;
import xyz.auriium.branch.execution.ContextProvider;
import xyz.auriium.branch.fallback.strategies.FallbackSearchStrategy;
import xyz.auriium.branch.interfacing.handlers.InterfacingHandler;
import xyz.auriium.branch.nodes.IdentifiableNode;

import java.util.*;

/**
 * Default implementation of a class that produces adaptingNodeBases
 *
 * @param <T> Input type
 * @param <C> Adapted type
 */
public class NodeBaseBuilder<T,C extends T> {

    private final CentralizedManager<T,?> manager;
    private final ManagerAdapter<T,C> adapter;

    private IdentifiableNode<C> node;
    private FallbackSearchStrategy<C> strategy;
    private ContextProvider<C> provider;
    private InterfacingHandler<T> handler;

    private final List<String> aliases = new ArrayList<>();

    public NodeBaseBuilder(CentralizedManager<T, ?> manager, ManagerAdapter<T, C> adapter) {
        this.manager = manager;
        this.adapter = adapter;
    }

    public NodeBaseBuilder(CentralizedManager<T, ?> manager, ManagerAdapter<T, C> adapter, FallbackSearchStrategy<C> strategy, ContextProvider<C> provider, InterfacingHandler<T> handler) {
        this.manager = manager;
        this.adapter = adapter;
        this.strategy = strategy;
        this.provider = provider;
        this.handler = handler;
    }

    public NodeBaseBuilder<T,C> withNode(IdentifiableNode<C> node) {
        this.node = node;

        return this;
    }

    public NodeBaseBuilder<T,C> withAliases(String... aliases) {
        this.aliases.addAll(Arrays.asList(aliases));

        return this;
    }

    public NodeBaseBuilder<T,C> customStrategy(FallbackSearchStrategy<C> strategy) {
        this.strategy = strategy;

        return this;
    }

    public NodeBaseBuilder<T,C> customProvider(ContextProvider<C> provider) {
        this.provider = provider;

        return this;
    }

    public NodeBaseBuilder<T,C> customInterfacing(InterfacingHandler<T> handler) {
        this.handler = handler;

        return this;
    }

    public void finish() {
        Objects.requireNonNull(node);
        Objects.requireNonNull(strategy);
        Objects.requireNonNull(provider);
        Objects.requireNonNull(handler);

        manager.newCommand(new DelegatingNodeBase<>(adapter,node,strategy,provider,handler));
    }
}
