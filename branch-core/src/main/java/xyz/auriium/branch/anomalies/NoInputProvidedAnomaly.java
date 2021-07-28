package xyz.auriium.branch.anomalies;

import xyz.auriium.branch.interfacing.Anomaly;

public class NoInputProvidedAnomaly implements Anomaly {

    private final Class<?> argumentClass;
    private final String argumentType;
    private final String argumentLabel;
    private final int expectedArgs;
    private final int gotArgs;

    public NoInputProvidedAnomaly(Class<?> argumentClass, String argumentType, String argumentLabel, int expectedArgs, int gotArgs) {
        this.argumentClass = argumentClass;
        this.argumentType = argumentType;
        this.argumentLabel = argumentLabel;
        this.expectedArgs = expectedArgs;
        this.gotArgs = gotArgs;
    }

    public Class<?> getArgumentClass() {
        return argumentClass;
    }

    public String getArgumentType() {
        return argumentType;
    }

    public int getExpectedArgs() {
        return expectedArgs;
    }

    public int getGotArgs() {
        return gotArgs;
    }
}
