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

package me.aurium.branch.centralized.base;

import me.aurium.branch.information.description.Description;

import java.util.Collections;
import java.util.List;

/**
 * Represents a single command tree as a command
 * @param <T> type of input sender
 */
public interface NodeBase<T> {

    void execute(T t, String alias, String[] args); //may execute instantly or take some time
    List<String> suggest(T t, String alias, String[] args);

    Description getDescription();
    String getIdentifier();

    default List<String> getAliases() {
        return Collections.emptyList();
    }

}
