package me.aurium.beetle.branch.handlers.api;

import me.aurium.beetle.branch.context.NodeContext;

import java.util.List;

public interface SuggestionHandler<T> {

    List<String> handle(NodeContext<T> adapter);

}
