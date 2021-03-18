package me.aurium.beetle.branch.tests.mockups;

import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.adapter.ContextAdapterFactory;
import me.aurium.beetle.branch.builders.Base;
import me.aurium.beetle.branch.builders.SingleBuilder;
import me.aurium.beetle.branch.launchpoints.AbstractBranchCommand;
import me.aurium.beetle.branch.tests.mockups.MockupContext;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.Arrays;

/**
 * Fake command representing something like /helloworld that always says helloworld
 */
public class SingleCommand extends AbstractBranchCommand<String> {
    private final Logger log;

    public SingleCommand(ContextAdapterFactory<String> factory, Logger logger) {
        super(factory);

        this.log = logger;
    }

    @Override
    public CommandNode<String> getBaseNode() {
        return Base.base(new SingleBuilder<>(),builder -> {
            builder.withHandler(context -> {
                log.info(() -> "hello world!");

                log.info(() -> "The sender is: " + context.getSender());
                log.info(() -> "The arguments were: " + Arrays.toString(context.getArgs()));
                log.info(() -> "The path was: " + context.executedPath());
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
