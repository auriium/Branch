package xyz.auriium.branch.nodes.single;

import xyz.auriium.branch.base.execution.ExecutionHandler;
import xyz.auriium.branch.base.execution.blocks.EndpointBlock;
import xyz.auriium.branch.base.permissions.EmptyPermission;
import xyz.auriium.branch.base.permissions.Permission;
import xyz.auriium.branch.nodes.description.Description;
import xyz.auriium.branch.nodes.description.StringDescription;

public class SingleNode<T> extends AbstractSingleNode<T> {

    private final EndpointBlock identifier;
    private final Permission<T> permission;
    private final Description description;
    private final ExecutionHandler<T> handler;

    public SingleNode(String identifier, Permission<T> permission, Description description, ExecutionHandler<T> handler) {
        this.identifier = new EndpointBlock(identifier);
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
    public EndpointBlock getIdentifier() {
        return identifier;
    }

    @Override
    protected ExecutionHandler<T> getHandler() {
        return handler;
    }

    public static <T> SingleNode<T> of(String id, ExecutionHandler<T> handler, Permission<T> permission, Description description) {
        return new SingleNode<>(id, permission, description, handler);
    }

    public static <T> SingleNode<T> of(String id, ExecutionHandler<T> handler) {
        return new SingleNode<>(id, EmptyPermission.instance(), new StringDescription("default description"), handler);
    }

}
