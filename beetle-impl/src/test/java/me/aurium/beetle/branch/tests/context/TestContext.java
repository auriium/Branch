package me.aurium.beetle.branch.tests.context;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.context.AbstractNodeContext;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestContext extends AbstractNodeContext<String> {

    private final Logger logger = LoggerFactory.getLogger(TestContext.class);

    protected TestContext(String s, String alias, String[] args, CommandNode<String> executed, CommandNode<String> base, BlockPath executedPath, BlockPath fullPath) {
        super(s, alias, args, executed, base, executedPath, fullPath);
    }

    @Override
    public void messageSender(String string) {
        logger.info(string);
    }
}
