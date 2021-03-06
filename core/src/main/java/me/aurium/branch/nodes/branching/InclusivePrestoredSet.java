package me.aurium.branch.nodes.branching;

import me.aurium.branch.nodes.IdentifiableNode;

import java.util.HashSet;
import java.util.Set;

public class InclusivePrestoredSet<T> implements PrestoredSet<T> {

    private final IdentifiableNode<T> alreadyStored;
    private final Set<IdentifiableNode<T>> otherThingsInTheSet;

    public InclusivePrestoredSet(IdentifiableNode<T> alreadyStored, Set<IdentifiableNode<T>> otherThingsInTheSet) {
        this.alreadyStored = alreadyStored;
        this.otherThingsInTheSet = otherThingsInTheSet;
    }

    @Override
    public Set<IdentifiableNode<T>> getContents() {
        Set<IdentifiableNode<T>> pas = new HashSet<>(otherThingsInTheSet);

        pas.add(alreadyStored);

        return Set.copyOf(pas);
    }

    @Override
    public IdentifiableNode<T> getSideNode() {
        return alreadyStored;
    }
}
