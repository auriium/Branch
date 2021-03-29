package me.aurium.beetle.branch.spigot;

import me.aurium.beetle.branch.block.BlockPath;
import me.aurium.beetle.branch.handlers.api.FallbackHandler;
import me.aurium.beetle.branch.handlers.context.Context;
import me.aurium.beetle.branch.handlers.context.ContextProducer;
import me.aurium.beetle.branch.handlers.context.NodeContext;
import me.aurium.beetle.branch.launchpoints.IllegalSenderException;
import me.aurium.beetle.branch.launchpoints.typeadapter.ManagerAdapter;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import org.bukkit.command.CommandSender;

public class SpigotContextProducer<C extends CommandSender> implements ContextProducer<C> {

    private final ManagerAdapter<CommandSender,C> adapter;

    public <T> SpigotContextProducer(ManagerAdapter<CommandSender,C> adapter) {
        this.adapter = adapter;
    }

    @Override
    public NodeContext<C> produce(C sender, String alias, String[] strings, CommandNode<C> executedNode, CommandNode<C> baseNode, BlockPath executedPath, BlockPath basePath, FallbackHandler<C> handler) {

        if (!adapter.canAdapt(sender)) {
            adapter.failedAdaptAction();

            throw new IllegalSenderException("Sender is not instance of correct type!"); //TODO more fallback bullshit :)
        }

        return new SpigotContext<>(adapter.adapt(sender), alias,strings,executedNode,baseNode,executedPath,basePath,handler);
    }

    @Override
    public Context<C> produce(C sender, String alias, String[] strings) {
        return produce(sender, alias, strings,null,null,null,null,null);
    }
}
