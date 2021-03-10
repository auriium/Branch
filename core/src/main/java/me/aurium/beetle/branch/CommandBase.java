package me.aurium.beetle.branch;

public interface CommandBase<T> {

    ContextHandler<T> getHandler(Context<T> context);
    void handle(Context<T> context);

}
