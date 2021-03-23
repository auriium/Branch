package me.aurium.beetle.branch.tests.mockups;

import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.context.ContextProducer;
import me.aurium.beetle.branch.builders.Base;
import me.aurium.beetle.branch.builders.SingleBuilder;
import me.aurium.beetle.branch.converted.launchpoints.AbstractBranchCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Fake command representing something like /helloworld that always says helloworld
 */
public class SingleCommand extends AbstractBranchCommand<String> {
    private final Logger log = LoggerFactory.getLogger(SingleCommand.class);

    public SingleCommand(ContextProducer<String> factory) {
        super(factory);
    }

    @Override
    public CommandNode<String> getBaseNode() {
        return Base.base(new SingleBuilder<>(),builder -> {
            builder.withHandler(context -> {
                log.info("hello world!");

                log.info("The sender is: " + context.getSender());
                log.info("The arguments were: " + Arrays.toString(context.getArgs()));
                log.info("The path was: " + context.executedPath());
            });
        });
    }

    @Override
    public String getName() {
        return "helloworld";
    }

    @Override
    public String getPermission() {
        return "testPermission";
    }
}
