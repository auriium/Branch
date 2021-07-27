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

package xyz.auriium.branch.fallback.permissions;

import java.util.function.Predicate;

/**
 * Permission that delegates to a predicate
 * @param <T> t
 */
public class PredicatePermission<T> implements Permission<T> {

    private final String easyName;
    private final Predicate<T> predicate;

    public PredicatePermission(String easyName, Predicate<T> predicate) {
        this.easyName = easyName;
        this.predicate = predicate;
    }

    @Override
    public boolean attempt(T sender, String alias, String[] args) {
        return predicate.test(sender);
    }

    @Override
    public String failureIdentifiableName() {
        return easyName;
    }
}
