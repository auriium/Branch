package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.block.Block;

public interface IdentifiableNode<T> extends CommandNode<T> {

    Block getIdentifier();

}
