package me.aurium.beetle.branch.interfacing.message.model;

import me.aurium.beetle.branch.interfacing.responses.ExecutionResponse;

/**
 * Represents something that will handle the accessing of responses from the bound map and sending them.
 * @param <T> the type
 */
public interface ResponseHandler<T> {

    /**
     * Sends a message bound to the execution response, or throws an exception if not present
     * @param sender the sender
     * @param key the response to send
     */
    void sendMessage(T sender, ExecutionResponse key);

}
