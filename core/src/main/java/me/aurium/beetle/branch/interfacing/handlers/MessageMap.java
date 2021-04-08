package me.aurium.beetle.branch.interfacing.handlers;

import me.aurium.beetle.branch.interfacing.handlers.ResponseActionHandler;
import me.aurium.beetle.branch.interfacing.model.Response;
import me.aurium.beetle.branch.interfacing.model.ResponseAction;

public interface MessageMap<T> {

    <F extends Response> void add(Class<F> key, ResponseAction<T,F> action);

}
