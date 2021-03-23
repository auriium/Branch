package me.aurium.beetle.branch.context;

public interface Context<T> {

    T getSender();
    String getAlias();
    String[] getArgs();

    void messageSender(String string);

}
