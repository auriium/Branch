package me.aurium.beetle.branch.interfacing.handlers;

import me.aurium.beetle.branch.interfacing.model.Message;
import me.aurium.beetle.branch.interfacing.model.Response;
import me.aurium.beetle.branch.interfacing.model.ResponseAction;

import java.util.Map;

public class CommonResponseActionHandler<T> implements ResponseActionHandler<T> {

    private final Map<Class<? extends Response>, ResponseAction<T,? extends Response>> map;

    CommonResponseActionHandler(Map<Class<? extends Response>, ResponseAction<T,? extends Response>> map) {
        this.map = map;
    }

    @SuppressWarnings("unchecked")
    public <C extends Response> ResponseAction<T, C> get(Class<C> clazz) {
        ResponseAction<T,C> action = (ResponseAction<T, C>) map.get(clazz);

        if (action == null) throw new IllegalStateException("A response was requested but internal map had no binding!");

        return action;
    }

    @SuppressWarnings("unchecked")
    public <C extends Response> Message<T> getMessage(C response) {
        return get((Class<C>) response.getClass()).consume(response);
    }


}
