package me.aurium.beetle.branch.handlers.api;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.handlers.context.NodeContext;

import java.util.List;

public interface SuggestionHandler<T> {

    List<Block> handle(NodeContext<T> context);

}
