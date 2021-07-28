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

package xyz.auriium.branch.spigot;


import xyz.auriium.branch.execution.AbstractNodeContext;
import xyz.auriium.branch.interfacing.handlers.InterfacingHandler;
import xyz.auriium.branch.interfacing.Anomaly;
import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.nodes.results.SearchInfo;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class SpigotContext<T extends CommandSender> extends AbstractNodeContext<T> {

    private final T sender;
    private final InterfacingHandler<CommandSender> handler;

    protected SpigotContext(T sender, String alias, String[] args, CommandNode<T> baseNode, SearchInfo<T> result, InterfacingHandler<CommandSender> handler) {
        super(sender, alias, args, baseNode, result);

        this.sender = sender;
        this.handler = handler;
    }

    @Override
    public void stringSender(String string) {
        this.sender.sendMessage(ChatColor.translateAlternateColorCodes('&',string));
    }

    @Override
    public void response(Anomaly failure) {
        handler.sendMessage(sender,failure);
    }

    @Override
    public boolean hasStringPermissible(String string) {
        return sender.hasPermission(string);
    }
}
