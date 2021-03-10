package me.aurium.beetle.branch;

import me.aurium.beetle.api.nodes.Node;

public interface CommandNode<T> extends Node<CommandNode<T>> {

    /**
     * Represents the context handler to be used if there are no args or args are incorrect
     * @return said contexthandler...
     */
    ContextHandler<T> getContextHandler();

}
