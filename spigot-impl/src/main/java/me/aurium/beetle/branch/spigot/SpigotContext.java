package me.aurium.beetle.branch.spigot;


import me.aurium.beetle.branch.handlers.context.AbstractNodeContext;
import me.aurium.beetle.branch.interfacing.handlers.InterfacingHandler;
import me.aurium.beetle.branch.interfacing.model.Message;
import me.aurium.beetle.branch.interfacing.model.Response;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class SpigotContext<T extends CommandSender> extends AbstractNodeContext<T> {

    private final T sender;
    private final InterfacingHandler<T> handler;

    protected SpigotContext(T sender, String alias, String[] args, CommandNode<T> baseNode, SearchInfo<T> result, InterfacingHandler<T> handler) {
        super(sender, alias, args, baseNode, result);

        this.sender = sender;
        this.handler = handler;
    }

    @Override
    public void stringSender(String string) {
        this.sender.sendMessage(ChatColor.translateAlternateColorCodes('&',string));
    }

    @Override
    public void messageSender(Message<T> message) {
        handler.sendMessage(sender,message);
    }

    @Override
    public void response(Response failure) {
        handler.sendMessage(sender,failure);
    }
}
