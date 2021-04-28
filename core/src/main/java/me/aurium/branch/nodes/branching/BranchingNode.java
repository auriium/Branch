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

package me.aurium.branch.nodes.branching;

import me.aurium.branch.execution.Block;
import me.aurium.branch.execution.api.BranchHandler;
import me.aurium.branch.execution.api.Execution;
import me.aurium.branch.execution.NodeContext;
import me.aurium.branch.interfacing.responses.NoIntegratedArgsResponse;
import me.aurium.branch.nodes.IdentifiableNode;
import me.aurium.branch.fallback.permissions.Permission;
import me.aurium.branch.nodes.results.model.Result;
import me.aurium.branch.nodes.results.SearchInfo;
import me.aurium.branch.nodes.results.SearchInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Nodes should always assume that the first block in the blockpath is theirs to consume
 *
 * @param <T>
 */
public class BranchingNode<T> implements IdentifiableNode<T> {

    private final PrestoredSet<T> nodes;
    private final Block path;
    private final BranchHandler<T> handler;

    private final Permission<T> permission;

    public BranchingNode(PrestoredSet<T> nodes, Block path, Permission<T> permission) {
        this.nodes = nodes;
        this.path = path;
        this.permission = permission;

        this.handler = new BranchingHandler<>(nodes);
    }

    @Override
    public Block getIdentifier() {
        return path;
    }

    //args[] = join aMatch
    //let's say this is the base
    @Override
    public SearchInfo<T> getSpecificNode(SearchInput input) {
        //if there is something left, the first thing in the queue is our argument
        //if there is nothing left no args time

        if (!input.getReducablePath().isEmpty()) {
            Block block = input.getReducablePath().getFirst(); //reveal

            for (IdentifiableNode<T> node : nodes.getContents()) {
                if (node.getIdentifier().equals(block)) {
                    return node.getSpecificNode(input); //consume
                }
            }

        }

        return new SearchInfo<>(this,input);
    }

    @Override
    public BranchHandler<T> getHandling() {
        return handler;
    }

    @Override
    public Permission<T> getPermission() {
        return permission;
    }

    public static final class BranchingHandler<T> implements BranchHandler<T> {

        private final PrestoredSet<T> nodeShit;

        public BranchingHandler(PrestoredSet<T> nodeShit) {
            this.nodeShit = nodeShit;
        }


        @Override
        public Result<Execution<T>> getExecution(NodeContext<T> context) {
            if (nodeShit.getSideNode() == null) {
                return Result.fail(NoIntegratedArgsResponse.of(context));
            } else {
                return nodeShit.getSideNode().getHandling().getExecution(context);
            }
        }

        @Override
        public List<String> getSuggestions(NodeContext<T> context) {

            //TODO fix this bullshit, add close-to-queue
            return nodeShit.getContents().stream().map(s -> s.getIdentifier().getIdentifier()).collect(Collectors.toList());
        }

    }


}
