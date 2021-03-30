package me.aurium.beetle.branch.handlers.api;

import me.aurium.beetle.branch.handlers.context.NodeContext;

import java.util.List;

public interface BranchHandler<T> {

    void getExecution(NodeContext<T> context);
    List<String> getSuggestions(NodeContext<T> context);

}
