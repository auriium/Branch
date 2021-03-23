package me.aurium.beetle.branch.permission;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.context.StagedContext;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;

public interface FallbackStrategy<T> {

    ExecutionHandler<T> strategy(StagedContext<T> stagedContext);

}
