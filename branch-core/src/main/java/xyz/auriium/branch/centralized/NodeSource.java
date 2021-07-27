package xyz.auriium.branch.centralized;

import xyz.auriium.branch.execution.api.ExecutionHandler;
import xyz.auriium.branch.fallback.permissions.Permission;
import xyz.auriium.branch.interfacing.information.description.Description;
import xyz.auriium.branch.nodes.branching.ExclusiveBranchingBuilder;
import xyz.auriium.branch.nodes.branching.InclusiveBranchingBuilder;
import xyz.auriium.branch.nodes.single.SingleNode;
import xyz.auriium.branch.nodes.single.SingleNodeBuilder;

public interface NodeSource<T> {

    SingleNodeBuilder<T> single();
    InclusiveBranchingBuilder<T> inclusiveBranching();
    ExclusiveBranchingBuilder<T> exclusiveBranching();
    //TODO help and argument


    SingleNode<T> singleNode(String literal, ExecutionHandler<T> handler);
    SingleNode<T> singleNode(String literal, ExecutionHandler<T> handler, Permission<T> permission, Description description);

}
