package me.aurium.beetle.branch;

import me.aurium.beetle.api.block.path.Block;
import me.aurium.beetle.api.block.path.BlockPath;
import me.aurium.beetle.api.command.ContextHandler;

import java.util.Collection;
import java.util.Optional;

public interface CommandNode<T> {

    Block getIdentifier();

    Optional<T> getSpecificNode(BlockPath path);

    Collection<T> getLinkedNodes();

    /**
     * Represents the context handler to be used if there are no args or args are incorrect
     * @return said contexthandler...
     */
    ContextHandler<T> getContextHandler();

    /*TODO tabcompleteHandler
    TabContextHandler<T> getSpecificTabHandler(BlockPath path);
    TabContextHandler<T> getTabHandler(); //tabhandler (probably just return this.id)*/

}
