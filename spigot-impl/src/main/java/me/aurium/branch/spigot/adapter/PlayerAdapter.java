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

package me.aurium.branch.spigot.adapter;

import me.aurium.branch.interfacing.responses.FailedAdaptingResponse;
import me.aurium.branch.centralized.typeadapter.ManagerAdapter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerAdapter implements ManagerAdapter<CommandSender, Player> {

    public static PlayerAdapter INSTANCE = new PlayerAdapter();

    PlayerAdapter(){}

    @Override
    public Player adapt(CommandSender sender) {
        return (Player) sender;
    }

    @Override
    public boolean canAdapt(CommandSender sender) {
        return sender instanceof Player;
    }

    @Override
    public FailedAdaptingResponse failedParseResponse(CommandSender sender) {
        return new FailedAdaptingResponse(Player.class, CommandSender.class);
    }


}
