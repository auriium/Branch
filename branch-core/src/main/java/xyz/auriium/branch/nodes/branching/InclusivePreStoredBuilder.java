package xyz.auriium.branch.nodes.branching;

import xyz.auriium.branch.nodes.CommandNode;
import xyz.auriium.branch.nodes.IdentifiableNode;
import xyz.auriium.branch.nodes.help.HelpNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InclusivePreStoredBuilder<T> {

    private final List<IdentifiableNode<T>> nodes = new ArrayList<>();
    private volatile IdentifiableNode<T> base;

    public static <T> InclusivePreStoredBuilder<T> of() {
        return new InclusivePreStoredBuilder<>();
    }

    /**
     * Sets the no-args handling node
     * @param node the node
     * @return a value
     */
    public InclusivePreStoredBuilder<T> withNoArgs(IdentifiableNode<T> node) {
        this.base = node;

        return this;
    }

    /**
     * Adds an node into the builder (ordered)
     * @param node the node
     * @return this builder
     */
    public InclusivePreStoredBuilder<T> addNode(IdentifiableNode<T> node) {
        nodes.add(node);

        return this;
    }

    public PreStoredList<T> make() {
        IdentifiableNode<T> node = Objects.requireNonNullElse(base, HelpNode.of());
        List<IdentifiableNode<T>> list = new ArrayList<>(nodes);

        list.add(node);

        return new CommonPreStoredList<>(list, node);
    }

}
