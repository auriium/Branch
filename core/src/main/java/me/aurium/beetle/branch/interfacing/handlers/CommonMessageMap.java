package me.aurium.beetle.branch.interfacing.handlers;

import me.aurium.beetle.branch.interfacing.model.Response;
import me.aurium.beetle.branch.interfacing.model.ResponseAction;

import java.util.HashMap;
import java.util.Map;

public class CommonMessageMap<T> implements MessageMap<T>, MessageProvider<T> {

    private final Map<Class<? extends Response>,ResponseAction<T,? extends Response>> map = new HashMap<>();

    @Override
    public <F extends Response> void add(Class<F> key, ResponseAction<T, F> action) {
        map.put(key,action); //TODO checks
    }

    @Override
    public ResponseActionHandler<T> make() {
        return new CommonResponseActionHandler<>(Map.copyOf(map));
    }
}
