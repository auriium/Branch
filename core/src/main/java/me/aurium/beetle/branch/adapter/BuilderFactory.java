package me.aurium.beetle.branch.adapter;

import me.aurium.beetle.branch.nodes.branching.BranchingBuilder;
import me.aurium.beetle.branch.nodes.single.SingleBuilder;

public interface BuilderFactory<T> {

    SingleBuilder<T> single();
    BranchingBuilder<T> branching();


}
