package me.aurium.beetle.branch.nodes.results.model;

import me.aurium.beetle.branch.fallback.failure.Failure;

import java.util.Optional;

public class SuccessfulResult<T> implements Result<T> {

    private final T sucessful;

    public SuccessfulResult(T sucessful) {
        this.sucessful = sucessful;
    }

    @Override
    public Optional<T> getSuccess() {
        return Optional.of(sucessful);
    }

    @Override
    public Optional<Failure> getFailure() {
        return Optional.empty();
    }
}
