package xyz.auriium.branch.base.permissions;

import xyz.auriium.branch.base.NodeContext;

public class StringPermission<T> implements Permission<T> {

    private final String permissionNode;

    public StringPermission(String permissionNode) {
        this.permissionNode = permissionNode;
    }

    @Override
    public boolean attempt(NodeContext<T> nodeContext) {
        return nodeContext.hasStringPermissible(permissionNode);
    }

    @Override
    public String failureIdentifiableName() {
        return permissionNode;
    }
}
