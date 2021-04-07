package me.aurium.beetle.branch.nodes.results.model;

import me.aurium.beetle.branch.interfacing.responses.ExecutionResponse;

public class SuccessfulResult<T> implements Result<T> {

    private final T sucessful;

    public SuccessfulResult(T sucessful) {
        this.sucessful = sucessful;
    }

    @Override
    public boolean isSuccessful() {
        return true;
    }

    @Override
    public T getSuccess() {
        return sucessful;
    }

    @Override
    public ExecutionResponse getFailure() {
        throw new IllegalStateException("Attempted to get failure of a successful result!");
    }
}
