package me.aurium.beetle.branch.context.staging;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.nodes.CommandNode;

public class MutableLocatorContext<T> {

    private final CommandNode<T> baseNode; //can't be changed
    private final BlockPath basePath;

    //these can be adjusted in staging
    private CommandNode<T> mutableTargetNode;
    private BlockPath mutableTargetPath;

    public MutableLocatorContext(CommandNode<T> baseNode, BlockPath basePath, CommandNode<T> mutableTargetNode, BlockPath mutableTargetPath) {
        this.baseNode = baseNode;
        this.basePath = basePath;
        this.mutableTargetNode = mutableTargetNode;
        this.mutableTargetPath = mutableTargetPath;
    }
    public CommandNode<T> getBaseNode() {
        return baseNode;
    }

    public BlockPath getBasePath() {
        return basePath;
    }

    public CommandNode<T> getMutableTargetNode() {
        return mutableTargetNode;
    }

    public BlockPath getMutableTargetPath() {
        return mutableTargetPath;
    }

    //TODO limit access (permissions should not be able to touch these)
    public void setMutableTargetNode(CommandNode<T> node) {
        this.mutableTargetNode = node;
    }

    public void setMutableTargetPath(BlockPath path) {
        this.mutableTargetPath = path;
    }

}
