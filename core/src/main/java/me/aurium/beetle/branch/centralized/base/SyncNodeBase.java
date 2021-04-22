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

package me.aurium.beetle.branch.centralized.base;

import me.aurium.beetle.branch.execution.api.Execution;
import me.aurium.beetle.branch.execution.context.ContextProvider;
import me.aurium.beetle.branch.execution.context.NodeContext;
import me.aurium.beetle.branch.interfacing.handlers.InterfacingHandler;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.fallback.strategies.FallbackSearchStrategy;
import me.aurium.beetle.branch.nodes.results.SearchInfo;
import me.aurium.beetle.branch.nodes.results.model.Result;

import java.util.List;

/**
 * Represents a nodebase that will search for executions synchronously
 * it will also search for suggestions synchronously
 * @param <C>
 */
public class SyncNodeBase<C> implements NodeBase<C> {

    private final CommandNode<C> baseNode;
    private final FallbackSearchStrategy<C> strategy;

    private final ContextProvider<C> provider;
    private final InterfacingHandler<C> handler;

    public SyncNodeBase(CommandNode<C> baseNode, FallbackSearchStrategy<C> strategy, ContextProvider<C> provider, InterfacingHandler<C> handler) {
        this.baseNode = baseNode;
        this.provider = provider;
        this.strategy = strategy;
        this.handler = handler;
    }

    @Override
    public void execute(C executor, String alias, String[] args) {
        Result<SearchInfo<C>> result = strategy.attemptPreprocess(executor,alias,args,baseNode);

        if (!result.isSuccessful()) {
            handler.sendMessage(executor, result.getFailure());
            return;
        }

        SearchInfo<C> info = result.getSuccess();
        NodeContext<C> produced = provider.produce(executor,alias,args,baseNode,info);

        Result<Execution<C>> execution = info.resultingNode().getHandling().getExecution(produced);

        if (!execution.isSuccessful()) {
            handler.sendMessage(executor, execution.getFailure());
            return;
        }

        execution.getSuccess().run();
    }

    @Override
    public List<String> suggest(C c, String alias, String[] args) {
        return null;
    }
}
