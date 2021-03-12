package me.aurium.beetle.branch;

import me.aurium.beetle.api.command.Context;
import me.aurium.beetle.api.command.ContextHandler;

public interface CommandBase<T> {

    ContextHandler<T> getHandler(Context<T> context);
    void handleContext(Context<T> context);

}
