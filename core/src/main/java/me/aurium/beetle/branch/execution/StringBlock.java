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

package me.aurium.beetle.branch.execution;

/**
 * Represents a block that contains a string
 */
public class StringBlock implements Block {

    private final String identifier;

    public StringBlock(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    public static Block of(String string) {
        if (string.contains(" ")) throw new IllegalStateException("Identifier cannot have spaces!");

        return new StringBlock(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringBlock that = (StringBlock) o;
        return identifier.equalsIgnoreCase(that.identifier);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }
}
