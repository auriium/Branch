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

package me.aurium.branch.nodes.single;

import me.aurium.branch.nodes.IdentifiableNode;
import me.aurium.branch.nodes.results.SearchInfo;
import me.aurium.branch.nodes.results.SearchInput;

/**
 * A node that cannot point to any node other than itself (and therefore ends the branching of a node-path)
 */
public abstract class EndpointNode<T> implements IdentifiableNode<T> {

    @Override
    public final SearchInfo<T> getSpecificNode(SearchInput input) {
        return new SearchInfo<>(this,input);
    }

}
