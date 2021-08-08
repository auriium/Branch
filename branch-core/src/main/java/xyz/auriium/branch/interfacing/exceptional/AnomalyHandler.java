package xyz.auriium.branch.interfacing.exceptional;

/**
 * Represents the most outer-facing interface for interacting with and handling thrown anomalies and
 * sending them to the player (interfacing).
 *
 * Typically delegates actual message handling to a {@link xyz.auriium.branch.interfacing.MessageBoss},
 * whereas retrieval of captions to a {@link xyz.auriium.branch.interfacing.exceptional.caption.AnomalyCaptioner}
 */
public interface AnomalyHandler<I,A> {

    /**
     * Communicates an anomaly to the user and/or to console
     * @param notAdapted the anomaly
     * @param anomaly the exceptional anomaly
     */
    void communicateNotAdapted(I notAdapted, Anomaly anomaly);

    /**
     * Commuicates an anomaly to the adapted user
     * @param adapted adapted user
     * @param anomaly anomaly
     */
    void communicateAdapted(A adapted, Anomaly anomaly);

}
