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

package me.aurium.branch.nodes.argument.types;

import me.aurium.branch.execution.Block;
import me.aurium.branch.execution.NodeContext;

import java.util.List;
import java.util.Optional;

/**
 * Represents a kind of parser that converts blocks into a typed argument.
 * @param <T>
 *
 *     TODO: maybe let arguments consume more than one Block.
 */
public interface Argument<T> {

    /**
     * What the argument identifies as
     * @return what it identifies as
     */
    String getLabel();

    /**
     * Gets the bounds of the object
     * @param context the context used to calculate
     * @return
     */
    List<String> getBounds(NodeContext<T> context);

    boolean check(Block toParse);
    T parse(Block block);

    Optional<T> getDefault();

}
