package me.aurium.branch.centralized;

import me.aurium.branch.nodes.branching.ExclusiveBranchingBuilder;
import me.aurium.branch.nodes.branching.InclusiveBranchingBuilder;
import me.aurium.branch.nodes.single.SingleBuilder;

public interface CommonNodeSource<T> {

    SingleBuilder<T> single();
    InclusiveBranchingBuilder<T> inclusiveBranching();
    ExclusiveBranchingBuilder<T> exclusiveBranching();
    //TODO help and argument

}
