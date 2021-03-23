package me.aurium.beetle.branch.converted.launchpoints;

import me.aurium.beetle.branch.context.ContextProducer;
import me.aurium.beetle.branch.nodes.base.SimpleNodeBase;
import me.aurium.beetle.branch.nodes.api.CommandNode;
import me.aurium.beetle.branch.nodes.base.NodeBase;
import me.aurium.beetle.branch.permission.Permission;

public class Implement extends AbstractBaseCommand<String> {
    private final ContextProducer<String> factory;

    protected Implement(ContextProducer<String> factory) {
        super(factory);

        this.factory = factory;
    }

    @Override
    public CommandNode<String> getBaseNode() {
        return null;
    }

    @Override
    public NodeBase<String, ?> getBase() {

        return new SimpleNodeBase<>(getBaseNode(), factory, new PermAccessor<String>() {
            @Override
            public boolean hasAccessToUse(String user, Permission permission) {

                return permission.attempt().test()

                return false;
            }

            @Override
            public boolean hasAccessToSee(String user, Permission permission) {
                return false;
            }



        }, null, null);

        /*return new SimpleNodeBase<>(baseNode, factory, new StringPermAccessor<String>() {

            @Override
            public boolean hasAccessToUse(String user, String permission) {
                return user.equalsIgnoreCase(permission);
            }

            @Override
            public boolean hasAccessToSee(String user, String permission) {
                return user.equalsIgnoreCase(permission);
            }

        }, strategy, fallbackHandler);*/
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
