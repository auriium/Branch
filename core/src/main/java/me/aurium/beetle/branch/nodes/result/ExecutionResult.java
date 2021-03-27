package me.aurium.beetle.branch.nodes.result;

import me.aurium.beetle.branch.handlers.api.ExecutionHandler;

import java.util.Optional;

public class ExecutionResult<T>{

    private final ExecutionHandler<T> executionHandler;

    public ExecutionResult(ExecutionHandler<T> executionHandler) {
        this.executionHandler = executionHandler;
    }

    public Optional<ExecutionHandler<T>> getExecution() {
        return Optional.ofNullable(executionHandler);
    }

    public static <C> ExecutionResult<C> empty() {
        return new ExecutionResult<>(null);
    }
}
