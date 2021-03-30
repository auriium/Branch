package me.aurium.beetle.branch.fallback.failure;

import me.aurium.beetle.branch.fallback.message.MessageKey;
import me.aurium.beetle.branch.fallback.message.MessageRequirement;

public interface Failure {

    MessageKey getCorrelatedMessage();
    MessageRequirement[] getRequirements();

    Throwable toThrowable();

}
