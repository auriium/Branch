package me.aurium.beetle.branch.handlers.context;

public interface Context<T> {

    T getSender();
    String getAlias();
    String[] getArgs();

    void messageSender(String string);

}
