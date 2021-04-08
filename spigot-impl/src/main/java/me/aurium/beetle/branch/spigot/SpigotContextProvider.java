package me.aurium.beetle.branch.spigot;


import me.aurium.beetle.branch.handlers.context.ContextProvider;
import me.aurium.beetle.branch.handlers.context.NodeContext;
import me.aurium.beetle.branch.interfacing.handlers.InterfacingHandler;
import me.aurium.beetle.branch.launchpoints.typeadapter.ManagerAdapter;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;
import org.bukkit.command.CommandSender;

public class SpigotContextProvider<C extends CommandSender> implements ContextProvider<C> {

    private final ManagerAdapter<CommandSender,C> adapter;
    private final InterfacingHandler<C> handler;

    public <T> SpigotContextProvider(ManagerAdapter<CommandSender, C> adapter, InterfacingHandler<C> handler) {
        this.adapter = adapter;
        this.handler = handler;
    }


    @Override
    public NodeContext<C> produce(C sender, String alias, String[] strings, CommandNode<C> baseNode, SearchInfo<C> search) {
        if (!adapter.canAdapt(sender)) {
            r
        }


        return new SpigotContext<>(sender,alias,strings,baseNode,search, handler);
    }
}
