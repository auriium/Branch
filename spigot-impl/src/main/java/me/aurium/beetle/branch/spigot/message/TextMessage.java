package me.aurium.beetle.branch.spigot.message;

import me.aurium.beetle.branch.fallback.message.Message;
import org.bukkit.command.CommandSender;

public class TextMessage<C extends CommandSender> implements Message<C> {

    private final String coloredStringToSend;

    public TextMessage(String coloredStringToSend) {
        this.coloredStringToSend = coloredStringToSend;
    }

    @Override
    public void accept(C sender, Object... info) {
        sender.sendMessage(String.format(coloredStringToSend,info));
    }
}
