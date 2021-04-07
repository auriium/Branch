package me.aurium.beetle.branch.fun;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Represents a set that already has an element in it
 */
public class PreStoredHashSet<T> {

    private final T alreadyStored;
    private final Set<T> otherThingsInTheSet;
    private final boolean linked;

    //fuck code in the constructor rules
    //i don't care
    public PreStoredHashSet(T alreadyStored, boolean linked) {
        this.alreadyStored = alreadyStored;
        this.otherThingsInTheSet = new HashSet<>();
        this.linked = linked;
    }
    public PreStoredHashSet(T alreadyStored, Set<T> set, boolean linked) {
        this.alreadyStored = alreadyStored;
        this.otherThingsInTheSet = set;
        this.linked = linked;
    }

    public PreStoredHashSet(Set<T> set, boolean linked) {
        this.alreadyStored = null;
        this.otherThingsInTheSet = set;
        this.linked = linked;
    }

    /**
     * Returns an immutable collection of T (plus already stored variable if it is present)
     * @return an immutable collection of T
     */
    public Set<T> getContents() {
        if (linked) {
            if (alreadyStored == null) {
                return Set.copyOf(otherThingsInTheSet);
            } else {
                Set<T> set = new HashSet<>(otherThingsInTheSet);

                set.add(alreadyStored);

                return Set.copyOf(set);
            }
        } else {
            return Set.copyOf(otherThingsInTheSet);
        }
    }

    /**
     * get already store thing
     * @return already stored thing or null
     */
    public T getAlreadyStored() {
        return alreadyStored;
    }

}
