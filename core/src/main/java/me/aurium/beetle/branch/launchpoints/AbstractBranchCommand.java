package me.aurium.beetle.branch.launchpoints;

import me.aurium.beetle.branch.BranchCommand;
import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.adapter.ContextAdapter;
import me.aurium.beetle.branch.adapter.ContextAdapterFactory;
import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.block.CommonBlockPath;

public abstract class AbstractBranchCommand<T> implements BranchCommand<T> {

    private final ContextAdapterFactory<T> factory;

    protected AbstractBranchCommand(ContextAdapterFactory<T> factory) {
        this.factory = factory;
    }

    @Override
    public boolean execute(T t, String s, String[] strings) {

        BlockPath path = CommonBlockPath.of(strings);

        CommandNode<T> baseNode = getBaseNode();

        baseNode.getSpecificNode(path).ifPresentOrElse(node -> {
            ContextAdapter<T> adapter = factory.produce(t,s,strings,node,baseNode,path);

            node.getContextHandler().handle(adapter);
        }, () -> {
            noArgsMissingOrError().handle(factory.context(t,s,strings));
        });

        return true;
    }
}
