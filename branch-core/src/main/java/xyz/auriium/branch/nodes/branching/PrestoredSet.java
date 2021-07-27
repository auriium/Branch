package xyz.auriium.branch.nodes.branching;

import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.nodes.IdentifiableNode;

import java.util.Set;

public interface PrestoredSet<T> {

    Set<IdentifiableNode<T>> getContents();
    CommandNode<T> getSideNode();

}
