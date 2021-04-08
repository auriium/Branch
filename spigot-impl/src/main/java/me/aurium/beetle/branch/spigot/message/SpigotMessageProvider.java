package me.aurium.beetle.branch.spigot.message;


import me.aurium.beetle.branch.interfacing.common.FailedAdaptingResponse;
import me.aurium.beetle.branch.interfacing.handlers.CommonMessageMap;
import org.bukkit.command.CommandSender;

public class SpigotMessageProvider<C extends CommandSender>{

    private final CommonMessageMap<C> map = new CommonMessageMap<>();

    public SpigotMessageProvider() {
        map.add(FailedAdaptingResponse.class, response -> new TextMessage<>(
                "Expected class: " + response.getExpectedClass().getName() + "Got class: " + response.getReceivedClass()
        ));

        map.add(FailedAdaptingResponse.class, response -> new TextMessage<>());
    }

}
