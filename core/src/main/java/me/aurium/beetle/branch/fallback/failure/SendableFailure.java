package me.aurium.beetle.branch.fallback.failure;

import me.aurium.beetle.branch.fallback.message.MessageKey;
import me.aurium.beetle.branch.fallback.message.MessageRequirement;

public class SendableFailure implements Failure{

    private final MessageKey key;
    private final MessageRequirement[] requirements;

    public SendableFailure(MessageKey key, MessageRequirement... requirements) {
        this.key = key;
        this.requirements = requirements;
    }

    @Override
    public MessageKey getCorrelatedMessage() {
        return key;
    }

    @Override
    public MessageRequirement[] getRequirements() {
        return requirements;
    }

    @Override
    public Throwable toThrowable() {
        return new IllegalStateException();
    }
}
