package me.aurium.beetle.branch.bases;

import me.aurium.beetle.api.command.AbstractCommand;
import me.aurium.beetle.branch.CommandBase;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.Context;
import me.aurium.beetle.branch.ContextHandler;
import me.aurium.beetle.branch.impl.CommonContext;

public class CommandableBase<T> implements CommandBase<T>, AbstractCommand<T> {

    private final String name;
    private final String permission;
    private final CommandNode<T> node;

    public CommandableBase(String name, String permission, CommandNode<T> node) {
        this.name = name;
        this.permission = permission;
        this.node = node;
    }

    @Override
    public ContextHandler<T> getHandler(Context<T> context) {
        return null;
    }

    @Override
    public void handle(Context<T> context) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPermission() {
        return null;
    }

    @Override
    public boolean execute(T t, String alias, String[] strings) {
        Context<T> context = new CommonContext<>(t,alias,strings);

        handle(context);

        return true;
    }
}
