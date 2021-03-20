package me.aurium.beetle.branch.block;

import java.util.LinkedList;

public interface Block {

    String getIdentifier();
    BlockPath asSingleBlockpath();

    boolean equals(Object object);

    default void addLast(BlockList list) {
        list.addLast(this);
    }
    default void addFirst(BlockList list) {
        list.addFirst(this);
    }

}
