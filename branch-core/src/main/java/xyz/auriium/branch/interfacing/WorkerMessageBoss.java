package xyz.auriium.branch.interfacing;

/**
 * MessageBoss thta delegates to two MessageWorker
 */
public class WorkerMessageBoss<I,A,M> implements MessageBoss<I,A,M> {

    private final MessageWorker<I,M> initialWorker;
    private final MessageWorker<A,M> adaptedWorker;

    public WorkerMessageBoss(MessageWorker<I, M> initialWorker, MessageWorker<A, M> adaptedWorker) {
        this.initialWorker = initialWorker;
        this.adaptedWorker = adaptedWorker;
    }

    @Override
    public void sendMessageToInitial(String message, I initialType) {
        this.initialWorker.sendMessage(message, initialType);
    }

    @Override
    public void sendMessageToAdapted(String message, A adaptedType) {
        this.adaptedWorker.sendMessage(message, adaptedType);
    }

    @Override
    public void sendObjectToInitial(M message, I initialType) {
        this.initialWorker.sendObject(message, initialType);
    }

    @Override
    public void sendObjectToAdapted(M message, A adaptedType) {
        this.adaptedWorker.sendObject(message, adaptedType);
    }
}
