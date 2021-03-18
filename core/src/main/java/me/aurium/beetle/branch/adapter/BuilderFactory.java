package me.aurium.beetle.branch.adapter;

import me.aurium.beetle.branch.builders.BranchingBuilder;
import me.aurium.beetle.branch.builders.SingleBuilder;

public interface BuilderFactory<T> {

    SingleBuilder<T> single();
    BranchingBuilder<T> branching();


}
