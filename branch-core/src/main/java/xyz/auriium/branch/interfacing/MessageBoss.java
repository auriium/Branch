package xyz.auriium.branch.interfacing;

/**
 * MessageBoss represents message sending class - if a command sender fails adaptation or never even reaches adaptation
 * phase it will be sent a message via type I interfacer, otherwise it will be sent a message via type A interfacer
 *
 * @param <I> type I interfacer (I for initial type) handles communication with initial user
 * @param <A> type A of adapted type handles communication with converted user
 * @param <M> message object type (like Component for kyori or BreakMessage for default)
 */
public interface MessageBoss<I,A,M> {

    void sendMessageToInitial(String message, I initialType);
    void sendMessageToAdapted(String message, A adaptedType);

    void sendObjectToInitial(M message, I initialType);
    void sendObjectToAdapted(M message, A adaptedType);




}
