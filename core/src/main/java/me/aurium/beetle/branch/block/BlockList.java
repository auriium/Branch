package me.aurium.beetle.branch.block;

import java.util.List;

public interface BlockList{

    void addFirst(Block block);
    void addLast(Block block);

    void removeLast();

    Block getFirst();
    Block getLast();

    boolean isEmpty();
    int size();

    List<Block> getBackingList();

}
