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

package xyz.auriium.branch.spigot.message;

import xyz.auriium.branch.interfacing.Response;
import xyz.auriium.branch.interfacing.ResponseAction;
import xyz.auriium.branch.interfacing.handlers.DelegatingDefaultMap;
import xyz.auriium.branch.interfacing.handlers.InnerMap;
import xyz.auriium.branch.interfacing.responses.FailedAdaptingResponse;
import org.bukkit.command.CommandSender;

/**
 * Spigot message defaults
 * @param <C>
 */
public class SpigotMessageMap<C extends CommandSender> extends DelegatingDefaultMap<C> {

    @Override
    public <F extends Response> SpigotMessageMap<C> add(Class<F> key, ResponseAction<C, F> action) {
        return (SpigotMessageMap<C>) super.add(key, action);
    }

    @Override
    protected InnerMap<C> defaultMap() {
        InnerMap<C> map = new InnerMap<>();

        map.add(FailedAdaptingResponse.class, response -> new TextMessage<>(
                "Expected class: " + response.getExpectedClass().getName() + "Got class: " + response.getReceivedClass()
        ));

        return map;
    }
}
