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

package xyz.auriium.branch.base;

import xyz.auriium.branch.nodes.description.Description;

import java.util.Collections;
import java.util.List;

/**
 * Represents a single command tree as a single executable object, executable by the bound node base.
 * You can **technically** simply implement this and pretend it's a normal bukkit command
 * I will laugh at you, however.
 *
 * @param <I> type of input object used by the manager this node base is bound to
 */
public interface NodeBase<I> {

    /**
     * Method called when node base desires execution of this object
     * @param input input object of the manager (maybe not final adapted object)
     * @param alias alias of the command (people like using this in interfacing)
     * @param args arguments sent by input object
     */
    void execute(I input, String alias, String[] args);

    /**
     * Method called when node base desires suggestions to submit to the user
     * @param input input object of the manager (maybe not final adapted object)
     * @param alias alias of the command (people like using this in interfacing)
     * @param args arguments sent by input object
     */
    List<String> suggest(I input, String alias, String[] args);

    Description getDescription();
    String getIdentifier();

    default List<String> getAliases() {
        return Collections.emptyList();
    }

}
