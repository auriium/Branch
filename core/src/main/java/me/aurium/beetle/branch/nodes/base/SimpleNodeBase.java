package me.aurium.beetle.branch.nodes.base;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.block.CommonBlockPath;
import me.aurium.beetle.branch.context.ContextProducer;
import me.aurium.beetle.branch.context.StagedContext;
import me.aurium.beetle.branch.context.StagedContextImpl;
import me.aurium.beetle.branch.handlers.api.FallbackHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.nodes.result.GetNodeResult;
import me.aurium.beetle.branch.permission.FallbackStrategy;

import java.util.List;

public class SimpleNodeBase<T> implements NodeBase<T> {

    private final CommandNode<T> baseNode;
    private final ContextProducer<T> factory;

    private final FallbackStrategy<T> strategy;
    private final FallbackHandler<T> fallbackHandler;

    public <X> SimpleNodeBase(CommandNode<T> baseNode, ContextProducer<T> factory, FallbackStrategy<T> strategy, FallbackHandler<T> fallbackHandler) {
        this.baseNode = baseNode;
        this.factory = factory;
        this.strategy = strategy;
        this.fallbackHandler = fallbackHandler;
    }

    @Override
    public void execute(T t, String alias, String[] args) {
        BlockPath path = CommonBlockPath.of(args);

        GetNodeResult<T> result = baseNode.getSpecificNode(path);

        result.resultingNode().ifPresentOrElse(node -> { //this should always be present, if it isn't that means something went wrong, so fallback!

            StagedContext<T> context = new StagedContextImpl<>(t,alias,args,node,baseNode,path,result.resultingPath(), fallbackHandler);

            strategy.strategy(context).handle(context.stage(factory));

        }, () -> fallbackHandler.handle(factory.produce(t, alias, args)));
    }

    @Override
    public List<String> suggest(T t, String alias, String[] args) {
        return null;
    }
}
