package me.aurium.beetle.branch.interfacing.message.impl;

import me.aurium.beetle.branch.interfacing.message.model.InterfacingHandler;
import me.aurium.beetle.branch.interfacing.message.Message;
import me.aurium.beetle.branch.interfacing.message.model.MessageProvider;
import me.aurium.beetle.branch.interfacing.message.model.ResponseHandler;
import me.aurium.beetle.branch.interfacing.responses.ExecutionResponse;

public class CommonMessageHandler<T> implements InterfacingHandler<T> {

    private final ResponseHandler<T> handler;

    public CommonMessageHandler(MessageProvider<T> provider) {
        this.handler = new CommonResponseHandler<>(provider);
    }

    public CommonMessageHandler(ResponseHandler<T> handler) {
        this.handler = handler;
    }

    @Override
    public void sendMessage(T recipent, Message<T> message) {
        message.accept(recipent);
    }

    @Override
    public void sendMessage(T recipent, ExecutionResponse response) {
        handler.sendMessage(recipent,response);
    }

    @Override
    public void sendMessage(T recipent, String message) {

    }
}
