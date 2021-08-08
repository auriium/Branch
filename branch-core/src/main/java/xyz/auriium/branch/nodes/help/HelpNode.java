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

import xyz.auriium.branch.nodes.description.StringDescription;
import xyz.auriium.branch.base.NodeContext;
import xyz.auriium.branch.base.execution.Execution;
import xyz.auriium.branch.base.execution.blocks.EndpointBlock;
import xyz.auriium.branch.base.permissions.EmptyPermission;
import xyz.auriium.branch.base.permissions.Permission;
import xyz.auriium.branch.nodes.description.Description;
import xyz.auriium.branch.nodes.EndpointNode;
import xyz.auriium.branch.results.PreProcessSearch;
import xyz.auriium.branch.results.Result;

/**
 * Represents a node that pregenerates help entries based on the message context
 */
public class HelpNode<T> implements EndpointNode<T> {

    private final EndpointBlock identifier;
    private final Permission<T> permission;
    private final Description description;

    public HelpNode(String name, Permission<T> permission, Description description) {
        this.identifier = new EndpointBlock(name);
        this.permission = permission;
        this.description = description;
    }

    @Override
    public Permission<T> getPermission() {
        return permission;
    }

    @Override
    public EndpointBlock getIdentifier() {
        return identifier;
    }

    @Override
    public Description getDescription() {
        return description;
    }

    @Override
    public Result<Execution<T>> searchExecute(NodeContext<T> ctx, PreProcessSearch<T> input) {

        /*List<Block> blocks = new ArrayList<>();
            String[] strong = ct.getArgs();

            for (int i = 0; i < strong.length - 1; i++) {
                blocks.add(StringBlock.of(strong[i]));
            }

            Result<SearchInfo<T>> toBeExecuted = context.getBaseExecutedNode().getSpecificNode(SearchInput.of(blocks));

            toBeExecuted.getSuccess().resultingNode();*/

        return null;
    }

    public static <T> HelpNode<T> of() {
        return new HelpNode<>("help", EmptyPermission.instance(), new StringDescription("Default help command"));
    }

    public static <T> HelpNode<T> of(String name, Permission<T> permission, Description description) {
        return new HelpNode<>(name, permission, description);
    }

    public static <T> HelpNode<T> of(Permission<T> permission, Description description) {
        return new HelpNode<>("help", permission, description);
    }
}
