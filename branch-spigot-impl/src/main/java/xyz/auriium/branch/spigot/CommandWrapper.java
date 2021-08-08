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

import xyz.auriium.branch.base.NodeBase;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CommandWrapper extends Command {

    private final NodeBase<CommandSender> base;

    public CommandWrapper(NodeBase<CommandSender> base) {
        super(base.getIdentifier(),base.getDescription().getTextDescription(), base.getDescription().getTextDescription(), base.getAliases());
        this.base = base;
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        base.execute(commandSender, s, strings);

        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        return base.suggest(sender, alias, args);
    }
}
