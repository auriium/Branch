package me.aurium.beetle.branch;

import me.aurium.beetle.branch.block.Block;

public interface IdentifiableNode<T> extends CommandNode<T> {

    Block getIdentifier();

    /* TODO tabcompleteHandler
    TabContextHandler<T> getSpecificTabHandler(BlockPath path);
    TabContextHandler<T> getTabHandler(); //tabhandler (probably just return this.id)*/

}
