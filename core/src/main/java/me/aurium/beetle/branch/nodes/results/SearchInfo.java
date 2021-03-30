package me.aurium.beetle.branch.nodes.results;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.nodes.model.CommandNode;

import java.util.Deque;

public class SearchInfo<T> {

    private final CommandNode<T> calculatedNode;
    private final SearchInput input;

    public SearchInfo(CommandNode<T> calculatedNode, SearchInput input) {
        this.calculatedNode = calculatedNode;
        this.input = input;
    }

    public CommandNode<T> resultingNode() {
        return calculatedNode;
    }

    public Deque<Block> initialPath() {
        return input.getInitialPath();
    }

    public Deque<Block> reducedPath() {
        return input.getReducablePath();
    }

    public boolean hasMoreArguments() {
        return !input.getReducablePath().isEmpty();
    }
}
