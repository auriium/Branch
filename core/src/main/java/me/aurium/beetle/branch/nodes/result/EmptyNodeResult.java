package me.aurium.beetle.branch.nodes.result;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.nodes.api.CommandNode;

import java.util.Optional;

public class EmptyNodeResult<T> implements GetNodeResult<T> {

    private final BlockPath path;

    public EmptyNodeResult(BlockPath path) {
        this.path = path;
    }

    @Override
    public Optional<CommandNode<T>> resultingNode() {
        return Optional.empty();
    }

    @Override
    public BlockPath resultingPath() {
        return path;
    }
}
