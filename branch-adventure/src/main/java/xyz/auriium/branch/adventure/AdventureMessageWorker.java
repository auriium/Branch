package xyz.auriium.branch.adventure;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import xyz.auriium.branch.interfacing.MessageWorker;

public class AdventureMessageWorker<T> implements MessageWorker<T, Component> {

    private final AudienceTransmogrifier<T> transmogrifier;

    public AdventureMessageWorker(AudienceTransmogrifier<T> transmogrifier) {
        this.transmogrifier = transmogrifier;
    }

    @Override
    public void sendMessage(String message, T type) {
        transmogrifier.transmogrify(type).sendMessage(LegacyComponentSerializer.legacyAmpersand().deserialize(message));
    }

    @Override
    public void sendObject(Component message, T type) {
        transmogrifier.transmogrify(type).sendMessage(message);
    }
}
