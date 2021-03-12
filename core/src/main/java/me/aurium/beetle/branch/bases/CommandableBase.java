package me.aurium.beetle.branch.bases;

import me.aurium.beetle.api.command.Command;
import me.aurium.beetle.api.command.ContextSource;
import me.aurium.beetle.branch.CommandNode;

import java.util.Collection;

public class CommandableBase<T> extends SimpleBase<T> implements Command<T> {

    private final String name;
    private final String permission;
    private final ContextSource<T> source;

    public CommandableBase(CommandNode<T> node, String name, String permission, ContextSource<T> source) {
        super(node);
        this.name = name;
        this.permission = permission;
        this.source = source;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPermission() {
        return permission;
    }

    @Override
    public boolean execute(T t, String s, String[] strings) {

        this.handleContext(source.context(t,s,strings));

        return true;
    }

    @Override
    public Collection<String> getAliases() {
        return null;
    }

    @Override
    public Collection<String> tabComplete(T sender, String alias, String[] args) {
        return null;
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
