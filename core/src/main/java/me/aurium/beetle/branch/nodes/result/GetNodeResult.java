package me.aurium.beetle.branch.nodes.result;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.nodes.api.CommandNode;

import java.util.Optional;

public interface GetNodeResult<T> {

    Optional<CommandNode<T>> resultingNode();
    BlockPath resultingPath();

}
