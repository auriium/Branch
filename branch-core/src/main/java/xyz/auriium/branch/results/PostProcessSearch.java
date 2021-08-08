package xyz.auriium.branch.results;

import xyz.auriium.branch.base.execution.blocks.Block;
import xyz.auriium.branch.nodes.CommandNode;

import java.util.List;

public class PostProcessSearch<T> {

    private final CommandNode<T> foundNode;

    private final ImmutableList<String> originalStrings;
    private final List<String> remainingStrings;

    private final List<Block> originalBlocks;
    private final List<Block> allBlocks;

    PostProcessSearch(CommandNode<T> foundNode, ImmutableList<String> originalStrings, List<String> remainingStrings, List<Block> originalBlocks, List<Block> allBlocks) {
        this.foundNode = foundNode;
        this.originalStrings = originalStrings;
        this.remainingStrings = remainingStrings;
        this.originalBlocks = originalBlocks;
        this.allBlocks = allBlocks;
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

    public List<Block> getAllBlocks() {
        return allBlocks;
    }

    public CommandNode<T> getFoundNode() {
        return foundNode;
    }

    public static <E> PostProcessSearch<E> generate(PreProcessSearch<E> input) {
        return new PostProcessSearch<>(
                input.getFoundNode(),
                input.getOriginalStrings(),
                input.getRemainingStrings(),
                input.getOriginalBlocks(),
                List.copyOf(input.getRemainingBlocks())
        );
    }
}
