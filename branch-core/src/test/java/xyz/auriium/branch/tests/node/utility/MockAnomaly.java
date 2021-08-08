package xyz.auriium.branch.tests.node.utility;

import xyz.auriium.branch.interfacing.exceptional.Anomaly;
import xyz.auriium.branch.interfacing.exceptional.AnomalyType;

public class MockAnomaly implements Anomaly {

    @Override
    public AnomalyType type() {
        return AnomalyType.INVALID_SYNTAX;
    }
}
