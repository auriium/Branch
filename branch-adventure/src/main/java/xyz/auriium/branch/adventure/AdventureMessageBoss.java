package xyz.auriium.branch.adventure;

import net.kyori.adventure.text.Component;
import xyz.auriium.branch.interfacing.MessageWorker;
import xyz.auriium.branch.interfacing.WorkerMessageBoss;

public class AdventureMessageBoss<I,A> extends WorkerMessageBoss<I,A,Component> {

    public AdventureMessageBoss(AudienceTransmogrifier<I> iTransmogrifier, AudienceTransmogrifier<A> aTransmogrifier) {
        super(new AdventureMessageWorker<>(iTransmogrifier), new AdventureMessageWorker<>(aTransmogrifier));
    }
}
