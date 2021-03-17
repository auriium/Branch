package me.aurium.beetle.branch.block;

public interface Block {

    String getIdentifier();
    BlockPath asSingleBlockpath();

    boolean equals(Object object);

}
