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

import me.aurium.branch.interfacing.Message;
import me.aurium.branch.interfacing.Response;
import me.aurium.branch.interfacing.ResponseAction;

import java.util.Map;

public class CommonInterfacingHandler<T> implements InterfacingHandler<T> {

    private final Map<Class<? extends Response>, ResponseAction<T,? extends Response>> map;

    CommonInterfacingHandler(Map<Class<? extends Response>, ResponseAction<T, ? extends Response>> map) {
        this.map = map;
    }

    @Override
    public void sendMessage(T recipent, Message<T> message) {
        message.accept(recipent);
    }

    @Override
    public void sendMessage(T recipent, Response response) {
        getMessage(response).accept(recipent);
    }

    @SuppressWarnings("unchecked")
    private <C extends Response> ResponseAction<T, C> get(Class<C> clazz) {
        ResponseAction<T,C> action = (ResponseAction<T, C>) map.get(clazz);

        if (action == null) throw new IllegalStateException("A response was requested but internal map had no binding!");

        return action;
    }

    @SuppressWarnings("unchecked")
    private  <C extends Response> Message<T> getMessage(C response) {
        return get((Class<C>) response.getClass()).consume(response);
    }
}
