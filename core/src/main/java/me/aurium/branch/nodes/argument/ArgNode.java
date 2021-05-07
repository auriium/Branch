package me.aurium.branch.nodes.argument;

import me.aurium.branch.execution.Block;
import me.aurium.branch.execution.NodeContext;
import me.aurium.branch.execution.api.BranchHandler;
import me.aurium.branch.execution.api.Execution;
import me.aurium.branch.fallback.permissions.Permission;
import me.aurium.branch.information.description.Description;
import me.aurium.branch.nodes.argument.types.Argument;
import me.aurium.branch.nodes.results.model.Result;
import me.aurium.branch.nodes.single.EndpointNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ArgNode<T> extends EndpointNode<T> {

    private final Block identifier;
    private final Permission<T> permission;
    private final Description description;
    private final List<Argument<T>> arguments;

    public ArgNode(Block identifier, Permission<T> permission, Description description, List<Argument<T>> arguments) {
        this.identifier = identifier;
        this.permission = permission;
        this.description = description;
        this.arguments = arguments;
    }

    @Override
    public BranchHandler<T> getHandling() {
        return null;
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

    public static final class ArgHandler<T> implements BranchHandler<T> {

        private final List<Argument<T>> arguments;

        public ArgHandler(List<Argument<T>> arguments) {
            this.arguments = arguments;
        }

        @Override
        public Execution<T> getExecution(NodeContext<T> context) {

            Deque<Block> subdeque = new ArrayDeque<>(context.getResults().reducedPath());



            return null;
        }

        @Override
        public List<String> getSuggestions(NodeContext<T> context) {
            return null;
        }
    }
}
