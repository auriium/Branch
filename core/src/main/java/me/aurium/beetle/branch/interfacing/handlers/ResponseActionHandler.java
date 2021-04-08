package me.aurium.beetle.branch.interfacing.handlers;

import me.aurium.beetle.branch.interfacing.model.Message;
import me.aurium.beetle.branch.interfacing.model.Response;
import me.aurium.beetle.branch.interfacing.model.ResponseAction;

public interface ResponseActionHandler<T> {

    <C extends Response> ResponseAction<T, C> get(Class<C> clazz);
    <C extends Response> Message<T> getMessage(C response);


}
