package me.aurium.beetle.branch;

@FunctionalInterface
public interface ContextHandler<T> {

    void consume(Context<T> consumed);

}
