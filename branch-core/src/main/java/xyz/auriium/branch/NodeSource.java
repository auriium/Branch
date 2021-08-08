package xyz.auriium.branch;

import xyz.auriium.branch.base.execution.ExecutionHandler;
import xyz.auriium.branch.base.permissions.Permission;
import xyz.auriium.branch.nodes.description.Description;
import xyz.auriium.branch.nodes.branching.BranchingBuilder;
import xyz.auriium.branch.nodes.single.SingleNode;
import xyz.auriium.branch.nodes.single.SingleNodeBuilder;

public interface NodeSource<T> {

    SingleNodeBuilder<T> single();
    BranchingBuilder<T> branch();
    //TODO argument


    SingleNode<T> singleNode(String literal, ExecutionHandler<T> handler);
    SingleNode<T> singleNode(String literal, ExecutionHandler<T> handler, Permission<T> permission, Description description);

}
