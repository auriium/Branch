package me.aurium.beetle.branch.interfacing.handlers;

import me.aurium.beetle.branch.interfacing.model.Message;
import me.aurium.beetle.branch.interfacing.model.Response;

import java.util.concurrent.FutureTask;

public class CommonInterfacingHandler<T> implements InterfacingHandler<T> {

    private final ResponseActionHandler<T> handler;

    public CommonInterfacingHandler(ResponseActionHandler<T> provider) {
        this.handler = provider;
    }

    @Override
    public void sendMessage(T recipent, Message<T> message) {
        message.accept(recipent);
    }

    @Override
    public void sendMessage(T recipent, Response response) {
        handler.getMessage(response).accept(recipent);
    }

}
