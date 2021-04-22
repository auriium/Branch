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

package me.aurium.beetle.branch.nodes.results;

import me.aurium.beetle.branch.execution.block.Block;
import me.aurium.beetle.branch.nodes.model.CommandNode;

import java.util.Deque;

public class SearchInfo<T> {

    private final CommandNode<T> calculatedNode;
    private final SearchInput input;

    public SearchInfo(CommandNode<T> calculatedNode, SearchInput input) {
        this.calculatedNode = calculatedNode;
        this.input = input;
    }

    public CommandNode<T> resultingNode() {
        return calculatedNode;
    }

    public Deque<Block> initialPath() {
        return input.getInitialPath();
    }

    public Deque<Block> reducedPath() {
        return input.getReducablePath();
    }

    public boolean hasMoreArguments() {
        return !input.getReducablePath().isEmpty();
    }
}
