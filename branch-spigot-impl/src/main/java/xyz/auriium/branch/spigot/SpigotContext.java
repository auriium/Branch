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


import org.bukkit.command.CommandSender;
import xyz.auriium.branch.nodes.CommandNode;

public class SpigotContext<T extends CommandSender> extends AbstractNodeContext<T> {

    private final T sender;

    protected SpigotContext(T sender, String alias, String[] args, CommandNode<T> baseNode, SearchInfo<T> result) {
        super(sender, alias, args, baseNode, result);

        this.sender = sender;
    }

    @Override
    public boolean hasStringPermissible(String string) {
        return sender.hasPermission(string);
    }
}
