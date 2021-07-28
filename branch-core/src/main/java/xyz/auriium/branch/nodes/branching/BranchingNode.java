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

package xyz.auriium.branch.nodes.branching;

import xyz.auriium.branch.execution.Block;
import xyz.auriium.branch.execution.api.Execution;
import xyz.auriium.branch.execution.NodeContext;
import xyz.auriium.branch.execution.api.SuggestionHandler;
import xyz.auriium.branch.centralized.information.description.Description;
import xyz.auriium.branch.nodes.IdentifiableNode;
import xyz.auriium.branch.fallback.permissions.Permission;
import xyz.auriium.branch.nodes.results.model.Result;
import xyz.auriium.branch.nodes.results.SearchInfo;
import xyz.auriium.branch.nodes.results.SearchInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Nodes should always assume that the first block in the blockpath is theirs to consume
 *
 * @param <T>
 */
public class BranchingNode<T> implements IdentifiableNode<T> {

    private final PrestoredSet<T> nodes;
    private final Block path;
    private final Description description;
    private final Permission<T> permission;
    private final SuggestionHandler<T> suggestion;

    public BranchingNode(PrestoredSet<T> nodes, Block path, Description description, Permission<T> permission) {
        this.nodes = nodes;
        this.path = path;
        this.description = description;
        this.permission = permission;
        this.suggestion = (ctx) -> {
            List<Block> strings = new ArrayList<>();

            for (IdentifiableNode<T> node : nodes.getContents()) {
                if (node.getPermission().attempt(ctx)) {
                    strings.add(node.getIdentifier());
                }
            }

            return strings;
        };
    }

    @Override
    public Block getIdentifier() {
        return path;
    }

    @Override
    public Description getDescription() {
        return description;
    }

    //args[] = join aMatch
    //let's say this is the base
    @Override
    public Result<SearchInfo<T>> getSpecificNode(SearchInput input) {
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

        return Result.success(new SearchInfo<>(this,input));
    }

    @Override
    public Permission<T> getPermission() {
        return permission;
    }

    @Override
    public Result<Execution<T>> getExecution(NodeContext<T> context) {
        return nodes.getSideNode().getExecution(context);
    }

    @Override
    public SuggestionHandler<T> getSuggestionHandler() {
        return suggestion;
    }


}
