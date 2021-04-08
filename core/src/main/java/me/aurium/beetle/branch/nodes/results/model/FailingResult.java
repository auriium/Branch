package me.aurium.beetle.branch.nodes.results.model;

import me.aurium.beetle.branch.interfacing.model.Response;

/**
 * A result that has failed
 * @param <T> the response
 */
public class FailingResult<T> implements Result<T> {

    private final Response failure;

    public FailingResult(Response failure) {
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
    public Response getFailure() {
        return failure;
    }

}
