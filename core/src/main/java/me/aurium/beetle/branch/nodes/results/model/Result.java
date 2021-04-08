package me.aurium.beetle.branch.nodes.results.model;

import me.aurium.beetle.branch.interfacing.model.Response;

public interface Result<T> {

    boolean isSuccessful();

    T getSuccess();

    Response getFailure();

    static <X> Result<X> success(X t) {
        return new SuccessfulResult<>(t);
    }
    static <X> Result<X> fail(Response failure) {
        return new FailingResult<>(failure);
    }

}
