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

package me.aurium.branch.nodes.results;

import me.aurium.branch.execution.Block;
import me.aurium.branch.nodes.CommandNode;

import java.util.List;

public class SearchInfo<T> {

    private final CommandNode<T> calculatedNode;

    private final List<Block> initialPath;
    private final List<Block> reducedPath;

    public SearchInfo(CommandNode<T> calculatedNode, SearchInput input) {
        this.calculatedNode = calculatedNode;

        this.initialPath = List.copyOf(input.getInitialPath());
        this.reducedPath = List.copyOf(input.getReducablePath());

    }

    public CommandNode<T> resultingNode() {
        return calculatedNode;
    }

    public List<Block> initialPath() {
        return initialPath;
    }

    public List<Block> reducedPath() {
        return reducedPath;
    }

    public boolean hasMoreArguments() {
        return initialPath.isEmpty();
    }
}
