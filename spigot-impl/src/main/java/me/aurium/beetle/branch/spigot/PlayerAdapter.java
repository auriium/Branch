package me.aurium.beetle.branch.spigot;

import me.aurium.beetle.branch.launchpoints.typeadapter.ManagerAdapter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.function.Consumer;

public class PlayerAdapter implements ManagerAdapter<CommandSender, Player> {

    private final Consumer<CommandSender> failedOperation;

    public PlayerAdapter(Consumer<CommandSender> failedOperation) {
        this.failedOperation = failedOperation;
    }

    @Override
    public Player adapt(CommandSender sender) {
        return (Player) sender;
    }

    @Override
    public boolean canAdapt(CommandSender sender) {
        return sender instanceof Player;
    }

    @Override
    public Consumer<CommandSender> failedAdaptAction() {
        return failedOperation;
    }

}
