package xyz.auriium.branch.interfacing.exceptional.printing;

import xyz.auriium.branch.interfacing.exceptional.AnomalyType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class SettablePrinter<M> implements AnomalyPrinter<M> {

    private final Map<AnomalyType, Function<M,M>> map = new HashMap<>();

    @Override
    public M makeMessage(AnomalyType type, M string) {
        var func = map.get(type);

        if (func == null) throw new IllegalStateException("No type parser found for type: " + type.name());

        return func.apply(string);
    }

    public SettablePrinter<M> add(AnomalyType type, Function<M,M> function) {
        this.map.put(type,function);

        return this;
    }




}
