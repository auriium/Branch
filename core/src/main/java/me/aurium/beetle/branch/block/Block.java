package me.aurium.beetle.branch.block;

import java.util.LinkedList;

public interface Block {

    String getIdentifier();
    BlockPath asSingleBlockpath();

    boolean equals(Object object);

    default void addLast(LinkedList<Block> list) {
        list.addLast(this);
    }
    default void addFirst(LinkedList<Block> list) {
        list.addFirst(this);
    }

}
