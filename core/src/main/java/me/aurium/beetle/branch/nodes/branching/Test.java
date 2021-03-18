package me.aurium.beetle.branch.nodes.branching;

import me.aurium.beetle.branch.builder.BuilderPair;
import me.aurium.beetle.branch.nodes.single.SingleBuilder;

public class Test<T> implements BuilderPair<SingleBuilder<T>,T> {
    @Override
    public SingleBuilder<T> newBuilder() {
        return new SingleBuilder<>();
    }
}
