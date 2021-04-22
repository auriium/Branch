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

package me.aurium.beetle.branch.spigot;

import me.aurium.beetle.branch.interfacing.handlers.CommonInterfacingHandler;
import me.aurium.beetle.branch.interfacing.handlers.InterfacingHandler;
import me.aurium.beetle.branch.centralized.CentralizedManager;
import me.aurium.beetle.branch.centralized.CentralizedManagerBinder;
import me.aurium.beetle.branch.centralized.typeadapter.ManagerAdapter;
import me.aurium.beetle.branch.centralized.base.NodeBaseBuilder;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotManager implements CentralizedManager<CommandSender, JavaPlugin> {

    private final SenderAdapter adapter = new SenderAdapter();

    @Override
    public CentralizedManagerBinder getBinder(JavaPlugin platform) {
        return new SpigotManagerBinder(platform);
    }

    @Override
    public NodeBaseBuilder<CommandSender> newCommand() {
        return newCommand(adapter);
    }

    @Override
    public <C extends CommandSender> NodeBaseBuilder<C> newCommand(ManagerAdapter<CommandSender, C> adapter) {
        return null;
    }


}
