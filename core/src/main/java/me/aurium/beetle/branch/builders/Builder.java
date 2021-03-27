package me.aurium.beetle.branch.builders;

import me.aurium.beetle.branch.nodes.CommandNode;
import me.aurium.beetle.branch.nodes.IdentifiableNode;

public interface Builder<C>{

    IdentifiableNode<C> build();
    CommandNode<C> buildWithoutIdentifier();

}
