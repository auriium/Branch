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

package me.aurium.branch.execution;

import me.aurium.branch.execution.api.SuggestionHandler;

import java.util.ArrayList;
import java.util.List;

public class EmptySuggestionHandler<T> implements SuggestionHandler<T> {

    private final List<String> emptyList = new ArrayList<>();

    @Override
    public List<Block> handle(NodeContext<T> adapter) {
        return List.of();
    }
}
