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

import me.aurium.beetle.branch.interfacing.Message;
import me.aurium.beetle.branch.interfacing.Response;
import me.aurium.beetle.branch.interfacing.ResponseAction;

import java.util.Map;

public class CommonResponseActionHandler<T> implements ResponseActionHandler<T> {

    private final Map<Class<? extends Response>, ResponseAction<T,? extends Response>> map;

    CommonResponseActionHandler(Map<Class<? extends Response>, ResponseAction<T,? extends Response>> map) {
        this.map = map;
    }

    @SuppressWarnings("unchecked")
    public <C extends Response> ResponseAction<T, C> get(Class<C> clazz) {
        ResponseAction<T,C> action = (ResponseAction<T, C>) map.get(clazz);

        if (action == null) throw new IllegalStateException("A response was requested but internal map had no binding!");

        return action;
    }

    @SuppressWarnings("unchecked")
    public <C extends Response> Message<T> getMessage(C response) {
        return get((Class<C>) response.getClass()).consume(response);
    }


}
