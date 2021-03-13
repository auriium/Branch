package me.aurium.beetle.branch.nodes;

public interface BranchingFunc<T> {

    void accept(BranchingFrame<T> frame);

}
