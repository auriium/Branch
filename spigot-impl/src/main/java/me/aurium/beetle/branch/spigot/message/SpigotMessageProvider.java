package me.aurium.beetle.branch.spigot.message;

import me.aurium.beetle.branch.fallback.message.CommonKeys;
import me.aurium.beetle.branch.fallback.message.Message;
import me.aurium.beetle.branch.fallback.message.MessageKey;
import me.aurium.beetle.branch.fallback.message.MessageProvider;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class SpigotMessageProvider<C extends CommandSender> implements MessageProvider<C> {

    public Map<MessageKey,Message<C>> make() {
        Map<MessageKey,Message<C>> messMap = new HashMap<>();

        messMap.put(CommonKeys.TOO_MANY_ARGS, new TextMessage<>("&7HI THERE IDIOT FACE! You provided %args% args!"));

        return messMap;
    }

}
