package me.aurium.beetle.branch.nodes.results.model;

import me.aurium.beetle.branch.fallback.failure.Failure;

import java.util.Optional;

public interface Result<T> {

    Optional<T> getSuccess();
    Optional<Failure> getFailure();

}
