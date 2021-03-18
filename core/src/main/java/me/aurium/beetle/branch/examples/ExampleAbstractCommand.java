package me.aurium.beetle.branch.examples;

import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.adapter.ContextAdapterFactory;
import me.aurium.beetle.branch.builders.Base;
import me.aurium.beetle.branch.launchpoints.AbstractBranchCommand;
import me.aurium.beetle.branch.builders.SingleBuilder;

public class ExampleAbstractCommand extends AbstractBranchCommand<String> {

    public ExampleAbstractCommand(ContextAdapterFactory<String> factory) {
        super(factory);
    }

    @Override
    public CommandNode<String> getBaseNode() {
        return Base.base(new SingleBuilder<>(), baseNode -> {
            baseNode.withHandler(context -> {

            });
        });
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPermission() {
        return null;
    }
}
