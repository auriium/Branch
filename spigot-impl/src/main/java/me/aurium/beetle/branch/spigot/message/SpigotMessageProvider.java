package me.aurium.beetle.branch.spigot.message;

import me.aurium.beetle.branch.interfacing.CoreKeys;
import me.aurium.beetle.branch.interfacing.message.Message;
import me.aurium.beetle.branch.interfacing.message.Requirement;
import me.aurium.beetle.branch.interfacing.message.model.MessageProvider;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SpigotMessageProvider<C extends CommandSender> implements MessageProvider<C> {

    private final Map<UUID, Requirement<C>> map = new HashMap<>();

    public SpigotMessageProvider() {
        map.put(CoreKeys.TOO_MANY_ARGS, new TextMessage<>("&7HI THERE IDIOT FACE! You provided %args% args!"));
    }

    public SpigotMessageProvider<C> with(UUID uuid, Requirement<C> requirement) {
        this.map.put(uuid,requirement);

        return this;
    }


    public final Map<UUID, Requirement<C>>make() {
        return map;
    }

}
