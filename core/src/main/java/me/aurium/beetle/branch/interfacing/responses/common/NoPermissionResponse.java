package me.aurium.beetle.branch.interfacing.responses.common;

import me.aurium.beetle.branch.interfacing.responses.SendableResponse;
import me.aurium.beetle.branch.interfacing.CoreKeys;
import me.aurium.beetle.branch.interfacing.message.model.MessageInfo;
import me.aurium.beetle.branch.nodes.model.CommandNode;

public class NoPermissionResponse extends SendableResponse {

    public NoPermissionResponse(CommandNode<?> node) {
        super(CoreKeys.NO_PERMISSIONS, new NoPermissionInfo(node));
    }

    public static class NoPermissionInfo extends MessageInfo {

        public NoPermissionInfo(CommandNode<?> node) {
            super("permission", node.getPermission().easyName());
        }
    }
}
