package me.aurium.beetle.branch.interfacing.common;

import me.aurium.beetle.branch.interfacing.model.Response;

public class TooManyArgsResponse implements Response {

    private final int expectedArgs;
    private final int suppliedArgs;

    public TooManyArgsResponse(int expectedArgs, int suppliedArgs) {
        this.expectedArgs = expectedArgs;
        this.suppliedArgs = suppliedArgs;
    }

    public int getExpectedArgs() {
        return expectedArgs;
    }

    public int getSuppliedArgs() {
        return suppliedArgs;
    }
}
