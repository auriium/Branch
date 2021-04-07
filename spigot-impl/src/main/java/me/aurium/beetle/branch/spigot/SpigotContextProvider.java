package me.aurium.beetle.branch.spigot;

import me.aurium.beetle.branch.fallback.message.BaseContext;
import me.aurium.beetle.branch.handlers.context.ContextProvider;
import me.aurium.beetle.branch.handlers.context.NodeContext;
import me.aurium.beetle.branch.launchpoints.IllegalSenderException;
import me.aurium.beetle.branch.launchpoints.typeadapter.ManagerAdapter;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;
import org.bukkit.command.CommandSender;

public class SpigotContextProvider<C extends CommandSender> implements ContextProvider<C> {

    private final ManagerAdapter<CommandSender,C> adapter;

    public <T> SpigotContextProvider(ManagerAdapter<CommandSender,C> adapter) {
        this.adapter = adapter;
    }


    @Override
    public NodeContext<C> produce(C sender, String alias, String[] strings, CommandNode<C> baseNode, SearchInfo<C> search, BaseContext<C> baseContext) {
        if (!adapter.canAdapt(sender)) {
            adapter.failedAdaptAction();

            //delegate to baseContext's stuff

            throw new IllegalSenderException("Sender is not instance of correct type!"); //TODO more fallback bullshit :)
        }

        return new SpigotContext<>(adapter.adapt(sender),alias,strings,baseNode,search,baseContext);
    }

    @Override
    public Context<C> produce(C sender, String alias, String[] strings) {
        return produce(sender, alias, strings,null,null,null);
    }
}
