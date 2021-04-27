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

package me.aurium.branch.spigot;

import me.aurium.branch.centralized.CentralizedManagerBinder;
import me.aurium.branch.centralized.base.NodeBase;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

import java.util.Set;

public class SpigotManagerBinder implements CentralizedManagerBinder {

    private final String pluginName;
    private final CommandMap map;
    private final Set<NodeBase<CommandSender>> senders;

    public SpigotManagerBinder(String pluginName, CommandMap map, Set<NodeBase<CommandSender>> senders) {
        this.pluginName = pluginName;
        this.map = map;
        this.senders = senders;
    }

    @Override
    public void bind() { //TODO implement
        for (NodeBase<CommandSender> node : senders) {
            map.register(pluginName,new CommandWrapper(node));
        }
    }
}
