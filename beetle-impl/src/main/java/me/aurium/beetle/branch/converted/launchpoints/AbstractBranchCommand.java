package me.aurium.beetle.branch.converted.launchpoints;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.converted.BranchCommand;
import me.aurium.beetle.branch.nodes.CommandNode;
import me.aurium.beetle.branch.context.NodeContext;
import me.aurium.beetle.branch.context.ContextProducer;
import me.aurium.beetle.branch.block.CommonBlockPath;

/*
public abstract class AbstractBranchCommand<T> implements BranchCommand<T> {

    private final ContextProducer<T> factory;

    protected AbstractBranchCommand(ContextProducer<T> factory) {
        this.factory = factory;
    }

    @Override
    public boolean execute(T t, String s, String[] strings) {

        BlockPath path = CommonBlockPath.of(strings);

        CommandNode<T> baseNode = getBaseNode();

        //this logic should be in a Base
        GetNodeResult<T> result = baseNode.getSpecificNode(path);

        result.resultingNode().ifPresentOrElse(node -> {

            //TODO some kind of thing here
            NodeContext<T> adapter = factory.produce(t,s,strings,node,baseNode,path, result.resultingPath());

            node.getExecutionHandler().handle(adapter);

        }, () -> noArgsMissingOrError(factory.produce(t,s,strings)));

        return true;
    }
}
*/
