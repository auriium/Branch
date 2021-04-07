package me.aurium.beetle.branch.nodes.results.model;

import me.aurium.beetle.branch.interfacing.responses.ExecutionResponse;

public class FailingResult<T> implements Result<T> {

    private final ExecutionResponse failure;

    public FailingResult(ExecutionResponse failure) {
        this.failure = failure;
    }

    @Override
    public boolean isSuccessful() {
        return false;
    }

    @Override
    public T getSuccess() {
        throw new IllegalStateException("Attempted to get success of a failing result! (e.g. was not checked)");
    }

    @Override
    public ExecutionResponse getFailure() {
        return failure;
    }
}
