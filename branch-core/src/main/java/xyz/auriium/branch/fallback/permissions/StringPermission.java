package xyz.auriium.branch.fallback.permissions;

public class StringPermission<T> implements Permission<T> {

    private final String permissionNode;

    public StringPermission(String permissionNode) {
        this.permissionNode = permissionNode;
    }

    @Override
    public boolean attempt(T sender, String alias, String[] args) {
        return false;
    }

    @Override
    public String failureIdentifiableName() {
        return null;
    }
}
