package me.aurium.beetle.branch.nodes.results.model;

import me.aurium.beetle.branch.interfacing.responses.ExecutionResponse;

public interface Result<T> {

    boolean isSuccessful();

    T getSuccess();
    ExecutionResponse getFailure();

    //wow this looks familiar (i liked the functionality shhhh)
    static <X> Result<X> success(X t) {
        return new SuccessfulResult<>(t);
    }

    static <X> Result<X> fail(ExecutionResponse failure) {
        return new FailingResult<>(failure);
    }

}
