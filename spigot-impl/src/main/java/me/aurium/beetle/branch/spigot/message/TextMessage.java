package me.aurium.beetle.branch.spigot.message;

import me.aurium.beetle.branch.interfacing.model.Message;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class TextMessage<C extends CommandSender> implements Message<C> {

    private final String[] coloredStringToSend;

    public TextMessage(String... coloredStringToSend) {
        this.coloredStringToSend = coloredStringToSend;
    }

    @Override
    public void accept(C sender) {

        for (String string : coloredStringToSend) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',string));
        }

    }
}
