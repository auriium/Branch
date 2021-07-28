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

package xyz.auriium.branch.fallback.strategies;

import xyz.auriium.branch.fallback.NoPermissionAnomaly;
import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.nodes.results.SearchInfo;
import xyz.auriium.branch.nodes.results.SearchInput;
import xyz.auriium.branch.nodes.results.model.Result;

/**
 * Simple fallback strategy that if the sender has no permission to execute the command they are sent a failing response.
 * @param <T>
 */
public class PermissionLockoutStrategy<T> implements FallbackSearchStrategy<T> {
    @Override
    public Result<SearchInfo<T>> attemptPreprocess(T sender, String alias, String[] args, CommandNode<T> baseNode) {

        SearchInput input = SearchInput.of(args);
        Result<SearchInfo<T>> toBeExecuted = baseNode.getSpecificNode(input);

        //peak object oriented code
        if (toBeExecuted.isSuccessful() && !toBeExecuted.getSuccess().resultingNode().getPermission().attempt(sender, alias, args)) {
            return Result.fail(new NoPermissionAnomaly(toBeExecuted.getSuccess().resultingNode().getPermission().failureIdentifiableName()));
        }

        return toBeExecuted;
    }
}
