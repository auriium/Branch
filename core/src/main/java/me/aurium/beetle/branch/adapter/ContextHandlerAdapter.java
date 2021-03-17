package me.aurium.beetle.branch.adapter;

public interface ContextHandlerAdapter<T> {

    void handle(ContextAdapter<T> adapter);

}
