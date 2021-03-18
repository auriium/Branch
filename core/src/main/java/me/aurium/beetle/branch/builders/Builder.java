package me.aurium.beetle.branch.builders;

import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.IdentifiableNode;

public interface Builder<C>{

    IdentifiableNode<C> build();
    CommandNode<C> buildWithoutIdentifier();

}
