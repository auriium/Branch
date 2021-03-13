package me.aurium.beetle.branch.builders;

import me.aurium.beetle.branch.CommandNode;

public interface NodeBuilder<C extends CommandNode<T>, T> {

    C build();

}
