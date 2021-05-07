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

package me.aurium.branch.execution.api;

import me.aurium.branch.execution.NodeContext;
import me.aurium.branch.nodes.results.model.Result;

import java.util.List;

/**
 * Represents the actable behavior of a node once the node has been found - e.g. after the node's search logic is complete
 * @param <T> sender
 */
public interface BranchHandler<T> {

    Execution<T> getExecution(NodeContext<T> context);
    List<String> getSuggestions(NodeContext<T> context);

}
