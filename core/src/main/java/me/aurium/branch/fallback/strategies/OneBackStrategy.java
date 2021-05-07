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

package me.aurium.branch.fallback.strategies;

import me.aurium.branch.interfacing.responses.NoPermissionResponse;
import me.aurium.branch.nodes.CommandNode;
import me.aurium.branch.nodes.results.SearchInput;
import me.aurium.branch.nodes.results.SearchInfo;
import me.aurium.branch.nodes.results.model.Result;

/**
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
public class OneBackStrategy<T> implements FallbackSearchStrategy<T> {

    @Override
    public Result<SearchInfo<T>> attemptPreprocess(T sender, String alias, String[] args, CommandNode<T> baseNode) {

        SearchInput input = SearchInput.of(args);
        SearchInfo<T> toBeExecuted = baseNode.getSpecificNode(input);


        //1. Check permissions and access (preprocessing)

        while (!toBeExecuted.resultingNode().getPermission().attempt(sender, alias, args)) {
            //something is wrong with the execution (e.g. wrong args or you did something bad), pass above one.

            if (toBeExecuted.resultingNode().equals(baseNode)) {
                return Result.fail(new NoPermissionResponse(baseNode.getPermission().failureIdentifiableName()));

            } else {
                toBeExecuted = baseNode.getSpecificNode(input.withoutTop()); //regress backwards a node
            }
        }

        return Result.success(toBeExecuted);
    }



    //TODO old code - refer to it if you need to
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
