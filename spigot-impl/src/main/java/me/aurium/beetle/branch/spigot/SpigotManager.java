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

import me.aurium.beetle.branch.centralized.CentralizedManager;
import me.aurium.beetle.branch.centralized.CentralizedManagerBinder;
import me.aurium.beetle.branch.centralized.base.NodeBase;
import me.aurium.beetle.branch.centralized.typeadapter.ManagerAdapter;
import me.aurium.beetle.branch.centralized.base.NodeBaseBuilder;
import me.aurium.beetle.branch.fallback.strategies.OneBackStrategy;
import me.aurium.beetle.branch.interfacing.handlers.CommonInterfacingHandler;
import me.aurium.beetle.branch.interfacing.handlers.ResponseActionHandler;
import me.aurium.beetle.branch.spigot.adapter.SenderAdapter;
import me.aurium.beetle.branch.spigot.message.SpigotMessageProvider;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class SpigotManager implements CentralizedManager<CommandSender, JavaPlugin> {

    private final static SenderAdapter senderAdapter = new SenderAdapter();

    private final CommonInterfacingHandler<CommandSender> defaultInterfacing;
    private final Set<NodeBase<CommandSender>> senders;

    public SpigotManager(ResponseActionHandler<CommandSender> defaultResponser) {
        this.defaultInterfacing = new CommonInterfacingHandler<>(defaultResponser);
        this.senders = new HashSet<>();
    }

    @Override
    public CentralizedManagerBinder getBinder(JavaPlugin platform) {
        return new SpigotManagerBinder(platform.getName(), platform.getServer().getCommandMap(), senders);
    }

    @Override
    public NodeBaseBuilder<CommandSender, CommandSender> newCommand() {
        return new NodeBaseBuilder<>(this, senderAdapter, new OneBackStrategy<>(), new SpigotContextProvider<>(defaultInterfacing), defaultInterfacing);
    }

    @Override
    public <C extends CommandSender> NodeBaseBuilder<CommandSender, C> newCommand(ManagerAdapter<CommandSender, C> adapter) {
        return new NodeBaseBuilder<>(this,adapter, new OneBackStrategy<>(), new SpigotContextProvider<>(null), defaultInterfacing);
    }

    @Override
    public void injectCommand(NodeBase<CommandSender> base) {
        senders.add(base);
    }

}
