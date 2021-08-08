package xyz.auriium.branch.nodes.branching;

import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.nodes.IdentifiableNode;

import java.util.List;


//TODO refactor to prestoredList in order to allow user defined preferences
public interface PreStoredList<T> {

    List<IdentifiableNode<T>> getContents();
    CommandNode<T> getSideNode();

}
