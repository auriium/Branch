package xyz.auriium.branch.nodes.branching;

import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.nodes.IdentifiableNode;

import java.util.Set;

public class ExclusivePrestoredSet<T> implements PrestoredSet<T> {

    private final CommandNode<T> commandNode;
    private final Set<IdentifiableNode<T>> otherNodes;

    public ExclusivePrestoredSet(CommandNode<T> commandNode, Set<IdentifiableNode<T>> otherNodes) {
        this.commandNode = commandNode;
        this.otherNodes = otherNodes;
    }

    @Override
    public Set<IdentifiableNode<T>> getContents() {
        return otherNodes;
    }

    @Override
    public CommandNode<T> getSideNode() {
        return commandNode;
    }
}
