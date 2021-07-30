package xyz.auriium.branch.nodes.results;

import xyz.auriium.branch.execution.Block;

/**
 * Represents something that compares blocks
 */
public interface SearcherEquality {

    boolean equal(Block block, String popped);

}
