package xyz.auriium.branch.interfacing.exceptional.caption;

import xyz.auriium.branch.interfacing.exceptional.Anomaly;

import java.util.function.Function;

public interface SettableCaptioner<M> extends AnomalyCaptioner<M> {

    <A extends Anomaly> SettableCaptioner<M> set(Class<A> anomalyType, Function<A,M> parser);

}
