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

package me.aurium.beetle.branch.utility;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a set that already has an element in it
 */
public class PreStoredHashSet<T> {

    private final T alreadyStored;
    private final Set<T> otherThingsInTheSet;
    private final boolean linked;

    public PreStoredHashSet(T alreadyStored, boolean linked) {
        this.alreadyStored = alreadyStored;
        this.otherThingsInTheSet = new HashSet<>();
        this.linked = linked;
    }
    public PreStoredHashSet(T alreadyStored, Set<T> set, boolean linked) {
        this.alreadyStored = alreadyStored;
        this.otherThingsInTheSet = set;
        this.linked = linked;
    }

    public PreStoredHashSet(Set<T> set, boolean linked) {
        this.alreadyStored = null;
        this.otherThingsInTheSet = set;
        this.linked = linked;
    }

    /**
     * Returns an immutable collection of T (plus already stored variable if it is present)
     * @return an immutable collection of T
     */
    public Set<T> getContents() {
        if (linked) {
            if (alreadyStored == null) {
                return Set.copyOf(otherThingsInTheSet);
            } else {
                Set<T> set = new HashSet<>(otherThingsInTheSet);

                set.add(alreadyStored);

                return Set.copyOf(set);
            }
        } else {
            return Set.copyOf(otherThingsInTheSet);
        }
    }

    /**
     * get already store thing
     * @return already stored thing or null
     */
    public T getAlreadyStored() {
        return alreadyStored;
    }

}
