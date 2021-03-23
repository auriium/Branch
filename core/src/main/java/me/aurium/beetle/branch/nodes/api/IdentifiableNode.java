package me.aurium.beetle.branch.nodes.api;

import me.aurium.beetle.branch.block.Block;

public interface IdentifiableNode<T> extends CommandNode<T> {

    Block getIdentifier();

}
