package me.aurium.beetle.branch.fallback.message;

import me.aurium.beetle.branch.handlers.api.FallbackHandler;

public interface BaseContext<T> {

    FallbackHandler<T> getFallback();

    //TODO message stuff

}
