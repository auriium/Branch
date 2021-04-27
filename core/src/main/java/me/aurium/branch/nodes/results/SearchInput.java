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
import me.aurium.branch.execution.StringBlock;

import java.util.ArrayDeque;
import java.util.Deque;

public class SearchInput {

    private final Deque<Block> initialPath; //TODO make list or something - i don't care but it must be immutable
    private final Deque<Block> reducablePath;

    public SearchInput(Deque<Block> initialPath, Deque<Block> reducablePath) {
        this.initialPath = initialPath;
        this.reducablePath = reducablePath;
    }

    public Deque<Block> getInitialPath() {
        return initialPath;
    }
    public Deque<Block> getReducablePath() {
        return reducablePath;
    }

    public SearchInput withoutTop() {
        Deque<Block> newBase = new ArrayDeque<>(initialPath);

        newBase.removeLast();

        return of(newBase);
    }

    public static SearchInput of(Deque<Block> initialPath) {
        return new SearchInput(initialPath,new ArrayDeque<>(initialPath));
    }

    public static SearchInput of(String[] args) {
        Deque<Block> blocks = new ArrayDeque<>();

        for (String string : args) {
            blocks.addLast(StringBlock.of(string));
        }

        return of(blocks);
    }
}
