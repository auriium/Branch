package xyz.auriium.branch.interfacing.exceptional.anomalies;

import xyz.auriium.branch.interfacing.exceptional.Anomaly;
import xyz.auriium.branch.interfacing.exceptional.AnomalyType;

public class TooFewInputsInternalAnomaly implements Anomaly {

    @Override
    public AnomalyType type() {
        return AnomalyType.INVALID_SYNTAX;
    }
}
