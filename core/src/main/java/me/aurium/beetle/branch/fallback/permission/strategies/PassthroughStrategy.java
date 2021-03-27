package me.aurium.beetle.branch.fallback.permission.strategies;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.block.CommonBlockPath;
import me.aurium.beetle.branch.handlers.context.ContextProducer;
import me.aurium.beetle.branch.handlers.api.FallbackHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.nodes.result.NodeResult;

/**
 * Ignores everything and tries to execute ignoring permissions or fallbacks. If something goes wrong it delegates to the fallback handler immediately
 * @param <T>
 */
public class PassthroughStrategy<T> implements ExecutionFallbackStrategy<T> {
    @Override
    public void executeStrategy(T sender, String alias, String[] args, CommandNode<T> baseNode, FallbackHandler<T> fallback, ContextProducer<T> producer) {
        BlockPath path = CommonBlockPath.of(args);

        NodeResult<T> result = baseNode.getSpecificNode(path);

        result.resultingNode().getExecutionHandler().getExecution().ifPresentOrElse(
                present -> present.handle(producer.produce(sender,alias,args, result.resultingNode(), baseNode, result.resultingPath(), path)),
                () -> { fallback.handle(producer.produce(sender,alias,args));
        });
    }
}
