package me.aurium.beetle.branch.handlers.api;

import me.aurium.beetle.branch.handlers.context.NodeContext;

import java.util.List;

public interface SuggestionHandler<T> {

    List<String> handle(NodeContext<T> context);

}
