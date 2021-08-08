package xyz.auriium.branch.results;

import xyz.auriium.branch.base.execution.blocks.Block;
import xyz.auriium.branch.nodes.CommandNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PreProcessSearch<T> {

    private final CommandNode<T> foundNode;

    private final ImmutableList<String> originalStrings;
    private final List<String> remainingStrings;

    private final List<Block> originalBlocks;
    private final Queue<Block> remainingBlocks;

    public PreProcessSearch(CommandNode<T> foundNode, ImmutableList<String> originalStrings, List<String> remainingStrings, List<Block> originalBlocks, Queue<Block> remainingBlocks) {
        this.foundNode = foundNode;
        this.originalStrings = originalStrings;
        this.remainingStrings = remainingStrings;
        this.originalBlocks = originalBlocks;
        this.remainingBlocks = remainingBlocks;
    }

    public ImmutableList<String> getOriginalStrings() {
        return originalStrings;
    }

    public List<String> getRemainingStrings() {
        return remainingStrings;
    }

    public List<Block> getOriginalBlocks() {
        return originalBlocks;
    }

    public Queue<Block> getRemainingBlocks() {
        return remainingBlocks;
    }

    public CommandNode<T> getFoundNode() {
        return foundNode;
    }

    public static <E> PreProcessSearch<E> generate(CommandNode<E> node, InitialSearch<E> input) {
        return new PreProcessSearch<>(
                node,
                input.getOriginalStrings(),
                List.copyOf(input.getRemainingStrings()),
                List.copyOf(input.getOriginalBlocks()),
                new LinkedList<>());
    }
}
