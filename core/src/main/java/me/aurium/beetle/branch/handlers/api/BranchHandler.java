package me.aurium.beetle.branch.handlers.api;

import me.aurium.beetle.branch.handlers.context.NodeContext;
import me.aurium.beetle.branch.nodes.results.model.Result;

import java.util.List;

public interface BranchHandler<T> {

    Result<Execution<T>> getExecution(NodeContext<T> context);
    List<String> getSuggestions(NodeContext<T> context);

}
