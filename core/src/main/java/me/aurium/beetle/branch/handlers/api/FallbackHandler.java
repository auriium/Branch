package me.aurium.beetle.branch.handlers.api;

import me.aurium.beetle.branch.handlers.context.Context;

/**
 * Represents the fallback handler of a base that manages what happens when everything goes wrong
 *
 * EDIT THIS IS NO LONGER A FALLBACK HANDLER THIS IS ONLY FOR IF SOMETHIGN GOES HELL WRONG
 */
public interface FallbackHandler<T>  {

    void handle(Context<T> context);

}
