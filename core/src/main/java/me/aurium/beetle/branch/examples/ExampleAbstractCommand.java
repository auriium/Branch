package me.aurium.beetle.branch.examples;

import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.adapter.ContextAdapterFactory;
import me.aurium.beetle.branch.block.StringBlock;
import me.aurium.beetle.branch.launchpoints.AbstractBranchCommand;
import me.aurium.beetle.branch.nodes.branching.BranchingBuilder;
import me.aurium.beetle.branch.nodes.single.SingleBuilder;

public class ExampleAbstractCommand extends AbstractBranchCommand<String> {

    public ExampleAbstractCommand(ContextAdapterFactory<String> factory) {
        super(factory);
    }

    @Override
    public CommandNode<String> getBaseNode() {
        return new BranchingBuilder<String>()
                .withBuilder(BranchingBuilder.make()).build();
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
