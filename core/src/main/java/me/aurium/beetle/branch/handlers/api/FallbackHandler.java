package me.aurium.beetle.branch.handlers.api;

import me.aurium.beetle.branch.context.Context;

/**
 * Represents the fallback handler of a base that manages what happens when everything goes wrong
 */
public interface FallbackHandler<T> {

    void handle(Context<T> context);

}
