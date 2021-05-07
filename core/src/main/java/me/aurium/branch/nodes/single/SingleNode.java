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

package me.aurium.branch.nodes.single;

import me.aurium.branch.execution.Block;
import me.aurium.branch.execution.api.BranchHandler;
import me.aurium.branch.execution.api.ExecutionHandler;
import me.aurium.branch.execution.api.Execution;
import me.aurium.branch.execution.NodeContext;
import me.aurium.branch.information.description.Description;
import me.aurium.branch.nodes.results.SearchInfo;
import me.aurium.branch.fallback.permissions.Permission;
import me.aurium.branch.nodes.results.model.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node that can do one action and takes no arguments and has no tabcompletion
 * @param <T> the type of executor
 */
public class SingleNode<T> extends EndpointNode<T> {

    private final Block identifier;
    private final Permission<T> permission;
    private final SingleHandler<T> handler;
    private final Description description;

    public SingleNode(Block identifier, ExecutionHandler<T> executionHandler, Permission<T> permission, Description description) {
        this.identifier = identifier;

        this.handler = new SingleHandler<>(executionHandler);
        this.permission = permission;
        this.description = description;
    }

    @Override
    public Block getIdentifier() {
        return identifier;
    }

    @Override
    public Description getDescription() {
        return description;
    }

    @Override
    public BranchHandler<T> getHandling() {
        return handler;
    }

    @Override
    public Permission<T> getPermission() {
        return permission;
    }

    public static class SingleHandler<T> implements BranchHandler<T> {

        private final ExecutionHandler<T> handler;

        public SingleHandler(ExecutionHandler<T> handler) {
            this.handler = handler;
        }

        @Override
        public Execution<T> getExecution(NodeContext<T> context) {
            SearchInfo<T> info = context.getResults();

            /*if (info.hasMoreArguments()) {
                return Result.fail(
                        new TooManyArgsResponse(0,info.reducedPath().size()) //TODO move this to search details
                );
            }*/

            return new Execution<>(handler,context);
        }

        @Override
        public List<String> getSuggestions(NodeContext<T> context) {
            return new ArrayList<>();
        }

    }



}
