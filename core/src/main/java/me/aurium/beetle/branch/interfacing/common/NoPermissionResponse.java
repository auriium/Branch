package me.aurium.beetle.branch.interfacing.common;

import me.aurium.beetle.branch.interfacing.model.Response;

public class NoPermissionResponse implements Response {

    private final String lackingPermission;

    public NoPermissionResponse(String lackingPermission) {
        this.lackingPermission = lackingPermission;
    }

    public String getLackingPermission() {
        return lackingPermission;
    }
}
