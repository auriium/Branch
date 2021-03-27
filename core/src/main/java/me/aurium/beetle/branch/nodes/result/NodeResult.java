package me.aurium.beetle.branch.nodes.result;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.nodes.api.CommandNode;

public class NodeResult<T> {

    private final CommandNode<T> calculatedNode;
    private final BlockPath calculatedPath;

    public NodeResult(CommandNode<T> calculatedNode, BlockPath calculatedPath) {
        this.calculatedNode = calculatedNode;
        this.calculatedPath = calculatedPath;
    }

    public CommandNode<T> resultingNode() {
        return calculatedNode;
    }

    public BlockPath resultingPath() {
        return calculatedPath;
    }
}
