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

package me.aurium.branch.interfacing.handlers;

import me.aurium.branch.interfacing.Response;
import me.aurium.branch.interfacing.ResponseAction;

import java.util.HashMap;
import java.util.Map;

public class InnerMap<T> implements MessageMap<T> {

    private final Map<Class<? extends Response>,ResponseAction<T,? extends Response>> map = new HashMap<>();

    @Override
    public <F extends Response> InnerMap<T> add(Class<F> key, ResponseAction<T, F> action) {
        this.map.put(key,action);

        return this;
    }

    @Override
    public InterfacingHandler<T> make() {
        return new CommonInterfacingHandler<>(map);
    }
}
