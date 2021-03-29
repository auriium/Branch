package me.aurium.beetle.branch.launchpoints.base;

import me.aurium.beetle.branch.handlers.context.ContextProducer;
import me.aurium.beetle.branch.handlers.api.FallbackHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.fallback.permission.strategies.ExecutionFallbackStrategy;
import me.aurium.beetle.branch.fallback.permission.strategies.FallbackPermStrategy;

import java.util.Arrays;
import java.util.Objects;

public class NodeBaseBuilder<T> {

    private final ContextProducer<T> producer;

    private CommandNode<T> base;
    private FallbackHandler<T> fallbackHandler = (shit) -> shit.messageSender("Error running command with arguments: " + Arrays.toString(shit.getArgs()));
    private ExecutionFallbackStrategy<T> strategy = new FallbackPermStrategy<>();

    public <X> NodeBaseBuilder(ContextProducer<T> producer) {
        this.producer = producer;
    }

    public NodeBaseBuilder<T> withBaseNode(CommandNode<T> node) {
        this.base = node;

        return this;
    }

    public NodeBaseBuilder<T> withFallback(FallbackHandler<T> fallback) {
        this.fallbackHandler = fallback;

        return this;
    }

    public NodeBaseBuilder<T> withStrategy(ExecutionFallbackStrategy<T> strategy) {
        this.strategy = strategy;

        return this;
    }

    public NodeBase<T> build() {
        Objects.requireNonNull(base);
        Objects.requireNonNull(fallbackHandler);
        Objects.requireNonNull(strategy);

        return new SimpleNodeBase<>(base,producer,fallbackHandler,strategy);
    }
}
