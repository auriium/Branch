package xyz.auriium.branch.interfacing.exceptional.caption;

import xyz.auriium.branch.interfacing.exceptional.Anomaly;

/**
 * Represents something that can handle anomalies and retrieve stringly simplified messages based on them
 * These strings will then be redistributed to the
 *
 * TODO make these return type M message
 */
public interface AnomalyCaptioner<M> {

    M retrieveMessage(Anomaly anomaly);

}
