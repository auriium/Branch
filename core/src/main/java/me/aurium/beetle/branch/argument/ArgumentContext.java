package me.aurium.beetle.branch.argument;

import me.aurium.beetle.branch.context.NodeContext;

public interface ArgumentContext<T> extends NodeContext<T> {

    Arguments getArgumentContainer();
    
}
