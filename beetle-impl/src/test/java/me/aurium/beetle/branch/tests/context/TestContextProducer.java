package me.aurium.beetle.branch.tests.context;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.context.Context;
import me.aurium.beetle.branch.context.ContextProducer;
import me.aurium.beetle.branch.context.NodeContext;
import me.aurium.beetle.branch.nodes.CommandNode;

public class TestContextProducer implements ContextProducer<String> {

    @Override
    public NodeContext<String> produce(String sender, String alias, String[] strings, CommandNode<String> executedNode, CommandNode<String> baseNode, BlockPath executedPath, BlockPath basePath) {
        return new TestContext(sender,alias,strings,executedNode,baseNode, executedPath, basePath);
    }

    @Override
    public Context<String> produce(String sender, String alias, String[] strings) {
        return new TestContext(sender,alias,strings,null,null,null,null);
    }
}
