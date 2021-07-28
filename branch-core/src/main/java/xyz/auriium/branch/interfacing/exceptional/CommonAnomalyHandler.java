package xyz.auriium.branch.interfacing.exceptional;

import xyz.auriium.branch.interfacing.MessageBoss;
import xyz.auriium.branch.interfacing.exceptional.caption.AnomalyCaptioner;
import xyz.auriium.branch.interfacing.exceptional.printing.AnomalyPrinter;

public class CommonAnomalyHandler<I,A,M> implements AnomalyHandler<I,A>{

    private final MessageBoss<I,A,M> messageBoss;
    private final AnomalyPrinter<M> handler;
    private final AnomalyCaptioner<M> captioner;

    public CommonAnomalyHandler(MessageBoss<I, A, M> messageBoss, AnomalyPrinter<M> handler, AnomalyCaptioner<M> captioner) {
        this.messageBoss = messageBoss;
        this.handler = handler;
        this.captioner = captioner;
    }

    @Override
    public void communicateNotAdapted(I notAdapted, Anomaly anomaly) {
        messageBoss.sendObjectToInitial(make(anomaly), notAdapted);
    }

    @Override
    public void communicateAdapted(A adapted, Anomaly anomaly) {
        messageBoss.sendObjectToAdapted(make(anomaly), adapted);
    }

    M make(Anomaly anomaly) {
        return handler.makeMessage(anomaly.type(), captioner.retrieveMessage(anomaly));
    }
}
