package me.aurium.beetle.branch.examples;

import me.aurium.beetle.branch.CommandNode;
import me.aurium.beetle.branch.adapter.ContextAdapter;
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
        new BranchingBuilder<String>().something(new SingleBuilder<>(),shit -> {
            shit.withIdentifier(StringBlock.of("Sup"));
            shit.withHandler(context -> {
                ContextAdapter<String> s = context;
                //as you can see it's actually typed correctly now (s is a ContextAdapter<String>)
            });
        });


        return null;
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
