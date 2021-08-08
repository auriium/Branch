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

package xyz.auriium.branch.nodes;

import xyz.auriium.branch.base.NodeContext;
import xyz.auriium.branch.base.execution.Execution;
import xyz.auriium.branch.base.suggestion.Suggestion;
import xyz.auriium.branch.nodes.description.Description;
import xyz.auriium.branch.base.permissions.Permission;
import xyz.auriium.branch.results.Result;
import xyz.auriium.branch.results.InitialSearch;
import xyz.auriium.branch.results.PreProcessSearch;

import java.util.List;

/**
 * Base object
 * @param <T> fuck
 */
public interface CommandNode<T> {

    //int getExpectedConsumeAmount() //used to check how much was expected as you pass through vs how much was received, among other htings.

    /**
     * Suggestion-handling analogy to
     *
     * @return returns a result containing all suggestions
     */
    Result<List<Suggestion<T>>> searchSuggestion(NodeContext<T> ctx, PreProcessSearch<T> input);

    /**
     * Method called first. Locates the node to execute and adds all found nodes along the path to the SearcherOutput
     *
     * Is not finished since some nodes still need to add blocks to the final output
     *
     * @return a result containing the node required and all initial blocks found.
     */
    Result<PreProcessSearch<T>> searchNode(InitialSearch<T> input);

    /**
     * Method called next. Typically adds all node-specific blocks to the search
     * and returns an execution.
     *
     * @return execution of the node
     */
    Result<Execution<T>> searchExecute(NodeContext<T> ctx, PreProcessSearch<T> input);


    /**
     * Gets the permission required to execute and interact with this node. Depending on the base, this may cause the node to become locked, or just completely be ignored.
     * @return the permission binding
     */
    Permission<T> getPermission();
    Description getDescription();

}
