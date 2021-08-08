package xyz.auriium.branch.results;

import xyz.auriium.branch.base.execution.blocks.Block;

import java.util.*;

/**
 * TODO redux of searcher info/input that relies on a base-provided equality input in order to give
 * nodes the option of how they want to compare block equality
 */
public class InitialSearch<T> {


    private final SearcherEquality equality;

    private final ImmutableList<String> originalStrings;
    private final Queue<String> remainingStrings;
    private final Queue<Block> originalBlocks = new LinkedList<>();
    //private final Queue<CommandNode<T>> nodes = new LinkedList<>();

    public InitialSearch(SearcherEquality equality, ImmutableList<String> originalStrings) {
        this.equality = equality;

        this.originalStrings = originalStrings;
        this.remainingStrings = new LinkedList<>(originalStrings.delegate());
    }

    public ImmutableList<String> getOriginalStrings() {
        return originalStrings;
    }

    public Queue<String> getRemainingStrings() {
        return remainingStrings;
    }

    public Queue<Block> getOriginalBlocks() {
        return originalBlocks;
    }

    public SearcherEquality getEquality() {
        return equality;
    }

    public static <T> InitialSearch<T> of(SearcherEquality equality, String[] args) {
        return new InitialSearch<>(equality, DelegatingImmutableList.make(Arrays.asList(args)));

    }

    public static <T> InitialSearch<T> withoutTop(InitialSearch<T> search) {
        List<String> newBase = new ArrayList<>(search.getOriginalStrings().delegate());

        newBase.remove(newBase.size() - 1);

        return new InitialSearch<>(search.getEquality(), DelegatingImmutableList.make(newBase));
    }
}
