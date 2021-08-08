package xyz.auriium.branch.interfacing;

/**
 * Represents a subcomponent of a {@link xyz.auriium.branch.interfacing.MessageBoss} that only handles one type
 * @param <T> Type
 * @param <M> Message object type
 */
public interface MessageWorker<T,M> {

    void sendMessage(String message, T type);
    void sendObject(M message, T type);

}
