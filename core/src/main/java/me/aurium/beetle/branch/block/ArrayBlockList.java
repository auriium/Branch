package me.aurium.beetle.branch.block;

import java.util.*;

public class ArrayBlockList implements BlockList{

    private final List<Block> delegatingList;

    public ArrayBlockList() {
        this.delegatingList = new ArrayList<>();
    }

    public ArrayBlockList(List<Block> subList) {
        this.delegatingList = subList;
    }

    @Override
    public void addFirst(Block block) {
        delegatingList.add(0,block);
    }

    @Override
    public void addLast(Block block) {
        delegatingList.add(block);
    }

    @Override
    public Block getFirst() {
        return delegatingList.get(0);
    }

    @Override
    public Block getLast() {
        return delegatingList.get(delegatingList.size()-1);
    }

    @Override
    public int size() {
        return delegatingList.size();
    }

    @Override
    public boolean isEmpty() {
        return delegatingList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return delegatingList.contains(o);
    }

    @Override
    public Iterator<Block> iterator() {
        return delegatingList.iterator();
    }

    @Override
    public Object[] toArray() {
        return delegatingList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return delegatingList.toArray(a);
    }

    @Override
    public boolean add(Block block) {
        return delegatingList.add(block);
    }

    @Override
    public boolean remove(Object o) {
        return delegatingList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return delegatingList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Block> c) {
        return delegatingList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Block> c) {
        return delegatingList.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return delegatingList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return delegatingList.retainAll(c);
    }

    @Override
    public void clear() {
        delegatingList.clear();
    }

    @Override
    public Block get(int index) {
        return delegatingList.get(index);
    }

    @Override
    public Block set(int index, Block element) {
        return delegatingList.set(index,element);
    }

    @Override
    public void add(int index, Block element) {
        delegatingList.add(index,element);
    }

    @Override
    public Block remove(int index) {
        return delegatingList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return delegatingList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return delegatingList.lastIndexOf(o);
    }

    @Override
    public ListIterator<Block> listIterator() {
        return delegatingList.listIterator();
    }

    @Override
    public ListIterator<Block> listIterator(int index) {
        return delegatingList.listIterator(index);
    }

    @Override
    public List<Block> subList(int fromIndex, int toIndex) {
        return delegatingList.subList(fromIndex, toIndex);
    }
}
