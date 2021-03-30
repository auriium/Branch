package me.aurium.beetle.branch.spigot;

import me.aurium.beetle.branch.fallback.message.BaseContext;
import me.aurium.beetle.branch.handlers.context.AbstractNodeContext;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class SpigotContext<T extends CommandSender> extends AbstractNodeContext<T> {

    private final T sender;

    protected SpigotContext(T t, String alias, String[] strings, CommandNode<T> baseNode, SearchInfo<T> result, BaseContext<T> baseContext) {
        super(t, alias, strings, baseNode, result, baseContext);

        this.sender = t;
    }

    @Override
    public void messageSender(String string) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',string)); //TODO prettify (or just use ContextErrorMessage LMFAO)
    }
}
