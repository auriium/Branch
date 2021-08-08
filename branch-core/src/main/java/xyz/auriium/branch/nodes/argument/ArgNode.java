package xyz.auriium.branch.nodes.argument;

import xyz.auriium.branch.base.execution.blocks.EndpointBlock;
import xyz.auriium.branch.base.permissions.EmptyPermission;
import xyz.auriium.branch.base.permissions.Permission;
import xyz.auriium.branch.nodes.description.Description;
import xyz.auriium.branch.nodes.description.StringDescription;
import xyz.auriium.branch.nodes.argument.model.ContextualBaseArgument;

import java.util.List;

/**
 * Argument-consuming node. The most important part of branch (not)
 *
 * @param <T> input type
 */
public class ArgNode<T> extends AbstractArgNode<T> {

    private final EndpointBlock identifier;
    private final Permission<T> permission;
    private final Description description;
    private final List<ContextualBaseArgument<T,?>> arguments;
    private final ArgumentContextHandler<T> handler;

    public ArgNode(EndpointBlock identifier, Permission<T> permission, Description description, List<ContextualBaseArgument<T, ?>> arguments, ArgumentContextHandler<T> handler) {
        this.identifier = identifier;
        this.permission = permission;
        this.description = description;
        this.arguments = arguments;
        this.handler = handler;
    }

    public static <T> ArgNode<T> of(String identifier, Permission<T> permission, Description description, List<ContextualBaseArgument<T, ?>> arguments, ArgumentContextHandler<T> handler) {
        return new ArgNode<>(new EndpointBlock(identifier), permission, description, arguments, handler);
    }

    public static <T> ArgNode<T> of(String identifier, List<ContextualBaseArgument<T,?>> arguments, ArgumentContextHandler<T> handler) {
        return new ArgNode<>(new EndpointBlock(identifier), EmptyPermission.instance(), new StringDescription("TODO"), arguments, handler); //TODO impl
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
    protected List<ContextualBaseArgument<T, ?>> getArguments() {
        return arguments;
    }

    @Override
    protected ArgumentContextHandler<T> getContextHandler() {
        return handler;
    }
}
