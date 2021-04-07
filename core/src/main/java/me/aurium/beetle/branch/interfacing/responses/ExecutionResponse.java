package me.aurium.beetle.branch.interfacing.responses;

import me.aurium.beetle.branch.interfacing.message.model.MessageInfo;

import java.util.UUID;

/**
 * Represents a prebuilt response to a request or command that is bound to the handler.
 */
public interface ExecutionResponse {

    UUID getCorrelatedMessage();
    MessageInfo[] getRequirements();

    //TODO to throwable

}
