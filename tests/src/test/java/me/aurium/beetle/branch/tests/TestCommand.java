package me.aurium.beetle.branch.tests;

import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.adapter.ContextAdapterFactory;
import me.aurium.beetle.branch.builders.Base;
import me.aurium.beetle.branch.builders.SingleBuilder;
import me.aurium.beetle.branch.launchpoints.AbstractBranchCommand;

public class TestCommand extends AbstractBranchCommand<String> {
    protected TestCommand(ContextAdapterFactory<String> factory) {
        super(factory);
    }

    @Override
    public CommandNode<String> getBaseNode() {
        return Base.base(new SingleBuilder<>(),builder -> {
            builder.withHandler(context -> {
                context.getSender();

                System.out.println(context.getSender());
            });
        });
    }

    @Override
    public String getName() {
        return "testCommand";
    }

    @Override
    public String getPermission() {
        return "testPermission";
    }
}
