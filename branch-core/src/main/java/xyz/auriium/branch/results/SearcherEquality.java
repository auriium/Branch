package xyz.auriium.branch.results;

import xyz.auriium.branch.base.execution.blocks.Block;

/**
 * Represents something that compares blocks
 */
public interface SearcherEquality {

    boolean equal(Block block, String popped);

}
