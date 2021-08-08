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
import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.results.PreProcessSearch;
import xyz.auriium.branch.results.SearcherEquality;
import xyz.auriium.branch.results.Result;

/**
 * A strategy to define
 * - what happens if the user has no permission to execute a node
 * - what happens if a node is inaccessible
 * - what happens if a node is unusable
 * @param <T>
 */
public interface ExecutionSearchStrategy<T> {


    Result<PreProcessSearch<T>> attemptPreprocess(NodeContext<T> context, SearcherEquality equality, CommandNode<T> baseNode);


}