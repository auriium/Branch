package me.aurium.beetle.branch.nodes.results;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.block.StringBlock;

import java.util.ArrayDeque;
import java.util.Deque;

public class SearchInput {

    private final Deque<Block> initialPath;
    private final Deque<Block> reducablePath;

    public SearchInput(Deque<Block> initialPath, Deque<Block> reducablePath) {
        this.initialPath = initialPath;
        this.reducablePath = reducablePath;
    }

    public Deque<Block> getInitialPath() {
        return initialPath;
    }

    public Deque<Block> getReducablePath() {
        return reducablePath;
    }

    public SearchInput withoutTop() {
        Deque<Block> newBase = new ArrayDeque<>(initialPath);

        newBase.removeLast();

        return of(newBase);
    }

    public static SearchInput of(Deque<Block> initialPath) {
        return new SearchInput(initialPath,new ArrayDeque<>(initialPath));
    }

    public static SearchInput of(String[] args) {
        Deque<Block> blocks = new ArrayDeque<>();

        for (String string : args) {
            blocks.addLast(StringBlock.of(string));
        }

        return of(blocks);
    }
}
