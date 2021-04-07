package me.aurium.beetle.branch.interfacing.responses;

import me.aurium.beetle.branch.interfacing.message.model.MessageInfo;

import java.util.UUID;

public class SendableResponse implements ExecutionResponse {

    private final UUID key;
    private final MessageInfo[] requirements;

    public SendableResponse(UUID key, MessageInfo... requirements) {
        this.key = key;
        this.requirements = requirements;
    }

    @Override
    public UUID getCorrelatedMessage() {
        return key;
    }

    @Override
    public MessageInfo[] getRequirements() {
        return requirements;
    }

}
