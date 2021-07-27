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

package xyz.auriium.branch.nodes.results;

import xyz.auriium.branch.execution.Block;
import xyz.auriium.branch.execution.StringBlock;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SearchInput {

    private final List<Block> initialPath; //TODO make list or something - i don't care but it must be immutable
    private final Deque<Block> reducablePath;

    public SearchInput(List<Block> initialPath, Deque<Block> reducablePath) {
        this.initialPath = initialPath;
        this.reducablePath = reducablePath;
    }

    public List<Block> getInitialPath() {
        return List.copyOf(initialPath);
    }
    public Deque<Block> getReducablePath() {
        return reducablePath;
    }

    public SearchInput withoutTop() {
        List<Block> newBase = new ArrayList<>(initialPath);

        newBase.remove(newBase.size() - 1);

        return new SearchInput(newBase, new ArrayDeque<>(newBase));
    }

    public static SearchInput of(String[] args) {
        List<Block> blocks = new ArrayList<>();

        for (String string : args) {
            blocks.add(StringBlock.of(string));
        }

        return new SearchInput(blocks, new ArrayDeque<>(blocks));
    }

    public static SearchInput of(List<Block> strings) {
        return new SearchInput(strings, new ArrayDeque<>(strings));
    }
}
