package me.aurium.beetle.branch.spigot.toPlayer;

import me.aurium.beetle.branch.interfacing.common.FailedAdaptingResponse;
import me.aurium.beetle.branch.launchpoints.typeadapter.ManagerAdapter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerAdapter implements ManagerAdapter<CommandSender, Player> {

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
