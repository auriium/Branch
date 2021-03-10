package me.aurium.beetle.branch;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a set that already has an element in it
 */
public class AlreadyStoredHashSet<T> {

    private T alreadyStored;
    private final Set<T> otherThingsInTheSet;

    //fuck code in the constructor rules
    //i don't care
    public AlreadyStoredHashSet(T alreadyStored) {
        this.alreadyStored = alreadyStored;
        this.otherThingsInTheSet = new HashSet<>();
    }

    public AlreadyStoredHashSet(Set<T> set) {
        this.otherThingsInTheSet = set;
    }

    public AlreadyStoredHashSet() {
        this.otherThingsInTheSet = new HashSet<>();
    }

    /**
     * Returns an immutable collection of T (plus already stored variable if it is present)
     * @return an immutable collection of T
     */
    public Set<T> getContents() {
        if (alreadyStored == null) {
            return Set.copyOf(otherThingsInTheSet);
        } else {
            Set<T> set = new HashSet<>(otherThingsInTheSet);

            set.add(alreadyStored);

            return Set.copyOf(set);
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
