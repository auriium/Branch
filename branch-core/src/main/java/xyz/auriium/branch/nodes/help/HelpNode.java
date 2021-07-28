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

package xyz.auriium.branch.nodes.help;

import xyz.auriium.branch.execution.Block;
import xyz.auriium.branch.execution.NodeContext;
import xyz.auriium.branch.execution.StringBlock;
import xyz.auriium.branch.execution.api.BasicExecution;
import xyz.auriium.branch.execution.api.Execution;
import xyz.auriium.branch.execution.api.SuggestionHandler;
import xyz.auriium.branch.fallback.permissions.Permission;
import xyz.auriium.branch.centralized.information.description.Description;
import xyz.auriium.branch.nodes.EndpointNode;
import xyz.auriium.branch.nodes.results.SearchInfo;
import xyz.auriium.branch.nodes.results.SearchInput;
import xyz.auriium.branch.nodes.results.model.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node that pregenerates help entries based on the message context
 */
public class HelpNode<T> extends EndpointNode<T> {

    private final Block identifier;
    private final Permission<T> permission;
    private final Description description;

    public HelpNode(Block identifier, Permission<T> permission, Description description) {
        this.identifier = identifier;
        this.permission = permission;
        this.description = description;
    }

    @Override
    public Permission<T> getPermission() {
        return permission;
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
    public Result<Execution<T>> getExecution(NodeContext<T> context) {
        return Result.success(new BasicExecution<>(ct -> {

            List<Block> blocks = new ArrayList<>();
            String[] strong = ct.getArgs();

            for (int i = 0; i < strong.length - 1; i++) {
                blocks.add(StringBlock.of(strong[i]));
            }

            Result<SearchInfo<T>> toBeExecuted = context.getBaseExecutedNode().getSpecificNode(SearchInput.of(blocks));

            toBeExecuted.getSuccess().resultingNode();

        }, context));
    }

    @Override
    public SuggestionHandler<T> getSuggestionHandler() {
        return null; //TODO
    }

    public static <T> HelpNode<T> of(Permission<T> permission, Description description) {
        return new HelpNode<T>(new StringBlock("help"), permission, description);
    }
}
