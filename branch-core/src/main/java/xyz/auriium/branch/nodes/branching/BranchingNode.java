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

import xyz.auriium.branch.base.suggestion.Suggestion;
import xyz.auriium.branch.nodes.description.StringDescription;
import xyz.auriium.branch.base.execution.Execution;
import xyz.auriium.branch.base.NodeContext;
import xyz.auriium.branch.nodes.description.Description;
import xyz.auriium.branch.base.execution.blocks.GroupBlock;
import xyz.auriium.branch.base.permissions.EmptyPermission;
import xyz.auriium.branch.nodes.IdentifiableNode;
import xyz.auriium.branch.base.permissions.Permission;
import xyz.auriium.branch.results.Result;
import xyz.auriium.branch.results.InitialSearch;
import xyz.auriium.branch.results.PreProcessSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Nodes should always assume that the first block in the blockpath is theirs to consume TODO write docs
 *
 * TODO make ordered
 *
 * @param <T>
 */
public class BranchingNode<T> implements IdentifiableNode<T> {

    private final GroupBlock identifier;
    private final PreStoredList<T> nodes;
    private final Description description;
    private final Permission<T> permission;

    public BranchingNode(String identifier, PreStoredList<T> nodes, Description description, Permission<T> permission) {
        this.nodes = nodes;
        this.identifier = new GroupBlock(identifier);
        this.description = description;
        this.permission = permission;
    }

    @Override
    public Result<List<Suggestion<T>>> searchSuggestion(NodeContext<T> ctx, PreProcessSearch<T> input) {

        List<Suggestion<T>> suggestions = new ArrayList<>();

        for (IdentifiableNode<T> node : nodes.getContents()) {
            suggestions.add(new Suggestion<>(node.getPermission(), node.getIdentifier()));
        }

        return Result.success(suggestions);

    }

    @Override
    public GroupBlock getIdentifier() {
        return identifier;
    }

    @Override
    public Description getDescription() {
        return description;
    }

    @Override
    public Permission<T> getPermission() {
        return permission;
    }

    @Override
    public Result<PreProcessSearch<T>> searchNode(InitialSearch<T> input) {

        if (!input.getRemainingStrings().isEmpty()) {
            String popped = input.getRemainingStrings().peek(); //reveal

            for (IdentifiableNode<T> node : nodes.getContents()) {
                if (input.getEquality().equal(identifier,popped)) {
                    input.getRemainingStrings().remove(); //pop string

                    return node.searchNode(input); //consume
                }
            }

        }

        return nodes.getSideNode().searchNode(input);
    }

    @Override
    public Result<Execution<T>> searchExecute(NodeContext<T> ctx, PreProcessSearch<T> input) {
        return nodes.getSideNode().searchExecute(ctx, input);
    }

    public static <T> BranchingNode<T> of(String identifier, PreStoredList<T> nodes, Description description, Permission<T> permission) {
        return new BranchingNode<>(identifier, nodes, description, permission);
    }

    public static <T> BranchingNode<T> of(String identifier, PreStoredList<T> nodes) {
        return new BranchingNode<>(identifier, nodes, new StringDescription("Default description for branching command"), EmptyPermission.instance());
    }
}
