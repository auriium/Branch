package me.aurium.beetle.branch.nodes.argument;

import me.aurium.beetle.branch.context.NodeContext;

public interface ArgumentContext<T> extends NodeContext<T> {

    Arguments getArgumentContainer();
    
}
