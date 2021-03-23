package me.aurium.beetle.branch.tests.context;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.context.Context;
import me.aurium.beetle.branch.context.ContextProducer;
import me.aurium.beetle.branch.context.NodeContext;
import me.aurium.beetle.branch.nodes.api.CommandNode;

public class TestContextProducer implements ContextProducer<String> {

    @Override
    public NodeContext<String> produce(String s, String alias, String[] strings, CommandNode<String> executedNode, CommandNode<String> baseNode, BlockPath executedPath, BlockPath fullPath) {
        return new TestContext(s,alias,strings,executedNode,baseNode, executedPath, fullPath);
    }

    @Override
    public Context<String> produce(String s, String alias, String[] strings) {
        return new TestContext(s,alias,strings,null,null,null,null);
    }
}
