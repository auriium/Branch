package xyz.auriium.branch.nodes.argument;

import xyz.auriium.branch.execution.Block;
import xyz.auriium.branch.fallback.permissions.EmptyPermission;
import xyz.auriium.branch.fallback.permissions.Permission;
import xyz.auriium.branch.interfacing.information.description.Description;
import xyz.auriium.branch.interfacing.information.description.StringDescription;

import java.util.List;

/**
 * Argument-consuming node. The most important part of branch (not)
 *
 * @param <T> input type
 */
public class ArgNode<T> extends AbstractArgNode<T> {

    private final Block identifier;
    private final Permission<T> permission;
    private final Description description;
    private final List<ContextualBaseArgument<T,?>> arguments;
    private final ArgumentContextHandler<T> handler;

    public ArgNode(Block identifier, Permission<T> permission, Description description, List<ContextualBaseArgument<T, ?>> arguments, ArgumentContextHandler<T> handler) {
        this.identifier = identifier;
        this.permission = permission;
        this.description = description;
        this.arguments = arguments;
        this.handler = handler;
    }

    public static <T> ArgNode<T> of(Block identifier, Permission<T> permission, Description description, List<ContextualBaseArgument<T, ?>> arguments, ArgumentContextHandler<T> handler) {
        return new ArgNode<>(identifier, permission, description, arguments, handler);
    }

    public static <T> ArgNode<T> of(Block identifier, List<ContextualBaseArgument<T,?>> arguments, ArgumentContextHandler<T> handler) {
        return new ArgNode<>(identifier, new EmptyPermission<>(), new StringDescription("TODO"), arguments, handler); //TODO impl
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
    protected List<ContextualBaseArgument<T, ?>> getArguments() {
        return arguments;
    }

    @Override
    protected ArgumentContextHandler<T> getContextHandler() {
        return handler;
    }
}
