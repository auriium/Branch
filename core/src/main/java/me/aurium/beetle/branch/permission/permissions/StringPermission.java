package me.aurium.beetle.branch.permission.permissions;

import me.aurium.beetle.branch.context.StagedContext;
import me.aurium.beetle.branch.permission.Permission;

/**
 * example permission i'm using for testing because i'm so godfucking bored
 */
public class StringPermission implements Permission<String> {

    private final String string;

    public StringPermission(String string) {
        this.string = string;
    }

    @Override
    public boolean attempt(StagedContext<String> context) {
        return context.getSender().equals(string);
    }
}
