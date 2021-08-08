package xyz.auriium.branch.results;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DelegatingImmutableList<T> implements ImmutableList<T> { //TODO

    private final List<T> delegate;

    DelegatingImmutableList(List<T> list) {
        this.delegate = list;
    }

    @Override
    public List<T> delegate() {
        return delegate;
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return delegate.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return delegate.iterator();
    }

    @Override
    public Object[] toArray() {
        return delegate.toArray();
    }

    @Override
    public T get(int index) {
        return delegate.get(index);
    }

    public List<T> getDelegate() {
        return delegate;
    }

    public static <E> DelegatingImmutableList<E> make(List<E> list) {
        return new DelegatingImmutableList<>(List.copyOf(list));
    }

    public static <E> DelegatingImmutableList<E> make() {
        return new DelegatingImmutableList<>(List.copyOf(new ArrayList<>()));
    }
}
