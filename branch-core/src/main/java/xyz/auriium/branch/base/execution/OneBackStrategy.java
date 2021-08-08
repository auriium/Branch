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

package xyz.auriium.branch.base.execution;

import xyz.auriium.branch.base.NodeContext;
import xyz.auriium.branch.interfacing.exceptional.anomalies.NoPermissionAnomaly;
import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.results.InitialSearch;
import xyz.auriium.branch.results.PreProcessSearch;
import xyz.auriium.branch.results.Result;
import xyz.auriium.branch.results.SearcherEquality;

/**
 *
 * Fallback and processing strategy that does the following actions:
 *
 * Attempts to get a node via arguments search. It then checks if the user has permission to access the node.
 * If they do not, it falls back a single node and checks again. This repeats until the user has permission or
 * until the search reaches the base node, in which case a response is fired as a failure.
 *
 * In practice:
 *
 * Node tree looks like
 *
 * /kitpvp moderation ban
 * /kitpvp moderation kick
 *
 * User has permissions for kitpvp.moderation but not kitpvp.moderation.ban and tries to execute kitpvp moderation ban
 *
 * Searcher sees no permissions for ban command and so it falls back to the no-args of /kitpvp moderation which is
 * then executed.
 *
 * @param <T>
 */
public class OneBackStrategy<T> implements ExecutionSearchStrategy<T> {

    @Override
    public Result<PreProcessSearch<T>> attemptPreprocess(NodeContext<T> ctx, SearcherEquality equality, CommandNode<T> baseNode) {

        InitialSearch<T> search = InitialSearch.of(equality, ctx.getArgs());
        Result<PreProcessSearch<T>> toBeExecuted = baseNode.searchNode(search);


        //1. Check permissions and access (preprocessing)

        while (toBeExecuted.isSuccessful() && !toBeExecuted.getSuccess().getFoundNode().getPermission().attempt(ctx)) {
            //something is wrong with the execution (e.g. wrong args or you did something bad), pass above one.

            if (toBeExecuted.getSuccess().getFoundNode().equals(baseNode)) {
                return Result.fail(new NoPermissionAnomaly(baseNode.getPermission().failureIdentifiableName()));

            } else {
                toBeExecuted = baseNode.searchNode(search = InitialSearch.withoutTop(search)); //regress backwards a node //TODO fix all of this
            }
        }

        return toBeExecuted;
    }


    /*SearchInput input = SearchInput.of(args);

    SearchResult<T> toBeExecuted = baseNode.getSpecificNode(input);

    Context<T> failed = producer.produce(sender,alias,args);

    //1. Check permissions and access (preprocessing)

        while (!toBeExecuted.resultingNode().getPermission().attempt(sender, alias, args) || toBeExecuted.resultingNode().getExecutionHandler().getExecution().isEmpty()) {
        //something is wrong with the execution (e.g. wrong args or you did something bad), pass above one.

        if (toBeExecuted.resultingNode().equals(baseNode)) {

            fallback.handle(failed);

            return Optional.empty();

        } else {
            toBeExecuted = baseNode.getSpecificNode(input.withoutTop()); //regress backwards a node
        }
    }

        return Optional.of(toBeExecuted);

    //execute and process

    NodeContext<T> produced = producer.produce(sender,alias,args,toBeExecuted.resultingNode(), baseNode, toBeExecuted.reducedPath(), toBeExecuted.initialPath(), fallback);

        toBeExecuted.resultingNode().getExecutionHandler().getExecution().get().handle(produced);*/
}
