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

import xyz.auriium.branch.centralized.typeadapter.ManagerAdapter;
import xyz.auriium.branch.execution.api.Execution;
import xyz.auriium.branch.execution.ContextProvider;
import xyz.auriium.branch.execution.NodeContext;
import xyz.auriium.branch.fallback.strategies.FallbackSearchStrategy;
import xyz.auriium.branch.interfacing.exceptional.AnomalyHandler;
import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.nodes.results.SearchInfo;
import xyz.auriium.branch.nodes.results.model.Result;

import java.util.List;

/**
 * Represents a node base that has the ability to convert it's input sender to a sender of type C or fail with a result.
 * @param <I> the input type of nodebase
 * @param <A> the adjusted type desired by the output of the {@link ManagerAdapter} found in this nodebase
 */
public abstract class AbstractNodeBase<I, A extends I> implements NodeBase<I> {


    private final ManagerAdapter<I, A> adapter;
    private final AnomalyHandler<I, A> handler;

    private final CommandNode<A> baseNode;
    private final FallbackSearchStrategy<A> strategy;
    private final ContextProvider<A> provider;

    protected AbstractNodeBase(ManagerAdapter<I, A> adapter, AnomalyHandler<I, A> handler, CommandNode<A> baseNode, FallbackSearchStrategy<A> strategy, ContextProvider<A> provider) {
        this.adapter = adapter;
        this.handler = handler;
        this.baseNode = baseNode;
        this.strategy = strategy;
        this.provider = provider;
    }


    /**
     * Method for execution of runnable once runnable is found
     * Exists in order to allow for concurrent-type nodebases
     *
     * @param execution the runnable
     */
    abstract void submitExecution(Execution<A> execution);

    public void execute(I input, String alias, String[] args) {
        //have not aqcuired C-type (cannot use Result object or message handling-parsing)

        if (!adapter.canAdapt(input)) {
            handler.communicateNotAdapted(input, adapter.failedParseResponse(input));

            return;
        }

        //have acquired C-type via parsing.

        A adaptedSender = adapter.adapt(input);

        Result<SearchInfo<A>> result = strategy.attemptPreprocess(adaptedSender,alias,args,baseNode);

        if (!result.isSuccessful()) {
            handler.communicateAdapted(adaptedSender, result.getFailure());

            return;
        }

        SearchInfo<A> info = result.getSuccess();
        NodeContext<A> produced = provider.produce(adaptedSender,alias,args,baseNode,info);

        Result<Execution<A>> executionResult = info.resultingNode().getExecution(produced);

        if (!executionResult.isSuccessful()) {
            handler.communicateAdapted(adaptedSender, result.getFailure());

            return;
        }

        submitExecution(executionResult.getSuccess());
    }

    public List<String> suggest(I input, String alias, String[] args) {
        return null; //TODO
    }

}
