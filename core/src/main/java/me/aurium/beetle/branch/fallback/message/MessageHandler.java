package me.aurium.beetle.branch.fallback.message;

public interface MessageHandler<T> {

    void sendMessage(T t, MessageInfo key);

}
