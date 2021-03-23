package me.aurium.beetle.branch.nodes.base;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.block.CommonBlockPath;
import me.aurium.beetle.branch.context.ContextProducer;
import me.aurium.beetle.branch.context.NodeContext;
import me.aurium.beetle.branch.handlers.api.FallbackHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.nodes.result.GetNodeResult;
import me.aurium.beetle.branch.permission.PermAccessor;
import me.aurium.beetle.branch.permission.PermissionStrategy;

import java.util.List;

public class SimpleNodeBase<T,C extends PermAccessor<T>> implements NodeBase<T, C> {

    private final CommandNode<T> baseNode;
    private final ContextProducer<T> factory;

    private final C accessor;
    private final PermissionStrategy strategy;

    private final FallbackHandler<T> fallbackHandler;

    public <X> SimpleNodeBase(CommandNode<T> baseNode, ContextProducer<T> factory, C accessor, PermissionStrategy strategy, FallbackHandler<T> fallbackHandler) {
        this.baseNode = baseNode;
        this.factory = factory;
        this.accessor = accessor;
        this.strategy = strategy;
        this.fallbackHandler = fallbackHandler;
    }

    @Override
    public C getAccessor() {
        return accessor;
    }

    @Override
    public void execute(T t, String alias, String[] args) {
        BlockPath path = CommonBlockPath.of(args);

        GetNodeResult<T> result = baseNode.getSpecificNode(path);

        result.resultingNode().ifPresentOrElse(node -> {

            //TODO some kind of thing here
            NodeContext<T> adapter = factory.produce(t,alias,args,node,baseNode,path, result.resultingPath());

            node.getExecutionHandler().handle(adapter);

        }, () -> fallbackHandler.handle(factory.produce(t, alias, args)));
    }

    @Override
    public List<String> suggest(T t, String alias, String[] args) {
        return null;
    }
}
