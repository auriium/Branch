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

package xyz.auriium.branch.base.execution.blocks;

/**
 * Represents a Branch-provided identification structure for the identifier of specific structures
 */
public interface Block {

    /**
     * Gets the literal identifier of the block
     *
     * If the object is an endpoint block "join" of /kitpvp join, the identifier is "join"
     * (pretty obvious)
     * @return the identifier
     */
    String getLabel();

    /**
     * Gets the prettified "version" of the block used to display it
     *
     * If the object is an endpoint block "join" of /kitpvp join,
     * the prettified identifier will be "<join>"
     *
     * @return the pretty string alone
     */
    default String getPretty() {
        return getBracketPattern().parse(getLabel());
    }

    /**
     * Gets identifier and type wrapped with prettified bracketing
     *
     * If the object is an endpoint block "join" of /kitpvp join, the
     * prettified + type string is "<endpoint:join>"
     *
     * @return the prettified string
     */
    default String getPrettyAndType() {
        return getBracketPattern().parse(String.format("%s:%s", getType(), getLabel()));
    }

    /**
     * Gets just the type string used for this object. Typically delegates to {@link #getTypeObject()} except
     * for argument blocks, in which case
     * @return the type
     */
    String getType();

    /**
     * Returns a bracket pattern for use with {@link #getPretty()}
     * @return returns the bracket pattern
     */
    BracketPattern getBracketPattern();

    /**
     * Gets the blocktype this belongs to
     * @return the blocktype
     */
    BlockType getTypeObject();

    default boolean matches(String string) {
        return getLabel().equalsIgnoreCase(string);
    }
}
