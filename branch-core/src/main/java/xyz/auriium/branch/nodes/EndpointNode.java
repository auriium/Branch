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

import xyz.auriium.branch.execution.EmptySuggestionHandler;
import xyz.auriium.branch.execution.api.SuggestionHandler;
import xyz.auriium.branch.execution.blocks.EndpointBlock;
import xyz.auriium.branch.nodes.results.InitialSearch;
import xyz.auriium.branch.nodes.results.PreProcessSearch;
import xyz.auriium.branch.nodes.results.model.Result;

/**
 * A node that cannot point to any node other than itself (and therefore ends the branching of a node-path)
 */
public interface EndpointNode<T> extends IdentifiableNode<T> {

    @Override
    EndpointBlock getIdentifier();

    @Override
    default SuggestionHandler<T> getSuggestionHandler() {
        return EmptySuggestionHandler.instance();
    }

    @Override
    default Result<PreProcessSearch<T>> searchNode(InitialSearch<T> input) {
        return Result.success(PreProcessSearch.generate(this,input)); //new generation
    }
}
