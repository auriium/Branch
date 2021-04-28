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
import me.aurium.branch.nodes.results.SearchInfo;
import me.aurium.branch.nodes.results.SearchInput;
import me.aurium.branch.nodes.results.model.Result;

/**
 * Simple fallback strategy that if the sender has no permission to execute the command they are sent a failing response.
 * @param <T>
 */
public class PermissionLockoutStrategy<T> implements FallbackSearchStrategy<T> {
    @Override
    public Result<SearchInfo<T>> attemptPreprocess(T sender, String alias, String[] args, CommandNode<T> baseNode) {

        SearchInput input = SearchInput.of(args);
        SearchInfo<T> toBeExecuted = baseNode.getSpecificNode(input);

        if (!toBeExecuted.resultingNode().getPermission().attempt(sender, alias, args)) {
            return Result.fail(new NoPermissionResponse(toBeExecuted.resultingNode().getPermission().easyName()));
        }

        return Result.success(toBeExecuted);
    }
}
