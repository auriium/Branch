package me.aurium.beetle.branch.context.staging;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.nodes.CommandNode;

public class InitialLocatorContext<T> {

    private final CommandNode<T> baseNode;
    private final BlockPath basePath;


    public InitialLocatorContext(CommandNode<T> baseNode, BlockPath basePath) {
        this.baseNode = baseNode;
        this.basePath = basePath;
    }
}
