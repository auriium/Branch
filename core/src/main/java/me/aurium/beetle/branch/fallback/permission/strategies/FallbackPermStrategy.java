package me.aurium.beetle.branch.fallback.permission.strategies;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.block.CommonBlockPath;
import me.aurium.beetle.branch.handlers.context.Context;
import me.aurium.beetle.branch.handlers.context.ContextProducer;
import me.aurium.beetle.branch.handlers.context.NodeContext;
import me.aurium.beetle.branch.handlers.api.FallbackHandler;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.nodes.result.NodeResult;

/**
 * Advanced startegy that does things:
 *
 * Parses a testing blockpath from existing args. It then finds the linked node from that path. There must be one,
 * because even incorrect args will link to the base node or to a branching node like the branch node implementation.
 *
 * It checks the permissions first. If the sender does not have access to that specific node, or the node is missing a handler
 * it will go one node up in the map and check it for permission. It will repeat this until it can find a permissible node,
 * or until it reaches the base node.
 *
 * If the user does not have access to run the base node for some reason, it will call the fallback handler.
 *
 * TODO please check the logic here.
 *
 * @param <T>
 */
public class FallbackPermStrategy<T> implements ExecutionFallbackStrategy<T> {

    //TODO a248, this is one of the most important classes. in depth logic review because all of this is untested
    // and i have no idea if it's gonna work haha. Also if you can think of a way to reduce the boilerplate of the while loops that'd
    // be nice but i'm pretty sure theyre essential

    @Override
    public void executeStrategy(T sender, String alias, String[] args, CommandNode<T> baseNode, FallbackHandler<T> fallback, ContextProducer<T> producer) {

        BlockPath pathToTest = CommonBlockPath.of(args);
        NodeResult<T> toBeExecuted = baseNode.getSpecificNode(pathToTest);

        Context<T> failed = producer.produce(sender,alias,args);

        //1. Check permissions and access

        while (!toBeExecuted.resultingNode().getPermission().attempt(sender, alias, args) || toBeExecuted.resultingNode().getExecutionHandler().getExecution().isEmpty()) {
            //something is wrong with the execution (e.g. wrong args or you did something bad), pass above one.

            if (toBeExecuted.resultingNode().equals(baseNode)) {

                fallback.handle(failed);

                return;

            } else {

                pathToTest = pathToTest.withoutTop();

                toBeExecuted = baseNode.getSpecificNode(pathToTest); //regress backwards a node
            }
        }

        NodeContext<T> produced = producer.produce(sender,alias,args, toBeExecuted.resultingNode(), baseNode, toBeExecuted.resultingPath(), pathToTest);

        toBeExecuted.resultingNode().getExecutionHandler().getExecution().get().handle(produced);
    }




}
