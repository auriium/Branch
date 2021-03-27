package me.aurium.beetle.branch.handlers;

import me.aurium.beetle.branch.handlers.context.NodeContext;
import me.aurium.beetle.branch.handlers.api.SuggestionHandler;

import java.util.ArrayList;
import java.util.List;

public class EmptySuggestionHandler<T> implements SuggestionHandler<T> {

    private final List<String> emptyList = new ArrayList<>();

    @Override
    public List<String> handle(NodeContext<T> adapter) {
        return List.of();
    }
}
