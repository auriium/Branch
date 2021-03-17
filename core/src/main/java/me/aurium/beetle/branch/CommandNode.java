package me.aurium.beetle.branch;

import me.aurium.beetle.api.command.ContextHandler;
import me.aurium.beetle.branch.adapter.ContextHandlerAdapter;
import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.BlockPath;

import java.util.Collection;
import java.util.Optional;

public interface CommandNode<T> {

    Block getIdentifier();
    ContextHandlerAdapter<T> getContextHandler();

    Optional<CommandNode<T>> getSpecificNode(BlockPath path);
    Collection<CommandNode<T>> getLinkedNodes();






    /* TODO tabcompleteHandler
    TabContextHandler<T> getSpecificTabHandler(BlockPath path);
    TabContextHandler<T> getTabHandler(); //tabhandler (probably just return this.id)*/

}
