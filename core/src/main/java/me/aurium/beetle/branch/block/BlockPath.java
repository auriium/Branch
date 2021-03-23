package me.aurium.beetle.branch.block;

import me.aurium.beetle.branch.context.NodeContext;

public interface BlockPath {

    boolean isEmpty();

    boolean isSevered();
    boolean endsWith(Block path);
    boolean startsWith(Block path);


    BlockPath getRoot();
    BlockPath getParent();

    /**
     * Adds all the blocks from a path
     * @param path the path to add
     * @return a cloned path plus all the blocks from that path
     */
    BlockPath resolve(BlockPath path);

    /**
     * Adds the block to this path
     * @param block the block to add
     * @return a cloned path plus that block
     */
    BlockPath resolve(Block block);

    BlockPath withoutBase();
    BlockPath withoutTop();

    BlockPath fromIndex(int index);

    int length();

    /**
     * Returns an ordered set of blocks
     * @return ordered set of blocks
     */
    BlockList getAllBlocks();

    /**
     * DO NOT USE THIS FOR COMPARISONS. THIS IS FOR DEBUGGING ONLY.
     * @return
     */
    String toString();

}
