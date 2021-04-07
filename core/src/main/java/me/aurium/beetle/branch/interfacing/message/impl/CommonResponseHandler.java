package me.aurium.beetle.branch.interfacing.message.impl;

import me.aurium.beetle.branch.interfacing.message.Requirement;
import me.aurium.beetle.branch.interfacing.message.model.ResponseHandler;
import me.aurium.beetle.branch.interfacing.message.model.MessageProvider;
import me.aurium.beetle.branch.interfacing.responses.ExecutionResponse;

import java.util.Map;
import java.util.UUID;

public class CommonResponseHandler<T> implements ResponseHandler<T> {

    private final Map<UUID, Requirement<T>> requirements;

    public CommonResponseHandler(MessageProvider<T> requirements) {
        this.requirements = requirements.make();
    }

    @Override
    public void sendMessage(T sender, ExecutionResponse info) {
        Requirement<T> requirement = requirements.get(info.getCorrelatedMessage());

        if (requirement == null) throw new IllegalArgumentException("No message mapped to key!");

        requirement.toMessage(info.getRequirements()).accept(sender);
    }
}
