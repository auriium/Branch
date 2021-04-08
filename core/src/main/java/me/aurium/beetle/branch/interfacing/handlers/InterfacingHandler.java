package me.aurium.beetle.branch.interfacing.handlers;

import me.aurium.beetle.branch.interfacing.model.Message;
import me.aurium.beetle.branch.interfacing.model.Response;

/**
 * Represents a centralized source for message providing as well as context creation. I am aware i spelled recipient wrong.
 * @param <T> the type
 */
public interface InterfacingHandler<T> {

    void sendMessage(T recipent, Message<T> message);
    void sendMessage(T recipent, Response response);

}
