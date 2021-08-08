package xyz.auriium.branch.base.suggestion;

import xyz.auriium.branch.base.execution.blocks.Block;
import xyz.auriium.branch.base.permissions.Permission;

public class Suggestion<T> {

    private final Permission<T> permission;
    private final Block identifier;

    public Suggestion(Permission<T> permission, Block identifier) {
        this.permission = permission;
        this.identifier = identifier;
    }

    public Permission<T> getPermission() {
        return permission;
    }

    public Block getIdentifier() {
        return identifier;
    }
}
