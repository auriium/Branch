package me.aurium.beetle.branch.nodes.result;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.nodes.api.CommandNode;

import java.util.Optional;

public class NullableNodeResult<T> implements GetNodeResult<T> {

    private final CommandNode<T> calculatedNode;
    private final BlockPath calculatedPath;

    public NullableNodeResult(CommandNode<T> calculatedNode, BlockPath calculatedPath) {
        this.calculatedNode = calculatedNode;
        this.calculatedPath = calculatedPath;
    }

    @Override
    public Optional<CommandNode<T>> resultingNode() {
        return Optional.ofNullable(calculatedNode);
    }

    @Override
    public BlockPath resultingPath() {
        return calculatedPath;
    }
}
