package me.aurium.beetle.branch.builders;

import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.nodes.api.IdentifiableNode;

public interface Builder<C>{

    IdentifiableNode<C> build();
    CommandNode<C> buildWithoutIdentifier();

}
