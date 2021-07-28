package xyz.auriium.branch.interfacing.exceptional.caption;

import xyz.auriium.branch.interfacing.exceptional.Anomaly;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CommonAnomalyCaptioner<M> implements SettableCaptioner<M> {

    private final Map<Class<? extends Anomaly>, Function<? extends Anomaly, M>> records = new HashMap<>();

    @Override
    public M retrieveMessage(Anomaly anomaly) {
        return retrieve(anomaly).apply(anomaly);
    }

    @SuppressWarnings("unchecked")
    private <A extends Anomaly> Function<A,M> retrieve(A anomaly) {
        return (Function<A, M>) records.get(anomaly.getClass());
    }

    @Override
    public <A extends Anomaly> SettableCaptioner<M> set(Class<A> anomalyType, Function<A,M> parser) {
        records.put(anomalyType, parser);

        return this;
    }


}
