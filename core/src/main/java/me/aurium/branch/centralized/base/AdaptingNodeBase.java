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

package me.aurium.branch.centralized.base;

import me.aurium.branch.centralized.typeadapter.ManagerAdapter;
import me.aurium.branch.execution.api.Execution;
import me.aurium.branch.execution.ContextProvider;
import me.aurium.branch.execution.NodeContext;
import me.aurium.branch.fallback.strategies.FallbackSearchStrategy;
import me.aurium.branch.interfacing.handlers.InterfacingHandler;
import me.aurium.branch.nodes.CommandNode;
import me.aurium.branch.nodes.results.SearchInfo;
import me.aurium.branch.nodes.results.model.Result;

import java.util.List;

/**
 * Represents a node base that has the ability to convert it's input sender to a sender of type C or fail with a result.
 * @param <T> the input type of nodebase
 * @param <C> the adapted adjusted type desired, based on a similar adapter.
 */
public class AdaptingNodeBase<T,C extends T> implements NodeBase<T> {

    private final ManagerAdapter<T,C> adapter;

    private final CommandNode<C> baseNode;
    private final FallbackSearchStrategy<C> strategy;
    private final ContextProvider<C> provider;
    private final InterfacingHandler<T> handler;

    public AdaptingNodeBase(ManagerAdapter<T, C> adapter, CommandNode<C> baseNode, FallbackSearchStrategy<C> strategy, ContextProvider<C> provider, InterfacingHandler<T> handler) {
        this.adapter = adapter;
        this.baseNode = baseNode;
        this.strategy = strategy;
        this.provider = provider;
        this.handler = handler;
    }

    public void execute(T t, String alias, String[] args) {
        if (!adapter.canAdapt(t)) {
            handler.sendMessage(t,adapter.failedParseResponse(t));
            return;
        }

        C adaptedSender = adapter.adapt(t);

        Result<SearchInfo<C>> result = strategy.attemptPreprocess(adaptedSender,alias,args,baseNode);

        if (!result.isSuccessful()) {
            handler.sendMessage(t, result.getFailure());
            return;
        }

        SearchInfo<C> info = result.getSuccess();
        NodeContext<C> produced = provider.produce(adaptedSender,alias,args,baseNode,info);

        Result<Execution<C>> execution = info.resultingNode().getHandling().getExecution(produced);

        if (!execution.isSuccessful()) {
            handler.sendMessage(t, execution.getFailure());
            return;
        }

        execution.getSuccess().run();
    }

    public List<String> suggest(T t, String alias, String[] args) {
        return null; //TODO
    }
}
