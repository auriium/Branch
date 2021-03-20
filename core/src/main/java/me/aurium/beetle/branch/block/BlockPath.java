package me.aurium.beetle.branch.block;

public interface BlockPath {

    boolean isEmpty();

    boolean isSevered();
    boolean endsWith(Block path);
    boolean startsWith(Block path);

    /**
     * Gets a severed root blockpath at the base
     * @return the severed root.
     */
    BlockPath getRoot();

    /**
     * Get a blockpath one above this path
     * @return a cloned blockpath one above this
     */
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

    /**
     * Starts at an index
     * @param index the index to start from.
     *
     * Example: We are at some.cool.string and the fromIndex is 0
     * Now the cloned path is cool.string
     *
     * @return the subpath
     */
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
