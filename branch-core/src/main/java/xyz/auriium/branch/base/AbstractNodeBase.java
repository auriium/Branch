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

import xyz.auriium.branch.base.suggestion.Suggestion;
import xyz.auriium.branch.base.suggestion.SuggestionSearchStrategy;
import xyz.auriium.branch.typeadapter.ManagerAdapter;
import xyz.auriium.branch.base.execution.Execution;
import xyz.auriium.branch.base.execution.ExecutionSearchStrategy;
import xyz.auriium.branch.interfacing.exceptional.AnomalyHandler;
import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.results.PreProcessSearch;
import xyz.auriium.branch.results.SearcherEquality;
import xyz.auriium.branch.results.Result;

import java.util.ArrayList;
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
    private final ExecutionSearchStrategy<A> executionStrategy;
    private final SuggestionSearchStrategy<A> suggestionStrategy;
    private final ContextProvider<A> provider;
    private final SearcherEquality equality;

    private final static List<String> EMPTY = new ArrayList<>();

    protected AbstractNodeBase(ManagerAdapter<I, A> adapter, AnomalyHandler<I, A> handler, CommandNode<A> baseNode, ExecutionSearchStrategy<A> executionStrategy, SuggestionSearchStrategy<A> suggestionStrategy, ContextProvider<A> provider, SearcherEquality equality) {
        this.adapter = adapter;
        this.handler = handler;
        this.baseNode = baseNode;
        this.executionStrategy = executionStrategy;
        this.suggestionStrategy = suggestionStrategy;
        this.provider = provider;
        this.equality = equality;
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
        NodeContext<A> produced = provider.produce(adaptedSender, alias, args);

        Result<PreProcessSearch<A>> preprocessResult = executionStrategy.attemptPreprocess(produced, equality, baseNode);

        if (!preprocessResult.isSuccessful()) {
            handler.communicateAdapted(adaptedSender, preprocessResult.getFailure());

            return;
        }

        PreProcessSearch<A> info = preprocessResult.getSuccess();

        Result<Execution<A>> executionResult = info.getFoundNode().searchExecute(produced, info);

        if (!executionResult.isSuccessful()) {
            handler.communicateAdapted(adaptedSender, preprocessResult.getFailure());

            return;
        }

        submitExecution(executionResult.getSuccess());
    }

    public List<String> suggest(I input, String alias, String[] args) {

        if (!adapter.canAdapt(input)) {
            handler.communicateNotAdapted(input, adapter.failedParseResponse(input));

            return EMPTY;
        }

        //have acquired C-type via parsing.

        A adaptedSender = adapter.adapt(input);
        NodeContext<A> produced = provider.produce(adaptedSender, alias, args);

        Result<PreProcessSearch<A>> preprocessResult = executionStrategy.attemptPreprocess(produced, equality, baseNode);

        if (!preprocessResult.isSuccessful()) {
            handler.communicateAdapted(adaptedSender, preprocessResult.getFailure());

            return EMPTY;
        }

        PreProcessSearch<A> info = preprocessResult.getSuccess();

        var searchResult = info.getFoundNode().searchSuggestion(produced, info);

        if (!searchResult.isSuccessful()) {
            handler.communicateAdapted(adaptedSender, searchResult.getFailure());

            return EMPTY;
        }

        List<Suggestion<A>> suggestions = searchResult.getSuccess();

        return suggestionStrategy.order(suggestions,produced);
    }



}
