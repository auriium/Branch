package me.aurium.beetle.branch.fallback.message.impl;

import me.aurium.beetle.branch.fallback.message.*;

import java.util.Map;

public class CommonMessageHandler<T> implements MessageHandler<T> {

    private final Map<MessageKey, Message<T>> messages;

    public CommonMessageHandler(Map<MessageKey, Message<T>> messages) {
        this.messages = messages;
    }

    public CommonMessageHandler(MessageProvider<T> messages) {
        this.messages = messages.make();
    }

    @Override
    public void sendMessage(T t, MessageInfo info) {
        Message<T> message = messages.get(info.getKey());

        if (message == null) throw new IllegalArgumentException("No message mapped to key!");

        message.accept(t);
    }
}
