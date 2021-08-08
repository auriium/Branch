package xyz.auriium.branch.nodes.branching;

import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.nodes.IdentifiableNode;

import java.util.List;

public class CommonPreStoredList<T> implements PreStoredList<T> {

    private final List<IdentifiableNode<T>> contents;
    private final CommandNode<T> node;

    public CommonPreStoredList(List<IdentifiableNode<T>> contents, CommandNode<T> node) {
        this.contents = contents;
        this.node = node;
    }

    @Override
    public List<IdentifiableNode<T>> getContents() {
        return contents;
    }

    @Override
    public CommandNode<T> getSideNode() {
        return node;
    }
}
