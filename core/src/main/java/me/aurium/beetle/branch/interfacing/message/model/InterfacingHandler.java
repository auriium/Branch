package me.aurium.beetle.branch.interfacing.message.model;

import me.aurium.beetle.branch.interfacing.message.Message;
import me.aurium.beetle.branch.interfacing.responses.ExecutionResponse;

/**
 * Represents a centralized source for message providing as well as context creation. I am aware i spelled recipient wrong.
 * @param <T> the type
 */
public interface InterfacingHandler<T> {

    void sendMessage(T recipent, Message<T> message);
    void sendMessage(T recipent, ExecutionResponse response);
    void sendMessage(T recipent, String message);

}
