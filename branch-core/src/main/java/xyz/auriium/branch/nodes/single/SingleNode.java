package xyz.auriium.branch.nodes.single;

import xyz.auriium.branch.execution.Block;
import xyz.auriium.branch.execution.api.ExecutionHandler;
import xyz.auriium.branch.fallback.permissions.EmptyPermission;
import xyz.auriium.branch.fallback.permissions.Permission;
import xyz.auriium.branch.centralized.information.description.Description;
import xyz.auriium.branch.centralized.information.description.StringDescription;

public class SingleNode<T> extends AbstractSingleNode<T> {

    private final Block identifier;
    private final Permission<T> permission;
    private final Description description;
    private final ExecutionHandler<T> handler;

    public SingleNode(Block identifier, Permission<T> permission, Description description, ExecutionHandler<T> handler) {
        this.identifier = identifier;
        this.permission = permission;
        this.description = description;
        this.handler = handler;
    }

    @Override
    public Permission<T> getPermission() {
        return permission;
    }

    @Override
    public Description getDescription() {
        return description;
    }

    @Override
    public Block getIdentifier() {
        return identifier;
    }

    @Override
    protected ExecutionHandler<T> getHandler() {
        return handler;
    }

    public static <T> SingleNode<T> of(Block id, ExecutionHandler<T> handler, Permission<T> permission, Description description) {
        return new SingleNode<T>(id,permission,description,handler);
    }

    public static <T> SingleNode<T> of(Block id, ExecutionHandler<T> handler) {
        return new SingleNode<T>(id,new EmptyPermission<>(),new StringDescription("default description"),handler);
    }

}
