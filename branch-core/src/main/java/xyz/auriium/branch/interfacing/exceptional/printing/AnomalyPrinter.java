package xyz.auriium.branch.interfacing.exceptional.printing;

import xyz.auriium.branch.interfacing.exceptional.AnomalyType;

/**
 * Printer that converts anomaly type + message into message object
 * @param <M> message object
 */
public interface AnomalyPrinter<M> {

    M makeMessage(AnomalyType type, M initial);

}
