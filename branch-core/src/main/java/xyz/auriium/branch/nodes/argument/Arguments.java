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

package xyz.auriium.branch.nodes.argument;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Object for storing and returning arguments of a command
 */
public class Arguments {

    private final Map<String,Object> map = new HashMap<>();

    public <T> Optional<T> getOptional(String identifier) {
        return (Optional<T>) Optional.ofNullable(map.get(identifier));
    }

    public <T> T get(String identifier) {
        return (T) map.get(identifier);
    }

    void put(String identifier, Object object) {
        this.map.put(identifier, object);
    }
}
