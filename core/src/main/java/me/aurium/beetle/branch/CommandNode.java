package me.aurium.beetle.branch;

import me.aurium.beetle.branch.adapter.ContextHandlerAdapter;
import me.aurium.beetle.branch.block.BlockPath;

import java.util.Collection;
import java.util.Optional;

public interface CommandNode<T> {

    ContextHandlerAdapter<T> getContextHandler();

    Optional<IdentifiableNode<T>> getSpecificNode(BlockPath path);
    Collection<IdentifiableNode<T>> getLinkedNodes();

}
