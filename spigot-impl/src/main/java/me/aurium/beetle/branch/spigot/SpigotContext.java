package me.aurium.beetle.branch.spigot;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.handlers.api.FallbackHandler;
import me.aurium.beetle.branch.handlers.context.AbstractNodeContext;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class SpigotContext<T extends CommandSender> extends AbstractNodeContext<T> {

    private final T sender;

    public SpigotContext(T sender, String alias, String[] args, CommandNode<T> executed, CommandNode<T> base, BlockPath executedPath, BlockPath fullPath, FallbackHandler<T> handler) {
        super(sender, alias, args, executed, base, executedPath, fullPath, handler);

        this.sender = sender;
    }

    @Override
    public void messageSender(String string) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',string)); //TODO prettify (or just use ContextErrorMessage LMFAO)
    }
}
