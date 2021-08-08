package xyz.auriium.branch.interfacing.exceptional.caption;

import xyz.auriium.branch.interfacing.exceptional.Anomaly;

/**
 * Represents something that can handle anomalies and retrieve stringly simplified messages based on them
 * These messages are then distributed to a AnomalyPrinter.
 */
public interface AnomalyCaptioner<M> {

    M retrieveMessage(Anomaly anomaly);

}
