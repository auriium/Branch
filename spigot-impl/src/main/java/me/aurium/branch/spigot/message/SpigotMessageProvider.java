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

package me.aurium.branch.spigot.message;

import me.aurium.branch.interfacing.handlers.CommonMessageMap;
import me.aurium.branch.interfacing.responses.FailedAdaptingResponse;
import org.bukkit.command.CommandSender;

public class SpigotMessageProvider<C extends CommandSender>{

    private final CommonMessageMap<C> map = new CommonMessageMap<>();

    public SpigotMessageProvider() {
        map.add(FailedAdaptingResponse.class, response -> new TextMessage<>(
                "Expected class: " + response.getExpectedClass().getName() + "Got class: " + response.getReceivedClass()
        ));

        map.add(FailedAdaptingResponse.class, response -> new TextMessage<>());
    }

    public CommonMessageMap<C> build() {
        return map;
    }

}
