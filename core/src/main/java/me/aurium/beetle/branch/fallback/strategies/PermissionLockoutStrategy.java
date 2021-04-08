package me.aurium.beetle.branch.fallback.strategies;

import me.aurium.beetle.branch.interfacing.common.NoPermissionResponse;
import me.aurium.beetle.branch.nodes.model.CommandNode;
import me.aurium.beetle.branch.nodes.results.SearchInfo;
import me.aurium.beetle.branch.nodes.results.SearchInput;
import me.aurium.beetle.branch.nodes.results.model.Result;

/**
 * Simple fallback strategy that if the sender has no permission to execute the command they are sent a failing response.
 * @param <T>
 */
public class PermissionLockoutStrategy<T> implements FallbackSearchStrategy<T> {
    @Override
    public Result<SearchInfo<T>> attemptPreprocess(T sender, String alias, String[] args, CommandNode<T> baseNode) {

        SearchInput input = SearchInput.of(args);
        SearchInfo<T> toBeExecuted = baseNode.getSpecificNode(input);

        if (!toBeExecuted.resultingNode().getPermission().attempt(sender, alias, args)) {
            return Result.fail(new NoPermissionResponse(toBeExecuted.resultingNode().getPermission().easyName()));
        }

        return Result.success(toBeExecuted);
    }
}
