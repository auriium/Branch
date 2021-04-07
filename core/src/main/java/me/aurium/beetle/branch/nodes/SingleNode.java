package me.aurium.beetle.branch.nodes;

import me.aurium.beetle.branch.block.Block;
import me.aurium.beetle.branch.interfacing.responses.SendableResponse;
import me.aurium.beetle.branch.interfacing.CoreKeys;
import me.aurium.beetle.branch.handlers.api.BranchHandler;
import me.aurium.beetle.branch.handlers.api.ExecutionHandler;
import me.aurium.beetle.branch.handlers.api.Execution;
import me.aurium.beetle.branch.handlers.context.NodeContext;
import me.aurium.beetle.branch.nodes.model.EndpointNode;
import me.aurium.beetle.branch.nodes.results.SearchInput;
import me.aurium.beetle.branch.nodes.results.SearchInfo;
import me.aurium.beetle.branch.fallback.permissions.Permission;
import me.aurium.beetle.branch.nodes.results.model.Result;

import java.util.ArrayList;
import java.util.List;

public class SingleNode<T> implements EndpointNode<T> {

    private final Block identifier;
    private final Permission<T> permission;

    private final SingleHandler<T> handler;

    public SingleNode(Block identifier, ExecutionHandler<T> executionHandler, Permission<T> permission) {
        this.identifier = identifier;

        this.handler = new SingleHandler<>(executionHandler);
        this.permission = permission;
    }

    @Override
    public Block getIdentifier() {
        return identifier;
    }

    @Override
    public SearchInfo<T> getSpecificNode(SearchInput input) {
        input.getReducablePath().removeFirst(); //consume

        return new SearchInfo<>(this,input);
    }

    @Override
    public BranchHandler<T> getHandling() {
        return handler;
    }


    @Override
    public Permission<T> getPermission() {
        return permission;
    }

    public static class SingleHandler<T> implements BranchHandler<T> {

        private final ExecutionHandler<T> handler;

        public SingleHandler(ExecutionHandler<T> handler) {
            this.handler = handler;
        }

        @Override
        public Result<Execution> getExecution(NodeContext<T> context) {
            context.getResults().reducedPath().removeFirst();

            if (context.getResults().hasMoreArguments()) {
                return Result.fail(new TooManyArgumentsBlurb());
            }

            return Result.success(new Execution(() -> {
                handler.handle(context);
            }));
        }

        @Override
        public List<String> getSuggestions(NodeContext<T> context) {
            return new ArrayList<>();
        }

    }

    public static class TooManyArgumentsBlurb extends SendableResponse {

        public TooManyArgumentsBlurb() {
            super(CoreKeys.TOO_MANY_ARGS);
        }

    }


}
