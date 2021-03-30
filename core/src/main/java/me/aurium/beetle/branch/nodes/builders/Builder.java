package me.aurium.beetle.branch.nodes.builders;

import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.model.IdentifiableNode;

public interface Builder<C>{

    IdentifiableNode<C> build();
    CommandNode<C> buildWithoutIdentifier();

}
