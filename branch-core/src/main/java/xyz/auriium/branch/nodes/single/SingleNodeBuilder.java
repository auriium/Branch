package xyz.auriium.branch.nodes.single;

import xyz.auriium.branch.base.execution.ExecutionHandler;
import xyz.auriium.branch.base.permissions.EmptyPermission;
import xyz.auriium.branch.base.permissions.Permission;
import xyz.auriium.branch.nodes.description.Description;
import xyz.auriium.branch.nodes.description.StringDescription;

import java.util.Objects;

@Deprecated //TODO undeprecate when all builders are done. for now, use each node's static method
public final class SingleNodeBuilder<T> {


    private final String identifier;
    private Permission<T> permission;
    private Description description;
    private ExecutionHandler<T> handler;

    SingleNodeBuilder(String identifier) {
        this.identifier = identifier;
    }

    public static <T> SingleNodeBuilder<T> builder(String identifier) {
        return new SingleNodeBuilder<>(identifier);
    }

    public SingleNodeBuilder<T> withPermission(Permission<T> permission) {
        this.permission = permission;
        return this;
    }

    public SingleNodeBuilder<T> withDescription(Description description) {
        this.description = description;
        return this;
    }

    public SingleNodeBuilder<T> withHandler(ExecutionHandler<T> handler) {
        this.handler = handler;
        return this;
    }

    public SingleNode<T> build() {

        return new SingleNode<>(
                identifier,
                Objects.requireNonNullElse(permission, EmptyPermission.instance()),
                Objects.requireNonNullElse(description, new StringDescription("Default description")),
                handler
        );
    }
}
