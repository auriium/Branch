package me.aurium.beetle.branch.nodes.builders;

import me.aurium.beetle.branch.fallback.message.BuilderMessageProvider;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.nodes.api.IdentifiableNode;

public interface Builder<C>{

    IdentifiableNode<C> build();
    CommandNode<C> buildWithoutIdentifier();

}
