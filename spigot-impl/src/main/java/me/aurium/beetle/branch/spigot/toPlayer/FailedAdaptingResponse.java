package me.aurium.beetle.branch.spigot.toPlayer;

import me.aurium.beetle.branch.interfacing.CoreKeys;
import me.aurium.beetle.branch.interfacing.message.model.MessageInfo;
import me.aurium.beetle.branch.interfacing.responses.SendableResponse;

import java.util.UUID;

public class FailedAdaptingResponse extends SendableResponse {

    public FailedAdaptingResponse(String expected_type, String actual_type) {
        super(CoreKeys.FAILED_ADAPTING, new MessageInfo("expected_type",toAdapt.getClass().getName()), new MessageInfo("actual_type",));
    }
}
