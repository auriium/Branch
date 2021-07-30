package xyz.auriium.branch.interfacing.exceptional.anomalies;

import xyz.auriium.branch.execution.blocks.ArgumentBlock;
import xyz.auriium.branch.interfacing.exceptional.Anomaly;
import xyz.auriium.branch.interfacing.exceptional.AnomalyType;

public class TooFewInputsInternalAnomaly implements Anomaly {

    private final Class<?> argumentClass;
    private final ArgumentBlock argumentType;
    private final int expectedArgs;
    private final int gotArgs;

    public TooFewInputsInternalAnomaly(Class<?> argumentClass, ArgumentBlock argumentType, int expectedArgs, int gotArgs) {
        this.argumentClass = argumentClass;
        this.argumentType = argumentType;
        this.expectedArgs = expectedArgs;
        this.gotArgs = gotArgs;
    }

    public Class<?> getArgumentClass() {
        return argumentClass;
    }

    public int getExpectedArgs() {
        return expectedArgs;
    }

    public int getGotArgs() {
        return gotArgs;
    }

    @Override
    public AnomalyType type() {
        return AnomalyType.INVALID_SYNTAX; //TODO fix
    }
}
