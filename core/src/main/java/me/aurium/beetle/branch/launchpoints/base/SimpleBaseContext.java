package me.aurium.beetle.branch.launchpoints.base;

import me.aurium.beetle.branch.fallback.message.BaseContext;
import me.aurium.beetle.branch.handlers.api.FallbackHandler;

public class SimpleBaseContext<T> implements BaseContext<T> {

    private final FallbackHandler<T> handler;

    public SimpleBaseContext(FallbackHandler<T> handler) {
        this.handler = handler;
    }

    @Override
    public FallbackHandler<T> getFallback() {
        return handler;
    }
}
