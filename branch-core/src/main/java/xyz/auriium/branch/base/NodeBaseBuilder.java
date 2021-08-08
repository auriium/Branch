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

package xyz.auriium.branch.base;

import xyz.auriium.branch.CentralizedManager;
import xyz.auriium.branch.typeadapter.ManagerAdapter;
import xyz.auriium.branch.base.execution.ExecutionSearchStrategy;
import xyz.auriium.branch.interfacing.exceptional.AnomalyHandler;
import xyz.auriium.branch.nodes.IdentifiableNode;
import xyz.auriium.branch.results.SearcherEquality;

import java.util.*;

/**
 * Default implementation of a class that produces adaptingNodeBases
 *
 * @param <I> Input type
 * @param <A> Adapted type
 */
public class NodeBaseBuilder<I, A extends I> {

    private final CentralizedManager<I,?> manager;

    private final ManagerAdapter<I, A> adapter;
    private AnomalyHandler<I,A> handler;

    private IdentifiableNode<A> node;
    private ExecutionSearchStrategy<A> strategy;
    private ContextProvider<A> provider;
    private SearcherEquality equality;

    public NodeBaseBuilder(CentralizedManager<I, ?> manager, ManagerAdapter<I, A> adapter) {
        this.manager = manager;
        this.adapter = adapter;
    }

    public NodeBaseBuilder(CentralizedManager<I, ?> manager, ManagerAdapter<I, A> adapter, ExecutionSearchStrategy<A> strategy, ContextProvider<A> provider, AnomalyHandler<I,A> handler, SearcherEquality equality) {
        this.manager = manager;
        this.adapter = adapter;
        this.strategy = strategy;
        this.provider = provider;
        this.handler = handler;
        this.equality = equality;
    }

    public NodeBaseBuilder<I, A> withNode(IdentifiableNode<A> node) {
        this.node = node;

        return this;
    }

    public NodeBaseBuilder<I, A> customStrategy(ExecutionSearchStrategy<A> strategy) {
        this.strategy = strategy;

        return this;
    }

    public NodeBaseBuilder<I, A> customProvider(ContextProvider<A> provider) {
        this.provider = provider;

        return this;
    }

    public NodeBaseBuilder<I, A> customInterfacing(AnomalyHandler<I,A> handler) {
        this.handler = handler;

        return this;
    }



    public void finish() {
        Objects.requireNonNull(node, "Node cannot be null!");
        Objects.requireNonNull(strategy, "Strategy cannot be null!");
        Objects.requireNonNull(provider, "Provider cannot be null!");
        Objects.requireNonNull(handler, "AnomalyHandler cannot be null!");
        Objects.requireNonNull(equality, "SearcherEquality cannot be null!");

        manager.newCommand(new DelegatingNodeBase<>(adapter,handler,node,strategy,provider,equality));
    }
}
