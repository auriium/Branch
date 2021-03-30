package me.aurium.beetle.branch.launchpoints.base;

import me.aurium.beetle.branch.fallback.message.BaseContext;
import me.aurium.beetle.branch.handlers.context.ContextProducer;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.fallback.permission.strategies.ExecutionFallbackStrategy;

import java.util.List;

public class SimpleNodeBase<C> implements NodeBase<C> {

    private final CommandNode<C> baseNode;
    private final ContextProducer<C> factory;

    private final BaseContext<C> baseContext;
    private final ExecutionFallbackStrategy<C> strategy;

    public <X> SimpleNodeBase(CommandNode<C> baseNode, ContextProducer<C> factory, BaseContext<C> baseContext, ExecutionFallbackStrategy<C> strategy) {

        this.baseNode = baseNode;
        this.factory = factory;
        this.baseContext = baseContext;
        this.strategy = strategy;
    }

    @Override
    public void execute(C executor, String alias, String[] args) {
        strategy.attemptPreprocess(executor,alias,args,baseNode).ifPresentOrElse(
                result -> strategy.attemptExecution(executor,alias,args,baseNode,result,baseContext,factory),
                //else
                () -> baseContext.getFallback().handle(factory.produce(executor, alias, args))
        );
    }

    @Override
    public List<String> suggest(C c, String alias, String[] args) {
        return null;
    }
}
