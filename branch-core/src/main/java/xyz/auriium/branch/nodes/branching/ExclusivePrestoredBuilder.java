package xyz.auriium.branch.nodes.branching;

import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.nodes.IdentifiableNode;
import xyz.auriium.branch.nodes.help.HelpNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExclusivePrestoredBuilder<T> {

    private final List<IdentifiableNode<T>> nodes = new ArrayList<>();
    private volatile CommandNode<T> base;

    public static <T> ExclusivePrestoredBuilder<T> of() {
        return new ExclusivePrestoredBuilder<>();
    }

    /**
     * Sets the no-args handling node
     * @param node the node
     * @return a value
     */
    public ExclusivePrestoredBuilder<T> withNoArgs(CommandNode<T> node) {
        this.base = node;

        return this;
    }

    /**
     * Adds an node into the builder (ordered)
     * @param node the node
     * @return this builder
     */
    public ExclusivePrestoredBuilder<T> addNode(IdentifiableNode<T> node) {
        nodes.add(node);

        return this;
    }

    public PreStoredList<T> make() {
        return new CommonPreStoredList<>(nodes, Objects.requireNonNullElse(base, HelpNode.of()));
    }
}
