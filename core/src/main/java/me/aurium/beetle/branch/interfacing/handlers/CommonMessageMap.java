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

package me.aurium.beetle.branch.interfacing.handlers;

import me.aurium.beetle.branch.interfacing.Response;
import me.aurium.beetle.branch.interfacing.ResponseAction;

import java.util.HashMap;
import java.util.Map;

public class CommonMessageMap<T> implements MessageMap<T>, MessageProvider<T> {

    private final Map<Class<? extends Response>,ResponseAction<T,? extends Response>> map = new HashMap<>();

    @Override
    public <F extends Response> void add(Class<F> key, ResponseAction<T, F> action) {
        map.put(key,action); //TODO checks
    }

    @Override
    public ResponseActionHandler<T> make() {
        return new CommonResponseActionHandler<>(Map.copyOf(map));
    }
}
