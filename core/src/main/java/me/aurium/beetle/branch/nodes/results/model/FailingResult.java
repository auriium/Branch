package me.aurium.beetle.branch.nodes.results.model;

import me.aurium.beetle.branch.fallback.failure.Failure;

import java.util.Optional;

public class FailingResult<T> implements Result<T> {

    private final Failure failure;

    public FailingResult(Failure failure) {
        this.failure = failure;
    }

    @Override
    public Optional<T> getSuccess() {
        return Optional.empty();
    }

    @Override
    public Optional<Failure> getFailure() {
        return Optional.of(failure);
    }
}
