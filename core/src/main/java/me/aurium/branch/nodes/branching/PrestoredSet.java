package me.aurium.branch.nodes.branching;

import me.aurium.branch.nodes.CommandNode;
import me.aurium.branch.nodes.IdentifiableNode;

import java.util.Set;

public interface PrestoredSet<T> {

    Set<IdentifiableNode<T>> getContents();
    CommandNode<T> getSideNode();

}
